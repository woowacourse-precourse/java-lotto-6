package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;

import static lotto.ErrorMessage.FIVE;

public enum LottoWinningCase {
    UNRANK(0, List.of(0, 1, 2)),
    FIRST_PLACE(1, List.of(6)),
    SECONND_PLACE(2, List.of(5)),
    THRID_PLACE(3, List.of(5)),
    FOURTH_PLACE(4, List.of(4)),
    FIFTH_PLACE(5, List.of(3));

    private final int place;
    private final List<Integer> numberMatchWithWinningLotto;

    LottoWinningCase(int place, List<Integer> numberMatchWithWinningLotto) {
        this.place = place;
        this.numberMatchWithWinningLotto = numberMatchWithWinningLotto;
    }

    public static LottoWinningCase compareWhichCaseItIs(Lotto myLottoNumbers, List<Integer> winningNumber, int bonusNumnber) {
        int matchCount = getHowManyMathch(myLottoNumbers, winningNumber);
        LottoWinningCase myCase = Arrays.stream(LottoWinningCase.values())
                .filter(lottoWinningCase -> lottoWinningCase.getNumberMatchWithWinningLotto().contains(matchCount))
                .findFirst()
                .orElse(null);
        if(myCase.getPlace() == FIVE && !BonusNumberMatch(myLottoNumbers.getNumbers(), bonusNumnber)) {
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
}
