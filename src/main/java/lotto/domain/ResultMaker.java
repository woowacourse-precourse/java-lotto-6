package lotto.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ResultMaker {
    private final LottoBundle bundle;
    private final SelectedLotto selectedLottos;
    private final Map<Rank, Integer> lottoResult = new HashMap<>();
    private long totalPrize = 0;

    public ResultMaker(LottoBundle bundle, SelectedLotto selectedLottos) {
        this.bundle = bundle;
        this.selectedLottos = selectedLottos;
        initializeResult();
    }

    public void updateResult() {
        List<Lotto> userLottos = bundle.getBundle();
        double corrects = 0;
        for (Lotto lotto : userLottos) {
            corrects = counting(lotto);
            if (corrects < Rank.FIFTH_PLACE.getCorrects()) {
                continue;
            }
            int oldCount = lottoResult.get(Rank.valueOfCorrects(corrects));
            lottoResult.put(Rank.valueOfCorrects(corrects), ++oldCount);
        }
    }

    public String calculateRateOfReturn() {
        int investment = bundle.showInvestment();
        calculateTotalPrize();
        double rateOfReturn = totalPrize / investment * 100;
        return String.format("%.1f", rateOfReturn);
    }

    private void calculateTotalPrize() {
        Iterator<Entry<Rank, Integer>> entry = lottoResult.entrySet().iterator();
        while (entry.hasNext()) {
            Map.Entry<Rank, Integer> element = entry.next();
            Rank rank = element.getKey();
            int count = element.getValue();
            totalPrize = rank.sumPrize(totalPrize, count);
        }
    }

    private double counting(Lotto lotto) {
        List<Integer> answerLottos = selectedLottos.getSelectedNumbers();
        int bonus = selectedLottos.getBonus();
        double corrects = 0;
        corrects = lotto.compareWithSelected(answerLottos);
        if (corrects == Rank.THIRD_PLACE.getCorrects() && lotto.findBonus(bonus)) {
            corrects = Rank.SECOND_PLACE.getCorrects();
        }
        return corrects;
    }

    private void initializeResult() {
        for (int i = (int) Rank.FIFTH_PLACE.getCorrects(); i <= (int) Rank.FIRST_PLACE.getCorrects(); i++) {
            lottoResult.put(Rank.valueOfCorrects((double) i), 0);
        }
        lottoResult.put(Rank.valueOfCorrects(Rank.SECOND_PLACE.getCorrects()), 0);
    }
}
