package lotto.util;

import lotto.domain.Jackpot;
import lotto.domain.Lotto;
import lotto.dto.LottoResult;

import java.util.List;

public class ResultCalculator {

    private boolean includeBonusNumber;

    int rank1 = 0;
    int rank2 = 0;
    int rank3 = 0;
    int rank4 = 0;
    int rank5 = 0;

    public LottoResult execute(List<Lotto> lotteries, Jackpot jackpot) {
        List<Integer> jackpotNumbers = jackpot.getLotto().getNumbers();
        int bonusNumber = jackpot.getBonusNumber();
        for (Lotto lotto : lotteries) {
            List<Integer> numbers = lotto.getNumbers();
            long match = checkLottoResult(numbers, jackpot);

            updateResult(match);
        }

        return new LottoResult.Builder()
                .rank1(rank1)
                .rank2(rank2)
                .rank3(rank3)
                .rank4(rank4)
                .rank5(rank5)
                .build();
    }

    private long checkLottoResult(List<Integer> lotto, Jackpot jackpot) {
        includeBonusNumber = false;
        List<Integer> jackpotNumbers = jackpot.getLotto().getNumbers();
        int bonusNumber = jackpot.getBonusNumber();
        return lotto.stream().filter((number) -> {
                    if (jackpotNumbers.contains(number)) {
                        return true;
                    }
                    if (bonusNumber == number) {
                        includeBonusNumber = true;
                    }
                    return false;
                })
                .count();
    }

    private void updateResult(long match) {
        if (match == 3) {
            rank5++;
        }
        if (match == 4) {
            rank4++;
        }
        if (match == 5) {
            rank3++;
        }
        if (match == 5 && includeBonusNumber) {
            rank2++;
        }
        if (match == 6) {
            rank1++;
        }
    }
}
