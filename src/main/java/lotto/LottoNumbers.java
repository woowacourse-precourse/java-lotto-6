package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;
    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        lottoNumbers.forEach(lottoNumber -> stringBuilder.append(lottoNumber.toString()).append("\n"));
        return stringBuilder.toString();
    }

    public Score calculateScore(Lotto lotto, BonusBall bonusBall) {
        List<Integer> score = new ArrayList<>();
        for (int i = 0; i < lottoNumbers.size(); i++) {
            int winCount = lotto.calculateWinNumber(lottoNumbers.get(i));
            winCount += isBonusBallContains(bonusBall, lottoNumbers.get(i), winCount);
            score.add(winCount);
            System.out.println(winCount);
        }
        return new Score(score);
    }

    private int isBonusBallContains(BonusBall bonusBall, LottoNumber lottoNumber, int winCount) {
        if (winCount == 5) {
            return bonusBall.contains(lottoNumber);
        }
        return 0;
    }
}
