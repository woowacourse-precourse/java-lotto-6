package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.NumberException;

public class Read {
        public static int reader(){
            String value = Console.readLine();
            NumberException.validateNumber(value);
            int number = Integer.parseInt(value);
            return number;
        }
}
