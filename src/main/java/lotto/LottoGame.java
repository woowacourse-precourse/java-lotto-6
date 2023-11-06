package lotto;

import lotto.dto.LottoPurchaseRequest;

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
    }
}
