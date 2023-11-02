package lotto.model;

import static lotto.constant.LottoRanking.FIFTH;
import static lotto.constant.LottoRanking.FIRST;
import static lotto.constant.LottoRanking.FOURTH;
import static lotto.constant.LottoRanking.NONE;
import static lotto.constant.LottoRanking.SECOND;
import static lotto.constant.LottoRanking.THIRD;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoRanking;

public class WinningNumber {

    private static final int WINNING_NUMBER_MIN = 1;
    private static final int WINNING_NUMBER_MAX = 45;

    private final List<Integer> numbers = new ArrayList<>();
    private final int bonusNumber;

    public WinningNumber(List<Integer> numbers) {
        this.numbers.addAll(numbers);
        bonusNumber = createBonusNumber();
    }

    private int createBonusNumber() {
        int bonusNumber = Randoms.pickNumberInRange(WINNING_NUMBER_MIN, WINNING_NUMBER_MAX);
        while (numbers.contains(bonusNumber)) {
            bonusNumber = Randoms.pickNumberInRange(WINNING_NUMBER_MIN, WINNING_NUMBER_MAX);
        }
        return bonusNumber;
    }

    public LottoRanking compareNumbers(List<Integer> lottoNumber) {
        long count = lottoNumber.stream().filter(numbers::contains).count();
        boolean isBonus = lottoNumber.stream().anyMatch(number -> number == bonusNumber);
        return toLottoRanking(count, isBonus);
    }

    private LottoRanking toLottoRanking(long count, boolean isBonus) {
        if (count == 6) {
            return FIRST;
        }
        if (count == 5 && isBonus) {
            return SECOND;
        }
        if (count == 5) {
            return THIRD;
        }
        if (count == 4) {
            return FOURTH;
        }
        if (count == 3) {
            return FIFTH;
        }
        return NONE;
    }
}
