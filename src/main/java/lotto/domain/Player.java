package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.exception.LottoValidator;
import lotto.service.CorrectLottoCalculator;
import lotto.util.RankingMessage;

public class Player {

    CorrectLottoCalculator correctLottoCalculator;
    Map<Lotto, CorrectCount> lottos;

    public Player(CorrectLottoCalculator correctLottoCalculator) {
        this.correctLottoCalculator = correctLottoCalculator;
        lottos = new HashMap<>();
    }

    public void addLotto(Lotto lotto) {
        lottos.put(lotto, new CorrectCount(0, 0));
    }

    public List<Lotto> getLottoPapers() {
        return lottos.keySet().stream().toList();
    }

    public List<CorrectCount> getCorrectCounts() {
        return lottos.values().stream().toList();
    }

    public int getNumberOfLotto() {
        return lottos.size();
    }

    public void setLottoCorrectCount(Lotto lotto, CorrectCount correctCount) {
        CorrectCount replace = lottos.replace(lotto, correctCount);
        LottoValidator.validate(replace);
    }

    public int getNumberCount(String message, int rankCount) {
        List<CorrectCount> correctCounts = getCorrectCounts();

        if (message.equals(RankingMessage.SECOND_RANK.toString())) {
            return correctLottoCalculator.getCorrectSecondLottoCount(rankCount, correctCounts).intValue();
        }
        if (message.equals(RankingMessage.THIRD_RANK.toString())) {
            return correctLottoCalculator.getCorrectThirdLottoCount(rankCount, correctCounts).intValue();
        }
        return correctLottoCalculator.getCorrectLottoCount(rankCount, correctCounts).intValue();
    }
}
