package lotto.controller;

import lotto.domain.dto.BonusNumberDto;
import lotto.domain.dto.DrawingResultDto;
import lotto.domain.dto.LottosDto;
import lotto.domain.dto.PurchaseAmountDto;
import lotto.domain.dto.WinningLottoDto;
import lotto.service.LottoMachine;
import lotto.validator.BonusNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoController(InputView inputView, OutputView outputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }

    public void start() {
        LottosDto lottosDto = purchaseLotto();
        DrawingResultDto drawingResultDto = drawLotto(lottosDto);
        profitRate(lottosDto, drawingResultDto);
    }

    private LottosDto purchaseLotto() {
        PurchaseAmountDto purchaseAmountDto = inputView.inputPurchaseAmount();
        LottosDto lottosDto = lottoMachine.issuedLottos(purchaseAmountDto);
        outputView.printPurchaseQuantityLottos(purchaseAmountDto);
        outputView.printIssuedPurchaseResult(lottosDto);

        return lottosDto;
    }

    private DrawingResultDto drawLotto(final LottosDto lottosDto) {
        WinningLottoDto winningLottoDto = inputView.inputWinningLotto();
        BonusNumberDto bonusNumberDto = inputView.inputBonusNumber();
        BonusNumberValidator.validateBonusNumberDuplicate(winningLottoDto, bonusNumberDto);

        DrawingResultDto drawingResultDto = lottoMachine.draw(lottosDto, winningLottoDto, bonusNumberDto);
        outputView.printDrawingResult(drawingResultDto);

        return drawingResultDto;
    }

    public void profitRate(final LottosDto lottosDto, final DrawingResultDto drawingResultDto) {
        double profitRate = lottoMachine.calculateProfitRate(lottosDto, drawingResultDto);
        outputView.printProfitRate(profitRate);
    }
}