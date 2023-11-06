package lotto.model;

import static lotto.model.Lotto.LOTTO_MAX_NUMBER;
import static lotto.model.Lotto.LOTTO_MIN_NUMBER;

import java.util.Arrays;
import java.util.List;

public class WinningLotto {
    private static final String SPLIT_SENTENCE = ",";
    private static final String POSITIVE_NUMBER_PATTERN = "\\d+$";

    private final Lotto lotto;
    private final int bonus;

    public WinningLotto(String lottoInput, String bonusInput) {
        lotto = new Lotto(changeInputToNumbers(lottoInput));
        bonus = changeInputToBonus(bonusInput);
    }

    public int getBonus() {
        return bonus;
    }

    public List<Integer> getLottoNums() {
        return lotto.getNumbers();
    }

    private List<Integer> changeInputToNumbers(String lottoInput) {
        return Arrays.stream(lottoInput.split(SPLIT_SENTENCE))
                .filter(this::isPositiveNumber)
                .map(Integer::parseInt)
                .toList();
    }

    private Integer changeInputToBonus(String bonusInput) {
        isPositiveNumber(bonusInput);
        int bonusNum = Integer.parseInt(bonusInput);
        isInRangeNumbers(bonusNum);
        isInLotto(bonusNum);
        return bonusNum;
    }

    private Boolean isPositiveNumber(String target) {
        if (!target.matches(POSITIVE_NUMBER_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표(,)를 기준으로 양의 정수만 입력해주세요.");
        }
        return true;
    }

    private void isInRangeNumbers(int bonusNum) {
        if (bonusNum < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < bonusNum) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 " + LOTTO_MIN_NUMBER + "이상" + LOTTO_MAX_NUMBER + "이하인 값만 입력하세요");
        }
    }

    private void isInLotto(int bonusNum) {
        if (lotto.getNumbers().contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨 번호에 포함되지 않은 숫자를 선택해야 합니다.");
        }
    }
}
