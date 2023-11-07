package lotto.model;

import static lotto.constants.MarksAndConstants.MAX_LOTTO_NUM;
import static lotto.constants.MarksAndConstants.MIN_LOTTO_NUM;
import static lotto.constants.MarksAndConstants.NEEDED_LOTTO_NUM;
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

    public static List<List<Integer>> getManyLotto(int count) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = START_INDEX; i < count; i++) {
            result.add(getSingleLotto(getRandomNum()));
        }
        return result;
    }

    public static List<Integer> getSingleLotto(List<Integer> randomNum) {
        List<Integer> oneLotto = new ArrayList<>(randomNum);
        Collections.sort(oneLotto);
        return oneLotto;
    }

    private static List<Integer> getRandomNum() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, NEEDED_LOTTO_NUM);
    }

    public List<Integer> getWinningNumbers() {
        return numbers;
    }
}
