package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.dto.BonusNumberDto;
import lotto.domain.dto.DrawingResultDto;
import lotto.domain.dto.LottoDto;
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
        BonusNumberDto bonusNumberDto = inputView.inputBonusNumber();
        BonusNumberValidator.validateBonusNumberDuplicate(winningLottoDto, bonusNumberDto);

        DrawingResultDto drawingResultDto = lottoMachine.draw(lottos, winningLottoDto, bonusNumberDto);
        outputView.printDrawingResult(drawingResultDto);

        return drawingResultDto;
    }

    public void profitRate(final LottosDto lottosDto, final DrawingResultDto drawingResultDto) {
        ProfitRateDto profitRateDto = lottoMachine.calculateProfitRate(lottosDto, drawingResultDto);
        outputView.printProfitRate(profitRateDto);
    }
}