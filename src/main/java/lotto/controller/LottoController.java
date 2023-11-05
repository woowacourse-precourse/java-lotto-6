package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PlayerAmount;
import lotto.util.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        createLottos();
    }

    private List<Lotto> createLottos() {
        int count = new PlayerAmount(inputView.getPlayerAmount()).getLottoCount();
        List<Lotto> lottos = new ArrayList<>();

        for (int lotto = 0; lotto < count; lotto++) {
            lottos.add(new Lotto(RandomNumberGenerator.generate()));
        }

        return lottos;
    }
}
