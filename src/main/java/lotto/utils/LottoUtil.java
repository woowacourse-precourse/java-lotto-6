package lotto.utils;

import camp.nextstep.edu.missionutils.Console;

public class LottoUtil {

    private int minMoney = 1000;

    public String getUserInput() {
        return Console.readLine();
    }

    public int getCount(String number) {
        return Integer.parseInt(number) / 1000;
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

    public boolean validateThousand(String number) {
        try {
            int num = Integer.parseInt(number);
            if(num % minMoney != 0 || num < minMoney) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionMessage.THOUSAND.getValue());
            return false;
        }

        return true;
    }

}
