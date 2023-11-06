package lotto.LottoController;

import lotto.Lotto;
import lotto.LottoView.LottoView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoController {

    private final LottoView view;
    private final InputCheck inpubCheck;
    private final GeneratorLotto generatorLotto;
    private final NumberFormatter numberFormatter;
    private final CalculatorResult calculatorResult;

    public LottoController() {
        this.view = new LottoView();
        this.inpubCheck = new InputCheck(view);
        this.generatorLotto = new GeneratorLotto();
        this.numberFormatter = new NumberFormatter();
        this.calculatorResult = new CalculatorResult();
    }

    public void run() {
        int purchaseAmount = inpubCheck.inputAmount();
        List<Lotto> lottos = generatorLotto.generatorLotto(purchaseAmount);
        view.showLottos(lottos.size(), lottos.stream().map(Lotto::getNumbers).collect(Collectors.toList()));
        Lotto winNumbers = inpubCheck.inputNumbers();
        int bonusNumber = inpubCheck.inputBonus(winNumbers);
        Map<Lotto.LottoRank, Integer> result = calculatorResult.calculateResults(lottos, winNumbers, bonusNumber);
        showResult(result);
        showProfit(result, purchaseAmount);
    }

    private void showResult(Map<Lotto.LottoRank, Integer> result) {
        Map<String, Integer> formatedResult = numberFormatter.formatResult(result);

        view.showResult(formatedResult);
    }

    private void showProfit(Map<Lotto.LottoRank, Integer> result, int purchaseAmount) {
        String profitRate = calculatorResult.calculateProfit(result, purchaseAmount);

        view.showRate(profitRate);
    }

}