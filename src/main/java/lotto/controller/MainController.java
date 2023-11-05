package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lotto.domain.Calculator;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbersGenerator;
import lotto.domain.Ranking;
import lotto.domain.WinningNumbers;

public class MainController {

    public ArrayList<Lotto> settingConsumerLottos(int ticketQuantity) {
        ArrayList<Lotto> consumerLottos = new ArrayList<>();
        publishLottoByTicketQuantity(ticketQuantity, consumerLottos);
        return consumerLottos;
    }

    private void publishLottoByTicketQuantity(int ticketQuantity, ArrayList<Lotto> lottos) {
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        while (ticketQuantity-- > 0) {
            List<Integer> randomNumbers = lottoNumbersGenerator.generateRandomNumbers();
            lottos.add(new Lotto(randomNumbers));
        }
    }

    public Map<Ranking, Integer> getRankingResult(ArrayList<Lotto> consumerLottos, WinningNumbers winningNumbers) {
        Map<Ranking, Integer> resultBoard = makeResultMap();
        for (Lotto lotto : consumerLottos) {
            Ranking rank = Calculator.calculateRanking(lotto, winningNumbers);
            resultBoard.put(rank, resultBoard.getOrDefault(rank, 0) + 1);
        }
        preventNullPointMap(resultBoard);
        return resultBoard;
    }

    private Map<Ranking, Integer> makeResultMap() {
        Map<Ranking, Integer> board = new TreeMap<>();
        Arrays.stream(Ranking.values())
                .forEach((rank) -> board.put(rank, 0));

        return board;
    }

    private void preventNullPointMap(Map<Ranking, Integer> result) {
        Arrays.stream(Ranking.values())
                .filter((rank) -> !result.containsKey(rank))
                .forEach((rank) -> result.put(rank, 0));
    }

    public float getReturnOfRate(Map<Ranking, Integer> resultBoard, int ticketQuantity) {
        float returnOfRate = Calculator.calculateReturnOfRate(resultBoard, ticketQuantity);
        return returnOfRate;
    }

}
