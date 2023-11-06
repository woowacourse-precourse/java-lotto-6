package lotto.domain;

import static lotto.constant.WinningConstant.INIT_WINNING_COUNT;
import static lotto.constant.WinningConstant.ONE_WINNING_COUNT;
import static lotto.constant.WinningConstant.RATIO_BASE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Player {


    private final PurchasePrice purchasePrice;

    private final List<Lotto> lottos;
    //일급 컬렉션으로 포장해줘야할까
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


    public void addLotteryResult(List<LotteryResult> lotteryResults) {
        lotteryResults.forEach((lotteryResult) -> {
            this.lotteryResults.put(lotteryResult,
                    this.lotteryResults.get(lotteryResult) + ONE_WINNING_COUNT);
        });
    }

    public double findRateOfRevenue() {
        return (double) (findAllWinningPrize() * RATIO_BASE) / purchasePrice.getPrice();
    }


    private Long findAllWinningPrize() {
        long allWinningPrize = 0L;
        for (Entry<LotteryResult, Integer> entry : lotteryResults.entrySet()) {
            LotteryResult lotteryResult = entry.getKey();
            Integer lotteryCount = entry.getValue();
            if (lotteryResult.isWinning()) {
                allWinningPrize += (long) lotteryResult.getPrize() * lotteryCount;
            }
        }
        return allWinningPrize;
    }

    public PurchasePrice getPurchasePrice() {
        return purchasePrice;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    //지우기
    public Map<LotteryResult, Integer> getLotteryResults() {
        return lotteryResults;
    }
}
