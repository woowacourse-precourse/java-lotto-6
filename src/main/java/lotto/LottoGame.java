package lotto;

import java.util.List;
import lotto.dto.LottoPurchaseRequest;
import lotto.dto.LottoWinningNumberCreateRequest;

public class LottoGame {


    private final LottoGameView lottoGameView;
    private final LottoGenerator lottoGenerator;

    public LottoGame(LottoGameView lottoGameView, LottoGenerator lottoGenerator) {
        this.lottoGameView = lottoGameView;
        this.lottoGenerator = lottoGenerator;
    }

    public void run() {
        LottoPurchase lottoPurchase = null;
        while (true) {
            try {
                LottoPurchaseRequest lottoPurchaseRequest = lottoGameView.inputPurchaseRequest();
                lottoPurchase = new LottoPurchase(lottoPurchaseRequest.getPurchaseAmount());
                break;
            } catch (IllegalArgumentException e) {
                lottoGameView.printException(e);
            }
        }

        List<Lotto> lottoTickets = lottoPurchase.purchase(lottoGenerator);
        lottoGameView.printPurchasedTickets(lottoTickets);

        while (true) {
            try {
                LottoWinningNumberCreateRequest lottoWinningNumberCreateRequest = lottoGameView.inputLottoWinningNumberCreateRequest();
                LottoWinningNumberCreate lottoWinningNumberCreate = new LottoWinningNumberCreate(
                        lottoWinningNumberCreateRequest.getNumbers());
                break;
            } catch (IllegalArgumentException e) {
                lottoGameView.printException(e);
            }
        }
    }
}
