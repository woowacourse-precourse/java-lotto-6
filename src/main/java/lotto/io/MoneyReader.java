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
                return money_reader(); // 예외가 발생한 경우 다시 입력하도록 재귀 호출
            }catch(NumberFormatException e){
                System.out.println("[ERROR]구입금액은 1000으로 나누어 떨어지는 값이어야 합니다. 다시 입력하세요");
                return money_reader();
            }
        }
}
