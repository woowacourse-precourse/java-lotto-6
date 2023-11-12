package lotto.domain;

import java.util.List;

public class Exception {

    public static int CheckValidateInput(String number) {
        try {
            for (char a : number.toCharArray()) {
                if (a < '0' || a > '9') {
                    throw new IllegalArgumentException();
                }
            }
            return 1;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 숫자만 입력하여야 합니다.");
        }
        return 0;
    }

    public static int CheckWinnerNumber(String[] result) {
        if (result.length != 6) {
            System.out.println("[ERROR] 당첨 번호의 총 갯수는 6개여야 합니다.");
            return 0;
        }

        for (String a : result) {
            if (CheckValidateInput(a) == 0 || CheckValidateNumber(Integer.parseInt(a)) == 0) {
                return 0;
            }
        }
        return 1;
    }

    public static int CheckValidateNumber(int number) {
        try {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
            return 1;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return 0;
    }

    public static int CheckPriceValidate(Long number) {
        try {
            if (number % 1000 > 0) {
                throw new IllegalArgumentException();
            }
            return 1;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
        }
        return 0;
    }

    public static int CheckOverlapWinnernumber(int number, List<Integer> winner_number) {
        if (winner_number.contains(number)) {
            System.out.println("[ERROR] 당첨 번호와 보너스 번호는 중복되어선 안됩니다.");
            return 0;
        }
        return 1;
    }

}
