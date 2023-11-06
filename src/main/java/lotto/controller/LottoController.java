package lotto.controller;

import java.util.List;
import lotto.controller.util.parser.InputParser;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoService;
import lotto.model.WinningNumber;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;
    private final InputParser inputParser;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView,
                           InputParser inputParser) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputParser = inputParser;
    }

    public void startLotto() {
        Integer money = inputParser.parseMoney(inputView.getMoney());
        List<Lotto> lottos = lottoService.purchaseLotto(money);
        outputView.printLottos(lottos);

        List<Integer> drawNumbers = inputParser.parseLottoNumbers(inputView.getWinningNumber());
        Integer bonusNumber = inputParser.parseBonusNumber(inputView.getBonusNumber());
        WinningNumber winningNumber = new WinningNumber(drawNumbers, bonusNumber);

        LottoResult lottoResult = lottoService.findWinningLottos(lottos, winningNumber);
        outputView.printLottoResult(lottoResult);
        outputView.printEarningRate(lottoResult.getLottoRanks(), money);
    }
}
