package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.NumberException;
import lotto.exception.ValueException;

public class MoneyReader {
        public static int money_reader(){
            String value = Console.readLine();
            System.out.println(value+"원");
            ValueException.validateNumber(value);
            int number = Integer.parseInt(value);
            NumberException.money_reader(number);
            return number;
        }
}
