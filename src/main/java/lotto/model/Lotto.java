package lotto.model;

import static lotto.constants.MarksAndConstants.START_INDEX;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.Validation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberSize(numbers);
        this.numbers = numbers;
    }

    private void validateNumberSize(List<Integer> numbers) {
        Validation.validateSixLottoNumbers(numbers);
        Validation.validateDuplicatedSixNumber(numbers);
    }
    public void validateBonusNumDuplicated(int bonusNum) {
        Validation.validateDuplicatedBonusNum(bonusNum, numbers);
    }
    public static List<List<Integer>> getManyLotto(int count) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = START_INDEX; i < count; i++) {
            result.add(getSingleLotto());
        }
        return result;
    }
    private static List<Integer> getSingleLotto() {
        List<Integer> oneLotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
        Collections.sort(oneLotto);
        return oneLotto;
    }
    public int countSameNumber(List<Integer> oneLotto) {
        int matched = 0;
        for (Integer num : oneLotto) {
            if (numbers.contains(num)) {
                matched++;
            }
        }
        return matched;
    }
}
