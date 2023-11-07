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
import lotto.domain.dto.ProfitRateDto;
import lotto.domain.dto.PurchaseAmountDto;
import lotto.domain.dto.WinningLottoDto;
import lotto.service.LottoMachine;
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
        DrawingResults drawingResults = drawLotto(lottos);
        profitRate(lottos, drawingResults);
    }

    private Lottos purchaseLotto() {
        try {
            PurchaseAmountDto purchaseAmountDto = inputView.inputPurchaseAmount();
            Lottos lottos = lottoMachine.issuedLottos(mapToPurchaseAmount(purchaseAmountDto));

            outputView.printPurchaseQuantityLottos(purchaseAmountDto);
            outputView.printIssuedPurchaseResult(mapToLottosDto(lottos));

            return lottos;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return purchaseLotto();
        }
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

    private DrawingResults drawLotto(final Lottos lottos) {
        WinningLotto winningLotto = getWinningLotto();
        BonusNumber bonusNumber = getBonusNumber(winningLotto);

        DrawingResults drawingResult = lottoMachine.draw(lottos, winningLotto, bonusNumber);
        outputView.printDrawingResult(mapToDrawingResultDto(drawingResult));

        return drawingResult;
    }

    private WinningLotto getWinningLotto() {
        try {
            WinningLottoDto winningLottoDto = inputView.inputWinningLotto();
            WinningLotto winningLotto = mapToWinningLotto(winningLottoDto);
            return winningLotto;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return getWinningLotto();
        }
    }

    private BonusNumber getBonusNumber(WinningLotto winningLotto) {
        try {
            BonusNumberDto bonusNumberDto = inputView.inputBonusNumber();
            BonusNumber bonusNumber = mapToBonusNumber(bonusNumberDto, winningLotto);
            return bonusNumber;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return getBonusNumber(winningLotto);
        }
    }

    private WinningLotto mapToWinningLotto(final WinningLottoDto winningLottoDto) {
        return new WinningLotto(winningLottoDto.numbers());
    }

    private BonusNumber mapToBonusNumber(final BonusNumberDto bonusNumberDto, final WinningLotto winningLotto) {
        return new BonusNumber(bonusNumberDto.number(), winningLotto);
    }

    private DrawingResultDto mapToDrawingResultDto(final DrawingResults drawingResult) {
        return new DrawingResultDto(drawingResult.getResults());
    }

    public void profitRate(final Lottos lottos, final DrawingResults drawingResults) {
        try {
            ProfitRate profitRate = lottoMachine.calculateProfitRate(lottos, drawingResults);
            outputView.printProfitRate(mapToProfitRateDto(profitRate));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            profitRate(lottos, drawingResults);
        }
    }

    private ProfitRateDto mapToProfitRateDto(final ProfitRate profitRate) {
        return new ProfitRateDto(profitRate.getProfitRate());
    }
}