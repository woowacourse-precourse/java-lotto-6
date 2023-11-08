package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.service.LottoService;
import lotto.utils.enums.LottoCount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService service;
    private final InputView inputView;
    private final OutputView outputView;
    private List<List<Integer>> createdLottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoController(LottoService service, InputView inputView, OutputView outputView) {
        this.service = service;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void lottoRun() {
        lottoInitialSetting();
        lottoStart();
    }

    private void lottoInitialSetting() {
        int lottoCount = inputView.getLottoCount();

        this.createdLottos = service.createLotto(lottoCount);
        outputView.outputCreatedLottos(createdLottos);

        this.winningNumbers = inputView.getWinningNumbers();
        this.bonusNumber = inputView.getBonusNumber(winningNumbers);
    }

    private void lottoStart() {
        Map<LottoCount, Integer> lottoResult =
                service.compareLottoToWinningAndBonus(createdLottos, winningNumbers, bonusNumber);
        outputView.outputWinningResult(lottoResult);

        int inputPrice = inputView.getInputPrice();
        long totalWinningPrice = service.getTotalWinningPrice(lottoResult);
        outputView.outputWinningRate(totalWinningPrice, inputPrice);
    }

}
