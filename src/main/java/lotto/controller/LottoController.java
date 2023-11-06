package lotto.controller;

import static lotto.model.Lotto.generateLotto;

import java.util.ArrayList;
import java.util.List;
import lotto.generator.NumberGenerator;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public LottoController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        int amounts = inputView.inputAmount();
        int lottoCount = getLottoCount(amounts);

        Lottos lottos = generateLottos(lottoCount);
    }

    private int getLottoCount(int amounts) {
        return amounts / 1000;
    }

    private Lottos generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(generateLotto(numberGenerator));
        }
        return new Lottos(lottos);
    }
}
