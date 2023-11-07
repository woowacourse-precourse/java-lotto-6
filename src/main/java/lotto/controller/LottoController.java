package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constants.Constants;
import lotto.model.Calculation;
import lotto.model.LottoModel;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void start() {
        int purchaseAmount = InputView.getPurchaseAmount();
        int lottoTicketCount = purchaseAmount / Constants.LOTTO_PRICE.getConstants();
        OutputView.printLottoTicketCount(lottoTicketCount);
        List<List<Integer>> lottoTickets = generateAllLottoTickets(lottoTicketCount);

        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber(winningNumbers);
        play(lottoTickets, winningNumbers, bonusNumber, purchaseAmount);
    }

    private void play(List<List<Integer>> lottoTickets, List<Integer> winningNumbers, int bonusNumber,
                      int purchaseAmount) {
        LottoModel model = new LottoModel(lottoTickets, winningNumbers, bonusNumber);
        model.lottoPlaying();

        displayLottoStatistics(model.getResult(), purchaseAmount);
    }

    private void displayLottoStatistics(List<Integer> result, int purchaseAmount) {
        System.out.println();
        Calculation calculation = new Calculation(result, purchaseAmount);
        double rate = calculation.calculateRate();
        OutputView.printResult(result, rate);
    }

    private List<Integer> generateOneLottoTicket() {
        List<Integer> oneLotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                Constants.MIN_NUMBER.getConstants(),
                Constants.MAX_NUMBER.getConstants(),
                Constants.LOTTO_SIZE.getConstants()));
        Collections.sort(oneLotto);
        OutputView.printLottoTickets(oneLotto);
        return oneLotto;
    }

    private List<List<Integer>> generateAllLottoTickets(int ticketCount) {
        List<List<Integer>> allLotto = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            allLotto.add(generateOneLottoTicket());
        }
        return allLotto;
    }
}

