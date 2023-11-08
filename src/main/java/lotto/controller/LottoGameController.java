package lotto.controller;

import static lotto.configuration.IntegerConstants.COST_OF_LOTTO;

import lotto.domain.entity.Lotto;
import lotto.domain.entity.LottoGame;
import lotto.domain.entity.LottoNumber;
import lotto.domain.entity.Lottos;
import lotto.domain.entity.ThousandUnitMoney;
import lotto.domain.entity.WinningResult;
import lotto.domain.dto.DtoMapper;
import lotto.domain.dto.PurchaseDto;
import lotto.domain.dto.WinningResultDto;
import lotto.domain.entity.Purchase;
import lotto.domain.entity.WinningTicket;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGameService lottoGameService;

    public LottoGameController(InputView inputView,
                               OutputView outputView,
                               LottoGameService lottoGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGameService = lottoGameService;
    }

    public void playGame() {
        Purchase purchase = purchaseLotto();

        outputView.outputPurchaseLottoList(DtoMapper.toPurchaseDtofrom(purchase.getLottos()));

        WinningTicket winningTicket = generateWinningTicket();

        WinningResult winningResult = lottoGameService.calcWinningResult(purchase, winningTicket);

        outputView.outputWinningStatistics(
                DtoMapper.toWinningResultDtofrom(
                        winningResult.getRankings(), winningResult.getRateOfReturn()));

        LottoGame lottoGame = LottoGame.create(purchase, winningTicket, winningResult);
        Long lottoGameId = lottoGameService.saveLottoGame(lottoGame);

        replayGame(false);
    }

    private Purchase purchaseLotto() {
        String purchaseAmountInput = inputView.inputPurchaseAmount();

        ThousandUnitMoney purchasePrice = ThousandUnitMoney.create(purchaseAmountInput);
        Lottos automaticLottos = Lottos.createAutomatic(purchasePrice, COST_OF_LOTTO.getValue());

        return Purchase.create(purchasePrice, automaticLottos);
    }

    private WinningTicket generateWinningTicket() {
        String winningNumbersInput = inputView.inputWinningLotto();
        String bonusNumberInput = inputView.inputBonusNumber();

        Lotto winningNumbers = Lotto.create(winningNumbersInput);
        LottoNumber bonusNumber = LottoNumber.create(bonusNumberInput);

        return WinningTicket.create(winningNumbers, bonusNumber);
    }

    private void replayGame(boolean isContinue) {
        if (isContinue) {
            playGame();
        }
    }
}
