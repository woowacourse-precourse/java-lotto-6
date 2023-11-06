package lotto.exception;

import java.util.List;

public class Exceptions {
    private static final String REGEX = "\\d+";
    private static final int THOUSAND = 1000;
    private static final int ZERO = 0;
    private static final int MIN_LOTTO_VALUE = 1;
    private static final int MAX_LOTTO_VALUE = 45;

    public static void checkIsNumber(String message) {
        boolean isNotDigit = !message.matches(REGEX);

        if (isNotDigit) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    public static void checkIsThousandUnit(int amount) {
        if (amount % THOUSAND != ZERO) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위만 입력해주세요.");
        }
    }

    public static void checkIsNationalNumber(int amount) {
        if (amount <= ZERO) {
            throw new IllegalArgumentException("[ERROR] 21억 이하 자연수만 입력해주세요");
        }
    }

    public static void checkLottoRange(List<Integer> lotto) {
        lotto.forEach(Exceptions::checkLottoRange);
    }

    private static void checkLottoRange(int number) {
        if (number < MIN_LOTTO_VALUE || number > MAX_LOTTO_VALUE) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 1~45 사이 값만 입력해주세요.");
        }
    }

    public static void checkLottoDuplicate(List<Integer> lotto) {
        long distinctCount = lotto.stream().distinct().count();
        if (distinctCount != lotto.size()) {
            throw new IllegalArgumentException("[Error] 로또 숫자는 중복될 수 없습니다.");
        }
    }
}
