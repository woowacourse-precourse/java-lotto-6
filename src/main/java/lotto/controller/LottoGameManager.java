package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Consumer;
import lotto.domain.Prize;
import lotto.domain.Winning;
import lotto.domain.lotto.Lotto;
import lotto.service.LottoStore;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameManager {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoStore lottoStore;

    private Consumer consumer = new Consumer();
    private Winning winning = new Winning();

    public LottoGameManager(InputView inputView, OutputView outputView, LottoStore lottoStore) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoStore = lottoStore;
    }

    public void play() {
        enterPurchaseAmount();
        printLottos();
        enterWinningNumber();
        enterBonusNumber();
        printTotalPrizeAndRevenue();
    }

    private void enterPurchaseAmount() {
        while (true) {
            try {
                int purchaseAmount = inputView.enterPurchaseAmount();
                consumer.setPurchaseAmount(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printLottos() {
        List<Lotto> lottos = lottoStore.createLottos(consumer.getPurchaseAmount());
        consumer.setLottos(lottos);

        outputView.printLottos(consumer);
    }

    private void enterWinningNumber() {
        while (true) {
            try {
                List<Integer> numbers = inputView.enterWinningNumber();
                winning.setNumbers(numbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void enterBonusNumber(){
        while (true) {
            try {
                int bonusNumber = inputView.enterBonusNumber();
                winning.setBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void printTotalPrizeAndRevenue(){
        Map<Prize, Integer> totalPrize = winning.calcTotalPrize(consumer.getLottos());
        outputView.printTotalPrize(totalPrize);

        double revenueRate = winning.calcRevenueRate(totalPrize, consumer.getPurchaseAmount());
        outputView.printRevenueRate(revenueRate);
    }

}
