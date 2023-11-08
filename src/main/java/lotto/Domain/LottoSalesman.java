package lotto.Domain;

import lotto.View.InputLottoUI;
import lotto.View.OutputLottoUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoSalesman {

    public static int lottoCount(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("");
    }
        return money / 1000;
    }

    public static List<List<Integer>> buyLotto(int lottoCount) {
        List<List<Integer>> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Lotto.createLottoRandomNumber();
            lottos.add(lottoNumbers);
        }
        return lottos;
    }

    public static void rankTotal(Map<Rank, Integer> matchingCounts, int totalPrize, int money) {
        OutputLottoUI.rankViewStart();
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NO_MATCH) {
                int count = matchingCounts.get(rank);
                String resultDescription = rank.getDescription();
                int prize = rank.getPrize();
                InputLottoUI.rankViewTotal(resultDescription, count);
                totalPrize = answerCount(count, prize, totalPrize);
            }
        }
        InputLottoUI.rateOfReturn(totalPrize, money);
    }

    public static int answerCount(int count, int prize, int totalPrize) {
        if(count != 0) {
            totalPrize += count * prize;
        }
        return totalPrize;
    }

    public static int bonusValidate(int bonusNumber) {
        bonusNumber = InputLottoUI.inputBonusNumber();
        if (bonusNumber > 0 && bonusNumber < 46) {
            return bonusNumber;
        }
        throw new IllegalArgumentException();
    }
}
