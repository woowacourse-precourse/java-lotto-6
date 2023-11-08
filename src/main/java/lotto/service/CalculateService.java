package lotto.service;

import lotto.constant.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CalculateService {
    HashMap<String,Integer> winningPrize = new HashMap<>();

    public HashMap<String,Integer> calculateWinningPrize(Lottos lottos, int[] buyerLottoNumbers, int buyerBonusNumber) {
        boolean bonusWin = false;
        ArrayList<lotto.domain.Lotto> allLottos = lottos.getLottos();
        for (int i = 0; i < allLottos.size(); i++) {
            List<Integer> lotto = allLottos.get(i).getNumbers();
            int correctNumber = judgeCorrectNumber(lotto, buyerLottoNumbers);
            if (lotto.contains(buyerBonusNumber)) bonusWin = true;
            judgeLottoRank(correctNumber, bonusWin);
        }

        return winningPrize;
    }

    public int judgeCorrectNumber(List<Integer> lotto, int[] buyerLottoNumbers) {
        int correctNumber = 0;
        for (int number : buyerLottoNumbers) {
            if (lotto.contains(number)) correctNumber++;
        }
        return correctNumber;
    }

    public void judgeLottoRank(int correctNumber, boolean bonusWin) {
        if (correctNumber == Lotto.NUMBER_NEEDED_FOR_FIRST.getLottoNumber()) {
            winningPrize.put("1",winningPrize.getOrDefault("1",0) + 1);
        } else if (correctNumber == Lotto.NUMBER_NEEDED_FOR_SECOND.getLottoNumber() && bonusWin) {
            winningPrize.put("2",winningPrize.getOrDefault("1",0) + 1);
        } else if (correctNumber == Lotto.NUMBER_NEEDED_FOR_THIRD.getLottoNumber()) {
            winningPrize.put("3",winningPrize.getOrDefault("1",0) + 1);
        } else if (correctNumber == Lotto.NUMBER_NEEDED_FOR_FOURTH.getLottoNumber()) {
            winningPrize.put("4",winningPrize.getOrDefault("1",0) + 1);
        } else if (correctNumber == Lotto.NUMBER_NEEDED_FOR_FIFTH.getLottoNumber()) {
            winningPrize.put("5",winningPrize.getOrDefault("1",0) + 1);
        }
    }

    public int caculateTotalPrize(HashMap<String,Integer> winningPrize) {
        int totalPrize = 0;
        for (String rank : winningPrize.keySet()) {
            if (rank == "1") totalPrize += winningPrize.get(rank) * Lotto.FIRST_PRIZE_MONEY.getLottoNumber();
            else if (rank == "2") totalPrize += winningPrize.get(rank) * Lotto.SECOND_PRIZE_MONEY.getLottoNumber();
            else if (rank == "3") totalPrize += winningPrize.get(rank) * Lotto.THIRD_PRIZE_MONEY.getLottoNumber();
            else if (rank == "4") totalPrize += winningPrize.get(rank) * Lotto.FOURTH_PRIZE_MONEY.getLottoNumber();
            else if (rank == "5") totalPrize += winningPrize.get(rank) * Lotto.FIFTH_PRIZE_MONEY.getLottoNumber();
        }

        return totalPrize;
    }

    public float calculateTotalReturn(int totalPrize, int purchaseAmount) {
        return Math.round ((totalPrize / purchaseAmount) * 100/10.0);
    }
}
