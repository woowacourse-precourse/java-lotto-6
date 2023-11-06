package lotto.controller;

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

    private final int lotto_One_Price = 1000;
    private final int percentage = 100;

    private static List<Lotto> lottoAllNumbers;
    private static List<Integer> lottoList;

    public void run() {
        start();
    }

    public void start() {
        Output.input_Purchase_Amount(); // 구입 금액을 입력해주세요
        int lottoCount = inputPlayerAmount(); // 구입 금액 입력 후 계산 -> 8개 구매

        Output.print_Lotto_Count(lottoCount); // 8개를 구매했습니다.
        List<Lotto> lottoAllList = createLottoAllList(lottoCount);// 로또 6개 번호

        Winner winner = winner();
        winning_Statistics(lottoAllList, winner, lottoCount);
    }


    public int inputPlayerAmount() {
        PlayerPurchase playerPurchase = new PlayerPurchase(inputAmount());
        return playerPurchase.calculateLottoCount();
    }

    // 랜덤으로 뽑아낸 8개 로또 찍어냄.
    private List<Lotto> createLottoAllList(int lottoCount) {
        lottoAllNumbers = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoAllNumbers.add(createLottoList()); // 랜덤 숫자 6개를 8번 넣음.
        }
        return lottoAllNumbers;
    }

    private Lotto createLottoList() {
        lottoList = LottoSetNumber.setRandomNumbers();
        System.out.println(lottoList);
        return new Lotto(lottoList);
    }

    public Winner winner() {
        Output.input_Winning_Number(); // 당첨 번호 입력하세요.
        List<Integer> numbers = new ArrayList<>(Input.input_Winning_Number());
        Output.input_Bonus_Number(); // 보너스 번호 입력
        int bonus = Input.input_BonusNumber();

        return new Winner(new Lotto(numbers), bonus);
    }


    private void winning_Statistics(List<Lotto> lottoAllList, Winner winner, int amount) {
        Map<Ranking, Integer> statistics = rankMap();
        for (Lotto lotto : lottoAllList) {
            Ranking ranking = winner.winnerMatch(lotto); // 로또 8개의 랭킹을 조회
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
            earningRate += (double) statistics.get(ranking) * ranking.getWinningPrize() / (lottoCount * lotto_One_Price)
                    * percentage;
        }

        Output.total_EarningRate(earningRate);
    }
}
