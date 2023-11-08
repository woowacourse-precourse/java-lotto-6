package lotto;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;

import static lotto.constant.DefinedNumber.*;

public enum LottoWinningCase {
    UNRANK(0, List.of(0, 1, 2), 0),
    FIRST_PLACE(1, List.of(6), FIRST_PLACE_REWARD),
    SECONND_PLACE(2, List.of(5), SECOND_PLACE_REWARD),
    THRID_PLACE(3, List.of(5), THIRD_PLACE_REWARD),
    FOURTH_PLACE(4, List.of(4), FOURTH_PLACE_REWARD),
    FIFTH_PLACE(5, List.of(3), FIFTH_PLACE_REWARD);

    private final int place;
    private final List<Integer> numberMatchWithWinningLotto;
    private final int reward;

    LottoWinningCase(int place, List<Integer> numberMatchWithWinningLotto, int reward) {
        this.place = place;
        this.numberMatchWithWinningLotto = numberMatchWithWinningLotto;
        this.reward = reward;
    }

    public static LottoWinningCase compareWhichCaseItIs(Lotto myLottoNumbers, List<Integer> winningNumber, int bonusNumnber) {
        int matchCount = getHowManyMathch(myLottoNumbers, winningNumber);
        LottoWinningCase myCase = Arrays.stream(LottoWinningCase.values())
                .filter(lottoWinningCase -> lottoWinningCase.getNumberMatchWithWinningLotto().contains(matchCount))
                .findFirst()
                .orElse(null);
        if (matchCount == FIVE && !BonusNumberMatch(myLottoNumbers.getNumbers(), bonusNumnber)) {
            myCase = THRID_PLACE;
        }
        return myCase;
    }

    private static boolean BonusNumberMatch(List<Integer> myLottoNumbers, int bonusNumnber) {
        return myLottoNumbers.contains(bonusNumnber);
    }

    private static int getHowManyMathch(Lotto myLottoNumbers, List<Integer> winningNumber) {
        return (int) myLottoNumbers.getNumbers().stream()
                .filter(winningNumber::contains)
                .count();
    }

    public int getPlace() {
        return place;
    }

    public List<Integer> getNumberMatchWithWinningLotto() {
        return numberMatchWithWinningLotto;
    }

    public int getReward() {
        return reward;
    }
}
