package com.hiya.dynamicProxy.javassist;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

public class JavassistGenerator
{
    public static void main(String[] args) throws IOException, CannotCompileException
    {
        ClassPool pool = ClassPool.getDefault();
        // ����Programmer��
        CtClass cc = pool.makeClass("com.samples.Programmer");
        // ����code����
        CtMethod method = CtNewMethod.make("public void code(){}", cc);
        // ���뷽������
        method.insertBefore("System.out.println(\"I'm a Programmer,Just Coding.....\");");
        cc.addMethod(method);
        // �������ɵ��ֽ���
        cc.writeFile("d://temp");
    }
}
