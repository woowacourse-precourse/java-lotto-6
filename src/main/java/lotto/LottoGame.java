package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBonusNumber;
import lotto.domain.LottoPrize;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoWinningNumber;
import lotto.domain.LottoWinningResult;
import lotto.dto.LottoBonusNumberCreateRequest;
import lotto.dto.LottoPurchaseRequest;
import lotto.dto.LottoWinningNumberCreateRequest;
import lotto.dto.LottoWinningStatistics;
import lotto.generator.LottoGenerator;
import lotto.view.LottoGameView;

public class LottoGame {


    private final LottoGameView lottoGameView;
    private final LottoGenerator lottoGenerator;

    public LottoGame(LottoGameView lottoGameView, LottoGenerator lottoGenerator) {
        this.lottoGameView = lottoGameView;
        this.lottoGenerator = lottoGenerator;
    }

    public void run() {
        LottoPurchase lottoPurchase = inputLottoPurchase();
        List<Lotto> lottoTickets = createLottoTickets(lottoPurchase);
        LottoWinningNumber lottoWinningNumber = inputLottoWinningNumber();
        LottoBonusNumber lottoBonusNumber = inputLottoBonusNumber(lottoWinningNumber);

        LottoWinningResult lottoWinningResult = calculateLottoWinningResult(
                lottoTickets, lottoWinningNumber, lottoBonusNumber);

        printResult(lottoPurchase, lottoWinningResult);
    }

    private void printResult(LottoPurchase lottoPurchase, LottoWinningResult lottoWinningResult) {
        lottoGameView.printWinningStatistics(
                new LottoWinningStatistics(lottoPurchase.getPurchaseAmount(), lottoWinningResult.getTable()));
    }

    private static LottoWinningResult calculateLottoWinningResult(List<Lotto> lottoTickets,
                                                                  LottoWinningNumber lottoWinningNumber,
                                                                  LottoBonusNumber lottoBonusNumber) {
        LottoWinningResult lottoWinningResult = new LottoWinningResult();
        for (Lotto lottoTicket : lottoTickets) {
            LottoPrize lottoPrize = lottoTicket.prize(lottoWinningNumber, lottoBonusNumber);
            lottoWinningResult.addPrize(lottoPrize);
        }
        return lottoWinningResult;
    }

    private LottoPurchase inputLottoPurchase() {
        LottoPurchase lottoPurchase;
        while (true) {
            try {
                LottoPurchaseRequest lottoPurchaseRequest = lottoGameView.inputPurchaseRequest();
                lottoPurchase = new LottoPurchase(lottoPurchaseRequest.getPurchaseAmount());
                break;
            } catch (IllegalArgumentException e) {
                lottoGameView.printException(e);
            }
        }
        return lottoPurchase;
    }

    private LottoBonusNumber inputLottoBonusNumber(LottoWinningNumber lottoWinningNumber) {
        LottoBonusNumber lottoBonusNumber = null;
        while (true) {
            try {
                LottoBonusNumberCreateRequest lottoBonusNumberCreateRequest = lottoGameView.inputLottoBonusNumberCreateRequest();
                lottoBonusNumber = new LottoBonusNumber(lottoWinningNumber,
                        lottoBonusNumberCreateRequest.getBonusNumber());
                break;
            } catch (IllegalArgumentException e) {
                lottoGameView.printException(e);
            }
        }
        return lottoBonusNumber;
    }

    private List<Lotto> createLottoTickets(LottoPurchase lottoPurchase) {
        List<Lotto> lottoTickets = lottoPurchase.purchase(lottoGenerator);
        lottoGameView.printPurchasedTickets(lottoTickets);
        return lottoTickets;
    }

    private LottoWinningNumber inputLottoWinningNumber() {
        LottoWinningNumber lottoWinningNumber;
        while (true) {
            try {
                LottoWinningNumberCreateRequest lottoWinningNumberCreateRequest = lottoGameView.inputLottoWinningNumberCreateRequest();
                lottoWinningNumber = new LottoWinningNumber(
                        lottoWinningNumberCreateRequest.getNumbers());
                break;
            } catch (IllegalArgumentException e) {
                lottoGameView.printException(e);
            }
        }
        return lottoWinningNumber;
    }
}
