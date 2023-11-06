package lotto.utils;

import camp.nextstep.edu.missionutils.Console;

public class LottoUtil {

    public String getUserInput() {
        return Console.readLine();
    }

    public boolean validateNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionMessage.NUMBER.getValue());
            return false;
        }

        return true;
    }

}
