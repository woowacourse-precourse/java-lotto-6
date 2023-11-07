package lotto.utils;

import java.util.List;

import lotto.domain.JackpotNumber;

public class JackpotNumberException {
    static final String NUMBER_IN_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    static final String NUMBER_DUPLICATED = "[ERROR] 로또 번호는 모두 중복되지 않은 수여야 합니다.";
    static final String NUMBER_SIX_VALUES = "[ERROR] 로또 번호는 6개여야 합니다.";

    static final String BONUS_NUMBER_REPEATED = "[ERROR] 보너스 넘버와 로또 번호가 중복되지 않아야합니다.";

    public static void isJackpotValid(JackpotNumber jackpotNumber) {
        isJackpotSixValue(jackpotNumber);
        isJackpotDuplicated(jackpotNumber);
        isJackpotRange(jackpotNumber);

    }
    public static void isBonusValid(JackpotNumber jackpotNumber) {
        isBounusNumberRepeated(jackpotNumber);
    }
    public static void isJackpotSixValue(JackpotNumber jackpotNumber) {
        List<Integer> numbers = jackpotNumber.getJackpot().getNumbers();
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBER_SIX_VALUES);
        }
    }
    public static void isJackpotDuplicated(JackpotNumber jackpotNumber) {
        List<Integer> numbers = jackpotNumber.getJackpot().getNumbers();
        if (numbers.stream()
                .distinct()
                .count() != numbers.size()) {
            throw new IllegalArgumentException(NUMBER_DUPLICATED);
        }
    }
    public static void isJackpotRange(JackpotNumber jackpotNumber) {
        for (int number: jackpotNumber.getJackpot().getNumbers()) {
            inRange(number);
        }
    }
    private static void inRange(int number) {
        if (1 > number || number > 45) {
            throw new IllegalArgumentException(NUMBER_IN_RANGE);
        }
    }
    public static void isBounusNumberRepeated(JackpotNumber jackpotNumber) {
        if (jackpotNumber.getJackpot().getNumbers().contains(jackpotNumber.getBonusNumber())) {
            throw new IllegalArgumentException(BONUS_NUMBER_REPEATED);
        }
    }

}
