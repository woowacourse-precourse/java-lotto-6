package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.constants.WinningCondition;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void doLotto() {
        int payment = getPayment();
        int amountOfLottos = getAmountOfLottos(payment);
        List<Lotto> lottos = generateLottos(amountOfLottos);
        printAllLottos(lottos);
        System.out.print("\n");
        List<Integer> winningNumbers = getWinningNumbers();
        System.out.print("\n");
        int bonusNumber = getBonusNumber();
        System.out.print("\n");
        HashMap<String, Integer> statistic = makeStatistic(winningNumbers, bonusNumber, lottos, payment);
        outputView.printWinningStatisticsInstruction(statistic);
        double profitRate = calculateProfitRate(statistic, payment);
        outputView.printProfitRate(profitRate);
    }


    private HashMap<String, Integer> makeStatistic(List<Integer> winningNumbers, int bonusNumber, List<Lotto> lottos,
                                                   int payment) {
        HashMap<String, Integer> result = generateWinners();
        LottoMachine machine = new LottoMachine(winningNumbers, bonusNumber);
        int first = 0, second = 0, third = 0, forth = 0, fifth = 0;
        for (Lotto lotto : lottos) {
            String winner = machine.getWinner(lotto);
            if (winner.equals("5등")) {
                fifth++;
            }
            if (winner.equals("4등")) {
                forth++;
            }
            if (winner.equals("3등")) {
                third++;
            }
            if (winner.equals("2등")) {
                second++;
            }
            if (winner.equals("1등")) {
                first++;
            }
        }
        result.put("5등", fifth);
        result.put("4등", forth);
        result.put("3등", third);
        result.put("2등", second);
        result.put("1등", first);
        return result;
    }

    private double calculateProfitRate(HashMap<String, Integer> statistic, int payment) {
        double totalPrize =
                statistic.get("1등") * WinningCondition.FIRST_PLACE.getPrize()
                        + statistic.get("2등") * WinningCondition.SECOND_PLACE.getPrize()
                        + statistic.get("3등") * WinningCondition.THIRD_PLACE.getPrize()
                        + statistic.get("4등") * WinningCondition.FORTH_PLACE.getPrize()
                        + statistic.get("5등") * WinningCondition.FIFTH_PLACE.getPrize();
        return (double) Math.round(totalPrize / payment * 100 * 10) / 10;
    }

    private HashMap<String, Integer> generateWinners() {
        HashMap<String, Integer> winners = new HashMap<>();
        winners.put("5등", 0);
        winners.put("4등", 0);
        winners.put("3등", 0);
        winners.put("2등", 0);
        winners.put("1등", 0);
        return winners;
    }


    private void printAllLottos(List<Lotto> lottos) {
        lottos.forEach(outputView::printLotto);
    }

    private List<Lotto> generateLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(randomNumbers));
        }
        return lottos;
    }

    private int getBonusNumber() {
        outputView.printBonusNumberInstruction();
        return inputView.inputBounusNumber();
    }

    private List<Integer> getWinningNumbers() {
        outputView.printWinningNumberInstruction();
        return inputView.inputWinningNumbers();
    }

    private int getAmountOfLottos(int payment) {
        int amountOfLottos = getNumbersLottoPurchased(payment);
        outputView.printLottoPurchaseAmount(amountOfLottos);
        return amountOfLottos;
    }

    private int getPayment() {
        outputView.printPaymentInstruction();
        int payment = inputView.inputPayment();
        System.out.print("\n");
        return payment;
    }

    private int getNumbersLottoPurchased(int payment) {
        return payment / 1000;
    }
}
