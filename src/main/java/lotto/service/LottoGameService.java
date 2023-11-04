package lotto.service;

import lotto.dto.LottoNumbersDTO;
import lotto.model.AutoLottoGenerator;
import lotto.model.LottoBuyer;
import lotto.model.LottoSeller;
import lotto.model.Lottos;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class LottoGameService {
    private final ConsoleInputView inputView;
    private final ConsoleOutputView outputView;

    public LottoGameService(ConsoleInputView inputView, ConsoleOutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public LottoSeller generateSeller() {
        return new LottoSeller(AutoLottoGenerator.getInstance());
    }

    public LottoBuyer generateBuyer() {
        return new LottoBuyer();
    }

    public int calculateLottoCountOnBuy(final LottoBuyer buyer) {
        outputView.requestPurchaseAmount();
        try {
            int purchaseAmount = readPurchaseAmount();
            buyer.pay(purchaseAmount);
            return buyer.getCountOfLotto();
        } catch (IllegalArgumentException e) {
            handleIllegalArgumentException(e);
            return calculateLottoCountOnBuy(buyer);
        }
    }

    public Lottos generateLottosOnSell(final LottoSeller seller, final int countOfLotto) {
        outputView.printCountOfLotto(countOfLotto);
        return seller.sell(countOfLotto);
    }

    public void printLottoNumbersByCount(final Lottos lottos) {
        for (int i = 0; i < lottos.size(); i++) {
            LottoNumbersDTO lottoNumbers = new LottoNumbersDTO(lottos.findLottoByIndex(i));
            outputView.printLottoNumbers(lottoNumbers);
        }
    }

    private int readPurchaseAmount() {
        return inputView.readPurchaseAmount();
    }

    private void handleIllegalArgumentException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
