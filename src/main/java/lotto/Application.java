package lotto;

import lotto.controller.LottoController;
import lotto.model.Jackpot;
import lotto.model.Lotto;
import lotto.model.Purchase;
import lotto.model.Result;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        // 로또 구매
        Purchase purchase = purchaseLottosProcess(lottoController, inputView, outputView);
        // 로또 발급
        List<Lotto> lottos = generateLottoTicketsProcess(lottoController, outputView, purchase);
        // 당첨 및 보너스 번호 생성
        Jackpot jackpot = createJackPotProcess(lottoController, inputView);
        // 발행된 로또들의 당첨 여부 계산 및 수익률 계산
        Result result = calculateWinningRanksProcess(lottoController, outputView, purchase, lottos, jackpot);
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
        Jackpot jackpot = null;

        while (jackpot == null) {
            try {
                String winningNumbers = inputView.inputWinningNumbers();
                String bonusNumber = inputView.inputBonusNumber();
                jackpot = lottoController.createWinningNumbers(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return jackpot;
    }

    private static List<Lotto> generateLottoTicketsProcess(LottoController lottoController, OutputView outputView, Purchase purchase) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.isEmpty()) {
            try {
                lottos = lottoController.generateLottoTickets(purchase.getPurchaseCount());
                outputView.printLottos(lottos);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return lottos;
    }

    private static Purchase purchaseLottosProcess(LottoController lottoController, InputView inputView, OutputView outputView) {
        Purchase purchase = null;
        while (purchase == null) {
            try {
                String amount = inputView.inputPurchaseAmount();
                purchase = lottoController.purcahseLottos(amount);
                outputView.printPurchaseCount(purchase.getPurchaseCount());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchase;
    }
}
