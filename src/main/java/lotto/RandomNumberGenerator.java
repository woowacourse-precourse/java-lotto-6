package lotto;

import static lotto.Constants.LOTTO_BONUS_NUMBERS_COUNTS;
import static lotto.Constants.LOTTO_NUMBERS_COUNTS;
import static lotto.Constants.LOTTO_NUMBER_END_EXCLUSIVE;
import static lotto.Constants.LOTTO_NUMBER_START_INCLUSIVE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {

    private List<Integer> numbers;

    private List<Integer> bonusNumbers;

    public List<Integer> GenerateLottoNumbers() {
        numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START_INCLUSIVE, LOTTO_NUMBER_END_EXCLUSIVE,
                LOTTO_NUMBERS_COUNTS);
        return numbers;
    }

    public List<Integer> GenerateBonusNumber() {
        bonusNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START_INCLUSIVE, LOTTO_NUMBER_END_EXCLUSIVE,
                LOTTO_BONUS_NUMBERS_COUNTS);
        return bonusNumbers;
    }



}
