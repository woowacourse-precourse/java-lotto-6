package lotto.exception;

import lotto.io.Read;

public class NumberException {
    public static void money(int input) {
        try {
            if (input % 1000 != 0) {
                throw new NumberFormatException("알맞는 값이 아닙니다 다시 입력 하세요");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            Read.reader(); // 예외가 발생한 경우에 실행됩니다.
        }
    }
}