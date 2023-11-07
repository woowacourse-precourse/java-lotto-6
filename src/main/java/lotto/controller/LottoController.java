package lotto.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lotto.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Rank;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.domain.LottoAmount;

import static lotto.view.InputView.inputPlayerAmount;

public class LottoController {

    private static final int TICKET_PRICE = 1000;
    private static final int PERCENTAGE = 100;
    private static LottoAmount playerLottoAmount;     //사용자가 구입한 로또 가격치

    private static List<Integer> lotto = new ArrayList<>(); // 사용자의 로또

    private static List<Lotto> lottoList;//로또 객체 리스트

    private static WinningResult winningResult;

    public void play() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        int ticketCount = inputPlayerAmount();
        OutputView.printTicketCnt(ticketCount);

        lottoList = makeLottoList(ticketCount);
        winningResult = checkBonus();
        lottoResult(lottoList, winningResult, ticketCount);

    }

    public int inputPlayerAmount() {
        playerLottoAmount = new LottoAmount(InputView.inputPlayerAmount());
        return playerLottoAmount.calcLottoNum();
    }

    public WinningResult checkBonus() {
        Lotto lotto = new Lotto(InputView.inputWinningNumbers());
        List<Integer> winningNumber = lotto.getLottoNumbers();
        int ball = InputView.inputBonusNumber();

        lotto.validateBonusNumber(winningNumber, ball);
        winningResult = new WinningResult(new Lotto(winningNumber), ball);

        return winningResult;

    }

    private void printEarningRate(Map<Rank, Integer> result, int lottoAmount) {
        double EarningRate = 0;
        for (Rank rank : result.keySet()) {
            EarningRate = EarningRate + ((double) rank.getWinningMoney()) / (lottoAmount * TICKET_PRICE) * (result.get(rank)) * (PERCENTAGE);
        }
        OutputView.printRevenueRate(EarningRate);
    }

    private void lottoResult(List<Lotto> lottoList, WinningResult winningLotto, int amount) {
        Map<Rank, Integer> result = setResult();
        Rank rank;

        OutputView.printSuccessResult();
        for (int i = 0; i < lottoList.size(); i++) {
            rank = winningLotto.match(lottoList.get(i));
            result.put(rank, result.get(rank) + 1);
        }
        printResult(result);
        printEarningRate(result, amount);
    }

    private void printResult(Map<Rank, Integer> result) {
        for (int i = Rank.values().length - 1; i >= 0; i--) {
            Rank.values()[i].printMessage(result.get(Rank.values()[i]));
        }
    }

    private Map<Rank, Integer> setResult() {
        Map<Rank, Integer> result = new LinkedHashMap<>();

        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        return result;
    }

    private static List<Lotto> makeLottoList(int ticketCount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

    private static Lotto makeLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();

        lotto = new ArrayList<>();
        lotto = lottoNumbers.setLottoNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);

    }

}
