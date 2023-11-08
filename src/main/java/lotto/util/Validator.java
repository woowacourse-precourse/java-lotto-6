package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Validator {
    public static void validateStringMoney(String money) {
        if (money.matches(".*\\D+.*"))
            throw new IllegalArgumentException("금액에 정수가 아닌 값이 포함되어 있습니다");
    }

    public static void validateIntegerMoney(Integer money) {
        if (money <= 0)
            throw new IllegalArgumentException("금액은 0 이상의 정수가 되어야 합니다");
        if (money % 1000 != 0)
            throw new IllegalArgumentException("입력한 금액은 1000원으로 나누어 떨어져야 합니다");

    }
    public static void validateLottoNumbers(List<Integer> lottoNumberList) {

        // 중복이 있으면 exception
//        boolean hasNumberBiggerThan45 = lottoNumberList.stream().anyMatch(a -> a > 45);

        if (lottoNumberList.stream().anyMatch(a -> a > 45))
            throw new IllegalArgumentException("로또 번호는 45이하 이어야 합니다");
        if (lottoNumberList.stream().anyMatch(a -> a < 1))
            throw new IllegalArgumentException("로또 번호는 1이상 이어야 합니다 ");

    }
}


