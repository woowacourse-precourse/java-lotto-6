package lotto.ui;

import lotto.constance.PrintConst;

public class Writer {

    private Writer() {
    }

    public static void printEmtpyLine() {
        System.out.println();
    }

    public static void printGuide(String guide) {
        System.out.println(guide);
    }

    public static void printException(IllegalArgumentException e){
        System.out.println(PrintConst.EXCEPTION_PREFIX + e.getMessage());
    }

    public static void printUsingFormat(String format, Object... args){
        System.out.printf(format, args);
        System.out.println();
    }
}
