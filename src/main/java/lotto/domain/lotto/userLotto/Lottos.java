package lotto.domain.lotto.userLotto;

import lotto.domain.generator.NumberGenerator;
import lotto.domain.Ranking;
import lotto.domain.lotto.AnswerLotto;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCondition;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final NumberGenerator numberGenerator;
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(NumberGenerator numberGenerator, int lottoAmount) {
        this.numberGenerator = numberGenerator;
        generateLottos(lottoAmount);
    }

    private void generateLottos(int lottoAmount) {
        while (lottos.size() < lottoAmount) {
            lottos.add(new Lotto(numberGenerator.generateRandomNumbers(LottoCondition.COUNT.getValue())));
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
