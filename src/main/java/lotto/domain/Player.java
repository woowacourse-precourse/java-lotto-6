package lotto.domain;

import static lotto.constant.WinningConstant.INIT_WINNING_COUNT;
import static lotto.constant.WinningConstant.ONE_WINNING_COUNT;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private void initialLotteryResult() {
        Arrays.stream(LotteryResult.values())
                .filter(LotteryResult::isWinning)
                .forEach(lotteryResult -> lotteryResults.put(lotteryResult, INIT_WINNING_COUNT));
    }

    public static Player of(PurchasePrice purchasePrice, List<Lotto> lottos) {
        return new Player(purchasePrice, lottos);
    }

    public void addLotteryResult(List<LotteryResult> lotteryResults) {
        lotteryResults.forEach((lotteryResult) -> {
            this.lotteryResults.put(lotteryResult,
                    this.lotteryResults.get(lotteryResult) + ONE_WINNING_COUNT);
        });
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
