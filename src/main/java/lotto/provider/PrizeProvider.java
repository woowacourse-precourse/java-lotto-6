package lotto.provider;

import lotto.data.Lotto;
import lotto.data.LottoResult;
import lotto.data.WinningNumber;
import lotto.data.Winnings;

import java.util.ArrayList;
import java.util.List;

public class PrizeProvider {

    public LottoResult getLottoResult(List<Lotto> lottos, WinningNumber winningNumber) {
        int totalPrize = 0;
        List<Integer> lottoResult = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));

        for (Lotto lotto : lottos) {
            Winnings winnings = checkLotto(lotto, winningNumber);
            int prize = winnings.getPrize();
            totalPrize += prize;

            int rank = winnings.getRank();
            int cnt = lottoResult.get(rank);
            lottoResult.set(rank, cnt+1);
        }
        return new LottoResult(lottoResult, totalPrize);
    }

    private Winnings checkLotto(Lotto lotto, WinningNumber winningNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningNumber.getNumbers();
        int bonus = winningNumber.getBonus();
        int correctCount = getCorrectCount(lottoNumbers, winningNumbers);
        boolean isBonusCorrect = isBonusCorrect(lottoNumbers, bonus);

        return checkWinnings(correctCount, isBonusCorrect);
    }

    private Winnings checkWinnings(int correctCnt, boolean isBonusCorrect) {
        if (correctCnt == 6) {
            return Winnings.FIRST;
        }
        if (correctCnt == 5 && isBonusCorrect) {
            return Winnings.SECOND;
        }
        if (correctCnt == 5) {
            return Winnings.THIRD;
        }
        if (correctCnt == 4) {
            return Winnings.FOURTH;
        }
        if (correctCnt == 3) {
            return Winnings.FIFTH;
        }
        return Winnings.NOTHING;
    }

    private int getCorrectCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int correctCnt = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                correctCnt++;
            }
        }
        return correctCnt;
    }

    private boolean isBonusCorrect(List<Integer> lottoNumbers, int bonus) {
        return lottoNumbers.contains(bonus);
    }
}
