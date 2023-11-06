package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultMaker {
    private final LottoBundle bundle;
    private final SelectedLotto selectedLottos;
    private final Map<Rank, Integer> lottoResult = new HashMap<>();
    private static final int FIFTH_PLACE = 3;
    private static final double SECOND_PLACE = 5.5;
    private static final int FIRST_PLACE = 6;
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
            if (corrects < FIFTH_PLACE) {
                continue;
            }
            int oldCount = lottoResult.get(Rank.valueOfCorrects(corrects));
            lottoResult.put(Rank.valueOfCorrects(corrects), ++oldCount);
        }
    }

    private double counting(Lotto lotto) {
        List<Integer> answerLottos = selectedLottos.getSelectedNumbers();
        int bonus = selectedLottos.getBonus();
        double corrects = 0;
        corrects = lotto.compareWithSelected(answerLottos);
        if (corrects == 5 && lotto.findBonus(bonus)) {
            corrects += 0.5;
        }
        return corrects;
    }

    private void initializeResult() {
        for (int i = FIFTH_PLACE; i <= FIRST_PLACE; i++) {
            lottoResult.put(Rank.valueOfCorrects((double) i), 0);
        }
        lottoResult.put(Rank.valueOfCorrects(SECOND_PLACE), 0);
    }
}
