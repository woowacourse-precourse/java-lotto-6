package lotto.util;

import java.util.HashSet;
import java.util.List;

public class Exception {
    public static int checkInvalidNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 숫자를 입력하셨습니다.");
        }
    }

    public static void checkDuplicationNumber(List<Integer> numbers){
        HashSet<Integer> duplicationNumber = new HashSet<>(numbers);
        if(duplicationNumber.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력하셨습니다.");
        }
    }

    public static void checkUnitPaymentAmount(int paymentAmount) {
        if (paymentAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public static void checkRangePaymentAmount(int paymentAmount) {
        if (paymentAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 이상만 입력 가능 합니다.");
        }
    }
}
