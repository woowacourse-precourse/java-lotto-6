package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.domain.dto.BonusNumberDto;
import lotto.domain.dto.DrawingResultDto;
import lotto.domain.dto.LottosDto;
import lotto.domain.dto.ProfitRateDto;
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
        LottosDto lottosDto = lottoMachine.issuedLottos(mapToPurchaseAmount(purchaseAmountDto));

        outputView.printPurchaseQuantityLottos(purchaseAmountDto);
        outputView.printIssuedPurchaseResult(lottosDto);

        return lottosDto;
    }

    private PurchaseAmount mapToPurchaseAmount(final PurchaseAmountDto purchaseAmountDto) {
        return new PurchaseAmount(purchaseAmountDto.amount());
    }

    private LottosDto mapToLottosDto(final Lottos lottos) {
        List<LottoDto> lottoStore = new ArrayList<>();

        List<Lotto> lottosContents = lottos.getLottos();

        for (Lotto lotto : lottosContents) {
            LottoDto lottoDto = new LottoDto(lotto.getNumbers());
            lottoStore.add(lottoDto);
        }

        return new LottosDto(lottoStore);
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
        ProfitRateDto profitRateDto = lottoMachine.calculateProfitRate(lottosDto, drawingResultDto);
        outputView.printProfitRate(profitRateDto);
    }
}