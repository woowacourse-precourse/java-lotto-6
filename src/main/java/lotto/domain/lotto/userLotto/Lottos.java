package lotto.domain.lotto.userLotto;

import lotto.domain.NumberGenerator;
import lotto.domain.Ranking;
import lotto.domain.lotto.AnswerLotto;
import lotto.domain.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();
    private final NumberGenerator numberGenerator = NumberGenerator.getInstance();

    public Lottos(int lottoAmount) {
        generateLottos(lottoAmount);
    }

    private void generateLottos(int lottoAmount) {
        while (lottos.size() < lottoAmount) {
            lottos.add(new Lotto(numberGenerator.generateRandomNumbers()));
        }
    }

    public List<Ranking> calculateWinningResult(AnswerLotto answerLotto) {
        return lottos.stream()
                .map(lotto -> answerLotto.calculateWinningResult(lotto))
                .toList();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
