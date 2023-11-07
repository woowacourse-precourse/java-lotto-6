package lotto.model;

import java.util.HashMap;
import java.util.List;

public class LottoChecker {
    private final List<Lotto> randomLottos;
    private final List<Integer> answerLotto;
    private final Integer bounsNumber;
    private final HashMap<String, Integer> winningStatics;

    public LottoChecker(RandomLottos randomLottos, Lotto answerLotto, BounsNumber bounsNumber) {
        this.randomLottos = randomLottos.getRandomLottos();
        this.answerLotto = answerLotto.getLotto();
        this.bounsNumber = bounsNumber.getBonusNumber();
        this.winningStatics = new HashMap<>();
        winningStatics.put("FIRST", 0);
        winningStatics.put("SECOND", 0);
        winningStatics.put("THIRD", 0);
        winningStatics.put("FOURTH", 0);
        winningStatics.put("FIFTH", 0);
        winningStatics.put("NOMATCHING", 0);
    }

    public HashMap<String, Integer> checkLottoNumbers() {
        for (Lotto lotto : randomLottos) {
            List<Integer> lottoforcompare = lotto.getLotto();
            boolean bonusNumberCheck = lottoforcompare.contains(bounsNumber);
            lottoforcompare.retainAll(answerLotto);
            String lottoRank = getLottoRank(lottoforcompare,bonusNumberCheck);
            Integer currentStatics = winningStatics.get(lottoRank);
            winningStatics.replace(lottoRank, currentStatics+1);
        }
        return winningStatics;
    }

    private String getLottoRank(List<Integer> lotto, boolean bonusNumberCheck) {
        switch (lotto.size()) {
            case 6 -> {
                return "FIRST";
            }
            case 5 -> {
                if (bonusNumberCheck)
                    return "SECOND";
                return "THIRD";
            }
            case 4 -> {
                return "FOURTH";
            }
            case 3 -> {
                return "FIFTH";
            }
            default -> {
                return "NOMATCHING";
            }
        }
    }


}
