package lotto.model;

import static lotto.constant.Numbers.FIFTHRANKMATCHING;
import static lotto.constant.Numbers.FIRSTRANKMATCHING;
import static lotto.constant.Numbers.FOURTHRANKMATCHING;
import static lotto.constant.Numbers.SECONDRANKMATCHING;
import static lotto.constant.Rank.FIFTHRANK;
import static lotto.constant.Rank.FIRSTRANK;
import static lotto.constant.Rank.FOURTHRANK;
import static lotto.constant.Rank.NOMATCHING;
import static lotto.constant.Rank.SECONDRANK;
import static lotto.constant.Rank.THIRDRANK;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import lotto.constant.Rank;

public class LottoChecker {
    private final List<Lotto> randomLottos;
    private final List<Integer> answerLotto;
    private final Integer bounsNumber;
    private final HashMap<String, Integer> winningStatics;

    public LottoChecker(RandomLottos randomLottos, Lotto answerLotto, BonusNumber bonusNumber) {
        this.randomLottos = randomLottos.getRandomLottos();
        this.answerLotto = answerLotto.getLotto();
        this.bounsNumber = bonusNumber.getBonusNumber();
        this.winningStatics = new HashMap<>();
        Arrays.stream(Rank.values()).forEach(rank -> {
            winningStatics.put(rank.getValue(), 0);
        });
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
        if (lotto.size() == FIRSTRANKMATCHING.getIntValue()) {
            return FIRSTRANK.getValue();
        }
        if (lotto.size() == SECONDRANKMATCHING.getIntValue() && bonusNumberCheck) {
            return SECONDRANK.getValue();
        }
        if (lotto.size() == SECONDRANKMATCHING.getIntValue()) {
            return THIRDRANK.getValue();
        }
        if (lotto.size() == FOURTHRANKMATCHING.getIntValue()) {
            return FOURTHRANK.getValue();
        }
        if (lotto.size() == FIFTHRANKMATCHING.getIntValue()) {
            return FIFTHRANK.getValue();
        }
        return NOMATCHING.getValue();
    }


}
