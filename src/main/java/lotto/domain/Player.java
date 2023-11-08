package lotto.domain;

import static lotto.constant.WinningConstant.INIT_WINNING_COUNT;
import static lotto.constant.WinningConstant.ONE_WINNING_COUNT;
import static lotto.constant.WinningConstant.RATIO_BASE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *   게임 이용하는 사용자의 정보를 담당
 * */

public class Player {
    private final PurchasePrice purchasePrice;
    private final List<Lotto> lottos;

    private final Map<LotteryResult, Integer> lotteryResults;

    public Player(PurchasePrice purchasePrice, List<Lotto> lottos) {
        this.purchasePrice = purchasePrice;
        this.lottos = lottos;
        this.lotteryResults = new HashMap<>();
        initialLotteryResult();
    }

    public static Player of(PurchasePrice purchasePrice, List<Lotto> lottos) {
        return new Player(purchasePrice, lottos);
    }

    private void initialLotteryResult() {
        Arrays.stream(LotteryResult.values())
                .filter(LotteryResult::isWinning)
                .forEach(lotteryResult -> lotteryResults.put(lotteryResult, INIT_WINNING_COUNT));
    }

    public void addLotteryResult(List<LotteryResult> newResults) {
        newResults.forEach((newResult) -> {
            lotteryResults.put(newResult, lotteryResults.get(newResult) + ONE_WINNING_COUNT);
        });
    }

    public double findRateOfRevenue() {
        return (double) (findAllWinningPrize() * RATIO_BASE) / purchasePrice.getPrice();
    }


    private Long findAllWinningPrize() {
        return lotteryResults.keySet().stream()
                .mapToLong(result -> result.getPrize() * lotteryResults.get(result))
                .sum();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<LotteryResult, Integer> getLotteryResults() {
        return lotteryResults;
    }
}
