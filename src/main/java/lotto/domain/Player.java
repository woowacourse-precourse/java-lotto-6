package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.config.GameConfig;
import lotto.exception.LottoValidator;
import lotto.service.CorrectLottoCalculator;
import lotto.util.RankingMessage;

public class Player {

    private static Player instance;
    CorrectLottoCalculator correctLottoCalculator;
    Map<Lotto, CorrectCount> lottos;

    private Player(CorrectLottoCalculator correctLottoCalculator) {
        this.correctLottoCalculator = correctLottoCalculator;
        lottos = new HashMap<>();
    }

    public static Player getInstance() {
        if (instance == null) {
            instance = new Player(GameConfig.getCorrectLottoCalculator());
        }
        return instance;
    }

    public static void deleteInstance() {
        instance = null;
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
