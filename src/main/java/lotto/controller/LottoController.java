package lotto.controller;

import static lotto.errorMessage.ExceptionErrorMessage.INPUT_ONLY_NUMBER_BONUS;
import static lotto.view.Input.inputAmount;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoSetNumber;
import lotto.model.PlayerPurchase;
import lotto.model.Ranking;
import lotto.model.Winner;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    private static final int lotto_One_Price = 1000;
    private static final int percentage = 100;

    private static List<Lotto> lottoAllNumbers;
    private static List<Integer> lottoList;

    public void run() {
        start();
    }

    public void start() {
        Output.inputPurchaseAmount();
        int lottoCount = inputPlayerAmount();

        Output.printLottoCount(lottoCount);
        List<Lotto> lottoAllList = createLottoAllList(lottoCount);

        Winner winner = winner();
        winning_Statistics(lottoAllList, winner, lottoCount);
    }

    public int inputPlayerAmount() {
        PlayerPurchase playerPurchase = new PlayerPurchase(inputAmount());
        return playerPurchase.calculateLottoCount();
    }

    private List<Lotto> createLottoAllList(int lottoCount) {
        lottoAllNumbers = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoAllNumbers.add(createLottoList());
        }
        return lottoAllNumbers;
    }

    private Lotto createLottoList() {
        lottoList = LottoSetNumber.setRandomNumbers();
        System.out.println(lottoList);
        return new Lotto(lottoList);
    }

    public Winner winner() {
        Output.inputWinningNumber();
        List<Integer> numbers = new ArrayList<>(Input.inputWinningNumber());
        Output.inputBonusNumber();
        int bonus = validateOnlyNumber(Input.inputBonusNumber());

        return new Winner(new Lotto(numbers), bonus);
    }

    private void winning_Statistics(List<Lotto> lottoAllList, Winner winner, int amount) {
        Map<Ranking, Integer> statistics = rankMap();
        for (Lotto lotto : lottoAllList) {
            Ranking ranking = winner.winnerMatch(lotto);
            statistics.put(ranking, statistics.get(ranking) + 1);
        }

        Output.statistics();

        printRankingResult(statistics);
        earningRate(statistics, amount);
    }

    private Map<Ranking, Integer> rankMap() {
        Map<Ranking, Integer> result = new LinkedHashMap<>();
        for (Ranking ranking : Ranking.values()) {
            result.put(ranking, 0);
        }
        return result;
    }

    private void printRankingResult(Map<Ranking, Integer> result) {
        for (int i = Ranking.values().length - 1; i >= 0; i--) {
            Ranking.values()[i].printMessage(result.get(Ranking.values()[i]));
        }

    }

    private void earningRate(Map<Ranking, Integer> statistics, int lottoCount) {
        double earningRate = 0;
        for (Ranking ranking : statistics.keySet()) {
            earningRate += (double) statistics.get(ranking) * ranking.getWinningPrize() /
                    (lottoCount * lotto_One_Price) * percentage;
        }

        Output.total_EarningRate(earningRate);
    }

    private int validateOnlyNumber(String bonus) {
        try {
            return Integer.parseInt(bonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ONLY_NUMBER_BONUS);
        }
    }
}
