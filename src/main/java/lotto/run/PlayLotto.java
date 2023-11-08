package lotto.run;

import lotto.exception.CustomIllegalArgumentException;
import lotto.model.Lotto;
import lotto.model.LottoTickets;
import lotto.model.LottoTotalPrize;
import lotto.model.WinningLotto;
import lotto.service.LottoService;
import lotto.service.TextProcessor;
import lotto.view.LottoView;

import java.util.List;

public class PlayLotto {
    private final LottoService lottoService;
    private final TextProcessor textProcessor;
    private final LottoView lottoView;

    public PlayLotto(LottoView lottoView) {
        this.lottoService = new LottoService();
        this.textProcessor = new TextProcessor();
        this.lottoView = lottoView;
    }

    public void run() {
        LottoTickets lottoTickets = createLottoTickets();
        repeatOutputLottoInfo(lottoTickets);
        WinningLotto winningLotto = createWinningLotto();

        LottoTotalPrize result = lottoService.compareWinningNumbers(lottoTickets, winningLotto);
        outputLottoResult(result);
        outputProfitability(lottoTickets, result);
    }

    private LottoTickets createLottoTickets() {
        try {
            int amount = inputPurchaseLotto();

            return lottoService.createLottoTickets(amount);
        } catch (CustomIllegalArgumentException e) {
            lottoView.outputException(e);

            return createLottoTickets();
        }
    }

    private WinningLotto createWinningLotto() {
        try {
            List<Integer> winningNumbers = inputWinningLottoNumbers();
            int bonusNumber = inputWinningLottoBonusNumber();

            return lottoService.createWinningLotto(winningNumbers, bonusNumber);
        } catch (CustomIllegalArgumentException e) {
            lottoView.outputException(e);

            return createWinningLotto();
        }
    }

    private int inputPurchaseLotto() {
        String inputAmount = lottoView.inputPurchaseAmount();

        return textProcessor.parsePurchaseAmount(inputAmount);
    }

    private List<Integer> inputWinningLottoNumbers() {
        String inputWinNumbers = lottoView.inputWinLottoNumbers();

        return textProcessor.splitWinningNumbers(inputWinNumbers);
    }

    private int inputWinningLottoBonusNumber() {
        String inputWinBonusNumber = lottoView.inputWinBonusNumbers();

        return textProcessor.parseBonusNumber(inputWinBonusNumber);
    }

    private void repeatOutputLottoInfo(LottoTickets lottoTickets) {
        lottoView.displayPurchasedLottoCount(lottoTickets.getTickets().size());

        for (Lotto lotto : lottoTickets.getTickets()) {
            String lottoInfo = textProcessor.generateLottoNumbersText(lotto);
            lottoView.displayPurchasedLottoInfo(lottoInfo);
        }
    }

    private void outputLottoResult(LottoTotalPrize result) {
        String outputResult = textProcessor.generateLottoResult(result);
        lottoView.displayLottoResult(outputResult);
    }

    private void outputProfitability(LottoTickets lottoTickets, LottoTotalPrize result) {
        float profit = lottoService.calculateProfitability(lottoTickets, result);
        lottoView.displayProfitability(profit);
    }
}