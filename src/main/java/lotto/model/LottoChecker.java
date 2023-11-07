package lotto.model;

import static lotto.constant.Rank.FIFTHRANK;
import static lotto.constant.Rank.FIRSTRANK;
import static lotto.constant.Rank.FOURTHRANK;
import static lotto.constant.Rank.NOMATCHING;
import static lotto.constant.Rank.SECONDRANK;
import static lotto.constant.Rank.THIRDRANK;

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
        winningStatics.put(FIRSTRANK.getValue(), 0);
        winningStatics.put(SECONDRANK.getValue(), 0);
        winningStatics.put(THIRDRANK.getValue(), 0);
        winningStatics.put(FOURTHRANK.getValue(), 0);
        winningStatics.put(FIFTHRANK.getValue(), 0);
        winningStatics.put(NOMATCHING.getValue(), 0);
    }

    public HashMap<String, Integer> checkLottoNumbers() {
        for (Lotto lotto : randomLottos) {
            List<Integer> lottoforcompare = lotto.getLotto();
            boolean bonusNumberCheck = lottoforcompare.contains(bounsNumber);
            lottoforcompare.retainAll(answerLotto);
            String lottoRank = getLottoRank(lottoforcompare, bonusNumberCheck);
            Integer currentStatics = winningStatics.get(lottoRank);
            winningStatics.replace(lottoRank, currentStatics + 1);
        }
        return winningStatics;
    }

    private String getLottoRank(List<Integer> lotto, boolean bonusNumberCheck) {
        switch (lotto.size()) {
            case 6 -> {
                return FIRSTRANK.getValue();
            }
            case 5 -> {
                if (bonusNumberCheck) {
                    return SECONDRANK.getValue();
                }
                return THIRDRANK.getValue();
            }
            case 4 -> {
                return FOURTHRANK.getValue();
            }
            case 3 -> {
                return FIFTHRANK.getValue();
            }
            default -> {
                return NOMATCHING.getValue();
            }
        }
    }


}
