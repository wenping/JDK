/*
 * Copyright (c) 2009, 2018, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */


package org.graalvm.compiler.jtt.except;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class Catch_Loop03 extends JTTTest {

    public static int test(int arg) {
        int accum = 0;
        for (int i = 0; i < arg; i++) {
            try {
                accum += div(20, i);
            } catch (Catch_Loop03_Exception1 e) {
                accum -= 100;
            }
        }
        return accum;
    }

    static int div(int a, int b) {
        if (b % 3 == 0) {
            throw new Catch_Loop03_Exception1();
        }
        return a / (b % 3);
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 4);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 5);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 6);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 7);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", 30);
    }

}

@SuppressWarnings("serial")
class Catch_Loop03_Exception1 extends RuntimeException {
}
