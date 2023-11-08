package lotto.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.domain.LottoRandom;
import lotto.domain.PlayerTicket;
import lotto.domain.Ranking;
import lotto.domain.WinningResult;
import lotto.view.inputView;
import lotto.view.outputView;

public class lottoController {
    public lottoController() {
    }

    private static final int TICKET_PRICE = 1000;
    private static final int PERCENTAGE = 100;

    private static PlayerTicket playerTicket;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;
    private static WinningResult winningResult;


    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        int ticketCount = PlayerTicket();
        outputView.printTicketCount(ticketCount);

        lottoList = makeLottoList(ticketCount);
        winningResult = validateBonus();

        lottoResult(lottoList, winningResult, ticketCount);

    }

    public int PlayerTicket() {
    	playerTicket = new PlayerTicket(inputView.inputPlayerAmount());
        return playerTicket.TicketCount();
    }

    public WinningResult validateBonus() {
        Lotto lotto = new Lotto(inputView.inputLottoWinningNum());
        List<Integer> winningNumber = lotto.getLottoNumbers();

        int ball = inputView.inputBonusNumber();
        lotto.validateBonusNumber(winningNumber, ball);
        winningResult = new WinningResult(new Lotto(winningNumber), ball);

        return winningResult;
    }


    private static List<Lotto> makeLottoList(int ticketCount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoList.add(makeLotto());
        }
        return lottoList;
    }


    private static Lotto makeLotto() {
        LottoRandom lottoRandom = new LottoRandom();
        lotto = new ArrayList<>();

        lotto = lottoRandom.setRandomNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    private void lottoResult(List<Lotto> lottoList, WinningResult winningLotto, int amount) {
        Map<Ranking, Integer> result = setResult();
        Ranking rank;

        outputView.printSuccessResult();
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
        outputView.printTotalEarningRate(EarningRate);
    }


    private Map<Ranking, Integer> setResult() {
        Map<Ranking, Integer> result = new LinkedHashMap<>();

        for (Ranking rank : Ranking.values()) {
            result.put(rank, 0);
        }
        return result;
    }

}