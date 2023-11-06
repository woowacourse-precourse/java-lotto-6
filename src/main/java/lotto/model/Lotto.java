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
        validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public void validateLottoNumbers(List<Integer> numbers) {
        Validation.validateSixLottoNumbers(numbers);
        Validation.validateDuplicatedSixNumber(numbers);
    }

    public List<Integer> getWinningNumbers() {
        return numbers;
    }
    public static List<List<Integer>> getManyLotto(int count) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = START_INDEX; i < count; i++) {
            List<Integer> randomNum = Randoms.pickUniqueNumbersInRange(1,45,6);
            result.add(getSingleLotto(randomNum));
        }
        return result;
    }
    public static List<Integer> getSingleLotto(List<Integer> randomNum) {
        List<Integer> oneLotto = new ArrayList<>(randomNum);
        Collections.sort(oneLotto);
        return oneLotto;
    }
}
