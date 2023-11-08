package lotto.controller;

import static lotto.domain.LottoAmount.priceCalculation;
import static lotto.domain.UserNumber.userNumber;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.LottoNumbers;
import lotto.domain.Ranking;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;
    private static List<Integer> userNumber = new ArrayList<>();
    private static WinningResult winningResult;

    public static void run() {
        new LottoAmount();
        gameStart();
    }

    public static void gameStart() {
        int ticketCount = priceCalculation();
        lottoList = createLottoNumbers(ticketCount);
        userNumber = userNumber();
        winningResult = validateBonus();
        lottoResult(lottoList, winningResult, ticketCount);

    }

    private static Map<Ranking, Integer> setResult() {
        Map<Ranking, Integer> result = new LinkedHashMap<>();

        for (Ranking rank : Ranking.values()) {
            result.put(rank, 0);
        }
        return result;
    }

    private static void lottoResult(List<Lotto> lottoList, WinningResult winningLotto, int amount) {
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

    private static void printResult(Map<Ranking, Integer> result) {
        for (int i = Ranking.values().length - 1; i >= 0; i--) {
            Ranking.values()[i].printMessage(result.get(Ranking.values()[i]));
        }
    }

    private static void printEarningRate(Map<Ranking, Integer> result, int lottoAmount) {
        double EarningRate = 0;
        for (Ranking rank : result.keySet()) {
            EarningRate =
                    EarningRate + ((double) (rank.getWinningAmount()) / (lottoAmount * 1000) * (result.get(
                            rank)) * (100));

        }
        OutputView.printRevenueRate(EarningRate);
    }


    public static List<Lotto> createLottoNumbers(int ticketCount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoList.add(createLotto());
        }
        return lottoList;
    }

    public static Lotto createLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lotto = new ArrayList<>();

        lotto = lottoNumbers.setRandomNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    public static WinningResult validateBonus() {
        Lotto lotto = new Lotto(userNumber);
        List<Integer> winningNumber = lotto.getLottoNumbers();

        int ball = InputView.inputBonusNumber();
        lotto.validateBonusNumber(winningNumber, ball);
        winningResult = new WinningResult(new Lotto(winningNumber), ball);

        return winningResult;
    }

}
