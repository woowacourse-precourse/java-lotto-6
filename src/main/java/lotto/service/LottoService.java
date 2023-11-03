package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.utils.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public List<Lotto> buyLottos(NumberGenerator numberGenerator, int lottoQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            lottos.add(createLotto(numberGenerator));
        }

        return lottos;
    }

    public List<Result> matchLotto(List<Lotto> lottos, List<Integer> winnerNumbers, int bonusNumber) {
        List<Result> results = new ArrayList<>();

        for (Lotto lotto : lottos) {
            Result result = lotto.determineResult(winnerNumbers, bonusNumber);
            results.add(result);
        }

        return results;
    }

    private Lotto createLotto(NumberGenerator numberGenerator) {
        List<Integer> generatedNumbers = numberGenerator.generateNumbers();
        return new Lotto(generatedNumbers);
    }

}
