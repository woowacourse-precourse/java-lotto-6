package lotto.domain.lotto;

import lotto.domain.generator.NumberGenerator;
import lotto.domain.Ranking;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final NumberGenerator numberGenerator;
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(NumberGenerator numberGenerator, int purchasePrice) {
        this.numberGenerator = numberGenerator;
        generateLottos(purchasePrice / LottoCondition.PRICE.getValue());
    }

    private void generateLottos(int lottoAmount) {
        while (lottos.size() < lottoAmount) {
            lottos.add(new Lotto(numberGenerator.generateNumbers()));
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
