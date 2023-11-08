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

    public Score calculateScore(Lotto lotto) {
        List<Integer> score = new ArrayList<>();
        for (int i = 0; i < lottoNumbers.size(); i++) {
            int winCount = lotto.calculateWinNumber(lottoNumbers.get(i));
            score.add(winCount);
            System.out.println(winCount);
        }
        return new Score(score);
    }
}
