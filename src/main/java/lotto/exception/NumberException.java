package lotto.exception;

import lotto.io.MoneyReader;

public class NumberException {
    public static void money_reader(int input) {
        try {
            if (input % 1000 != 0) {
                throw new NumberFormatException("알맞는 값이 아닙니다 다시 입력 하세요");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            MoneyReader.money_reader(); // 예외가 발생한 경우에 실행됩니다.
        }
    }
}