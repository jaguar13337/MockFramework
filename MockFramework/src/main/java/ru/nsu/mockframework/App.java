/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ru.nsu.mockframework;

import javassist.*;


public class App {

    @Mock
    private static TestClass kektest;


    private static void preTest() {
        try {
            ClassPool cp = ClassPool.getDefault();
            CtClass cc = cp.get("ru.nsu.mockframework.TestClass");
            int modifiers = cc.getModifiers();
            if(Modifier.isFinal(modifiers)) {
                int notFinalModifier = Modifier.clear(modifiers, Modifier.FINAL);
                cc.setModifiers(notFinalModifier);
            }
            cc.toClass();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private static TestClass mock() {
//        //preTest();
//        ClassPool cp = ClassPool.getDefault();
//        CtClass cc = cp.makeClass("Mock");
//        try {
//            if (!cc.isFrozen()) {
//                CtClass s = cp.get("ru.nsu.mockframework.TestClass");
//                cc.setSuperclass(s);
//                //cc.removeMethod(cc.getDeclaredMethod("test"));
//                cc.addMethod(CtMethod.make("public void test() {System.out.println(\"mock\");}", cc));
//            }
//            return (TestClass) cc.toClass().getDeclaredConstructor().newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return new TestClass();
//    }

    private static void test() {
        preTest();
        TestClass test = new TestClass();
        test.test();
        test = JMock.mock(TestClass.class);
        test.test(); //TODO add whenThen...
        JMockAnnotations.initMocks(App.class);
        kektest.test();

    }

    public static void main(String[] args) {
        test();
    }
}
