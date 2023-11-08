package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.MoneyAmountException;
import lotto.exception.ValueException;

public class MoneyReader {
        public static int money_reader() {
            try {
                String value = Console.readLine();
                ValueException.validateNumber(value);
                int number = Integer.parseInt(value);
                MoneyAmountException.money_reader(number);
                return number;
            } catch (IllegalStateException e) {
                System.out.println("[ERROR]다시입력하세요");
                return money_reader(); // 예외가 발생한 경우 다시 입력하도록 재귀 호출
            }
        }
}
