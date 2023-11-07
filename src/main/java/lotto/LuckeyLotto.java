package lotto;

import java.util.List;

public class LuckeyLotto {
    private static final String WRONG_TYPE_LOTTO_BONUS_NUMBER_MESSAGE = "[ERROR] 보너스 로또 번호의 타입은 숫자이어야 합니다.";
    private static final String WRONG_SAME_LOTTO_BONUS_NUMBER_MESSAGE = "[ERROR] 보너스 로또 번호는 중복없는 숫자이어야 합니다.";
    private static final String WRONG_RANGE_LOTTO_BONUS_NUMBER_MESSAGE = "[ERROR] 보너스 로또 번호는 1부터 45사이의 숫자여야 합니다.";
    private static final int LOTTO_NUMBER_RANGE_START = 1;
    private static final int LOTTO_NUMBER_RANGE_END = 45;
    private int luckeyBonusNumber;
    private List<Integer> luckeyNumbers;

    public LuckeyLotto(List<Integer> luckeyNumbers, String inputBonusNumber) {
        validate(luckeyNumbers, inputBonusNumber);
        int luckeyBonusNumber = Integer.valueOf(inputBonusNumber);
        luckeyNumbers.add(luckeyBonusNumber);
        this.luckeyNumbers = luckeyNumbers;
        this.luckeyBonusNumber = luckeyBonusNumber;
    }

    private void validate(List<Integer> luckeyNumbers, String inputBonusNumber) {
        if (!inputBonusNumber.matches("\\d+")) {
            throw new IllegalArgumentException(WRONG_TYPE_LOTTO_BONUS_NUMBER_MESSAGE);
        } else if (luckeyNumbers.contains(Integer.valueOf(inputBonusNumber))) {
            throw new IllegalArgumentException(WRONG_SAME_LOTTO_BONUS_NUMBER_MESSAGE);
        } else if (!isWithValidRange(Integer.valueOf(inputBonusNumber))) {
            throw new IllegalArgumentException(WRONG_RANGE_LOTTO_BONUS_NUMBER_MESSAGE);
        }
    }

    private boolean isWithValidRange(int inputBonusNumber) {
        return inputBonusNumber >= LOTTO_NUMBER_RANGE_START
                && inputBonusNumber <= LOTTO_NUMBER_RANGE_END;
    }
}
