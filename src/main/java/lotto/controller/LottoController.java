package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private LottoService lottoService = new LottoService();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private int purchasePrice;

    public void run() {

        outputView.printInputPurchasePriceSentence();
        try {
            purchasePrice = inputView.inputPurchasePrice();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Buyer buyer = lottoService.issueLotteryTicketAll(purchasePrice);
        List<Lotto> lottos = buyer.getLottos();
        int lotteryTicketCount = lottoService.getLotteryTicketCount(purchasePrice);
        outputView.printIssuingLotteryTicket(lottos, lotteryTicketCount);

        outputView.printInputWinningNumbersSentence();
        List<Integer> winningNumbers = inputView.inputWinningNumbers();

        outputView.printBonusNumberSentence();
        int bonusNumber = inputView.inputBonusNumber();

        List<Prize> prizes = getTotalPrize(lottos, winningNumbers, bonusNumber);

        List<Integer> prizeCount = lottoService.getPrizeCount();
        outputView.printResult(prizes, prizeCount);

        double rateOfReturn = lottoService.getRateOfReturn(prizes, purchasePrice);
        outputView.printRateOfReturn(rateOfReturn);
    }

    private List<Prize> getTotalPrize(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        List<Prize> prizes = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Prize prize = lottoService.getPrize(lotto.getNumbers(), winningNumbers, bonusNumber);
            prizes.add(prize);
        }
        return prizes;
    }
}
