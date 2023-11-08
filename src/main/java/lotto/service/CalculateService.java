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
}
