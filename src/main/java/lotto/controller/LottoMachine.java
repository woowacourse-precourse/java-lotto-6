package lotto.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import lotto.model.*;
import lotto.service.Service;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {
    private static int ticketNumber = 0;
    private static final int TICKET_PRICE = 1000;
    private static final int PERCENTAGE = 100;
    private static List<Lotto> lottos;
    private static Prize prize;

    public void run() {
        try {
            setAmount();
            setLottoNumber();
            setPrize();
            showResult(lottos, prize, ticketNumber);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private static void setLottoNumber() {
        LottoNumbers lottoNumbers = new LottoNumbers(ticketNumber);
        lottos = lottoNumbers.getLottos();
        OutputView.printLottos(lottos);
    }

    private void setAmount() {
        String amount = InputView.inputPlayerAmount();
        ticketNumber = Service.setAmount(amount);
        OutputView.printTicketCount(ticketNumber);
    }


    public void setPrize() {
        List<Integer> winNumber = InputView.inputLottoWinningNum();
        int bonusNumber = InputView.inputBonusNumber();
        prize = Service.setPrize(winNumber, bonusNumber);
    }

    private void showResult(List<Lotto> lottoList, Prize winningLotto, int amount) {
        Map<Ranking, Integer> result = setResult();
        Ranking rank;
        OutputView.printSuccessResult();
        for (int i = 0; i < lottoList.size(); i++) {
            rank = winningLotto.match(lottoList.get(i));
            result.put(rank, result.get(rank) + 1);
        }
        printResult(result);
        printEarningRate(result, amount);
    }

    private void printResult(Map<Ranking, Integer> result) {
        for (int i = Ranking.values().length - 1; i >= 0; i--) {
            Ranking.values()[i].printMessage(result.get(Ranking.values()[i]));
        }
    }

    private void printEarningRate(Map<Ranking, Integer> result, int lottoAmount) {
        double EarningRate = 0;
        for (Ranking rank : result.keySet()) {
            EarningRate =
                    EarningRate + ((double) (rank.getWinningAmount()) / (lottoAmount * TICKET_PRICE) * (result.get(
                            rank)) * (PERCENTAGE));
        }
        OutputView.printRevenueRate(EarningRate);
    }

    private Map<Ranking, Integer> setResult() {
        Map<Ranking, Integer> result = new LinkedHashMap<>();
        for (Ranking rank : Ranking.values()) {
            result.put(rank, 0);
        }
        return result;
    }
}