package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private static final int RANK_TWO = 5;
    private static final int ZERO = 0;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        lottoNumbers.forEach(lottoNumber -> stringBuilder.append(lottoNumber.toString()));
        return stringBuilder.toString();
    }

    public Score calculateScore(Lotto lotto, BonusBall bonusBall) {
        List<Integer> score = new ArrayList<>();
        for (int i = ZERO; i < lottoNumbers.size(); i++) {
            int winCount = lotto.calculateWinNumber(lottoNumbers.get(i));
            winCount += isBonusBallContains(bonusBall, lottoNumbers.get(i), winCount);
            score.add(winCount);
        }
        return new Score(score);
    }

    private int isBonusBallContains(BonusBall bonusBall, LottoNumber lottoNumber, int winCount) {
        if (winCount == RANK_TWO) {
            return bonusBall.contains(lottoNumber);
        }
        return ZERO;
    }
}
