package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.Validation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validation.validateSixLottoNumbers(numbers);
        Validation.validateDuplicatedSixNumber(numbers);
    }
    public static List<List<Integer>> getManyLotto(int count) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(getOneLotto());
        }
        return result;
    }
    private static List<Integer> getOneLotto() {
        List<Integer> oneLotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
        Collections.sort(oneLotto);
        return oneLotto;
    }
    public void validateDuplicatedBonusNum(int bonusNum) {
        Validation.validateDuplicatedBonusNum(bonusNum, numbers);
    }
    public int getSameNumberCount(List<Integer> oneLotto) {
        int matched = 0;
        for (Integer num : oneLotto) {
            if (numbers.contains(num)) {
                matched++;
            }
        }
        return matched;
    }
}
