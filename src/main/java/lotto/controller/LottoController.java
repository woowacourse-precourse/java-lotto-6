package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.DrawingResults;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.ProfitRate;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.domain.dto.BonusNumberDto;
import lotto.domain.dto.DrawingResultDto;
import lotto.domain.dto.LottoDto;
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
        Lottos lottos = purchaseLotto();
        DrawingResultDto drawingResultDto = drawLotto(lottos);
        profitRate(lottos, drawingResultDto);
    }

    private Lottos purchaseLotto() {
        PurchaseAmountDto purchaseAmountDto = inputView.inputPurchaseAmount();
        Lottos lottos = lottoMachine.issuedLottos(mapToPurchaseAmount(purchaseAmountDto));

        outputView.printPurchaseQuantityLottos(purchaseAmountDto);
        outputView.printIssuedPurchaseResult(mapToLottosDto(lottos));

        return lottos;
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

    private DrawingResultDto drawLotto(final Lottos lottos) {
        WinningLottoDto winningLottoDto = inputView.inputWinningLotto();
        WinningLotto winningLotto = mapToWinningLotto(winningLottoDto);

        BonusNumberDto bonusNumberDto = inputView.inputBonusNumber();
        BonusNumber bonusNumber = mapToBonusNumber(bonusNumberDto);

        BonusNumberValidator.validateBonusNumberDuplicate(winningLotto, bonusNumber);

        DrawingResults drawingResult = lottoMachine.draw(lottos, winningLotto, bonusNumber);
        DrawingResultDto drawingResultDto = mapToDrawingResultDto(drawingResult);
        outputView.printDrawingResult(drawingResultDto);

        return drawingResultDto;
    }

    private WinningLotto mapToWinningLotto(final WinningLottoDto winningLottoDto) {
        return new WinningLotto(winningLottoDto.numbers());
    }

    private BonusNumber mapToBonusNumber(final BonusNumberDto bonusNumberDto) {
        return new BonusNumber(bonusNumberDto.number());
    }

    private DrawingResultDto mapToDrawingResultDto(final DrawingResults drawingResult) {
        return new DrawingResultDto(drawingResult.getResults());
    }

    public void profitRate(final Lottos lottos, final DrawingResults drawingResults) {
        ProfitRate profitRate = lottoMachine.calculateProfitRate(lottos, drawingResults);
        outputView.printProfitRate(profitRateDto);
    }
}