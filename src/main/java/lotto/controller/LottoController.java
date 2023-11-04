package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final LottoNumberGenerator lottoNumberGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.lottoNumberGenerator = new LottoNumberGenerator();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void playLotto() {
        int purchaseAmount = inputView.readPurchaseAmount();
        List<Lotto> lottos = buyLottos(purchaseAmount);
        printLottos(lottos);
    }

    private List<Lotto> buyLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(lottoNumberGenerator.generate()));
        }
        return lottos;
    }

    private void printLottos(List<Lotto> lottos) {
        outputView.printNumberOfLottosPurchased(lottos.size());
        outputView.printLottos(lottos);
    }
}
