package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.NumberException;
import lotto.exception.ValueException;

public class Read {
        public static int reader(){
            String value = Console.readLine();
            System.out.println(value);
            ValueException.validateNumber(value);
            int number = Integer.parseInt(value);
            NumberException.money(number);
            return number;
        }
}
