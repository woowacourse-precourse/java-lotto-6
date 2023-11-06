package lotto;

import lotto.controller.LottoController;
import lotto.model.Jackpot;
import lotto.model.Lotto;
import lotto.model.Purchase;
import lotto.model.Result;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        // 로또 구매
        Purchase purchase = purchaseLottsProcess(lottoController, inputView, outputView);

        // 로또 발급
        List<Lotto> lottos = generateLottoTicketsProcess(lottoController, outputView, purchase);

        // 당첨 및 보너스 번호 생성
        Jackpot jackpot = createJackPotProcess(lottoController, inputView);

        // 발행된 로또들의 당첨 여부 계산
        Result result = calculateWinningRanksProcess(lottoController, outputView, purchase, lottos, jackpot);

        // 발행된 로또들의 수익률 계산
        readProfitRateProcess(lottoController, outputView, result);
    }

    private static void readProfitRateProcess(LottoController lottoController, OutputView outputView, Result result) {
        Double rate = lottoController.calculateProfitRate(result);
        outputView.printProfitRate(rate);
    }

    private static Result calculateWinningRanksProcess(LottoController lottoController, OutputView outputView, Purchase purchase, List<Lotto> lottos, Jackpot jackpot) {
        Result result = lottoController.createResult(jackpot, lottos, purchase);
        lottoController.calculateWinningRanks(result);
        outputView.printWinningStatistics(result);
        return result;
    }

    private static Jackpot createJackPotProcess(LottoController lottoController, InputView inputView) {
        String winningNumbers = inputView.inputWinningNumbers();
        String bonusNumber = inputView.inputBonusNumber();
        return lottoController.createWinningNumbers(winningNumbers, bonusNumber);
    }

    private static List<Lotto> generateLottoTicketsProcess(LottoController lottoController, OutputView outputView, Purchase purchase) {
        List<Lotto> lottos = lottoController.generateLottoTickets(purchase);
        outputView.printLottos(lottos);
        return lottos;
    }

    private static Purchase purchaseLottsProcess(LottoController lottoController, InputView inputView, OutputView outputView) {
        Purchase purchase = null;
        boolean isValidateInput = false;

        while (!isValidateInput){
            try {
                String amount = inputView.inputPurchaseAmount();
                purchase = lottoController.purcahseLottos(amount);
                outputView.printPurchaseCount(purchase.getPurchaseCount());
                isValidateInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return purchase;
    }
}
