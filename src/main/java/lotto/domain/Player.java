package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final PurchasePrice purchasePrice;

    private final List<Lotto> lottos;
    //일급 컬렉션으로 포장해줘야할까
    private final List<LotteryResult> lotteryResults;

    public Player(PurchasePrice purchasePrice, List<Lotto> lottos) {
        this.purchasePrice = purchasePrice;
        this.lottos = lottos;
        this.lotteryResults = new ArrayList<LotteryResult>();
    }

    public static Player of(PurchasePrice purchasePrice, List<Lotto> lottos) {
        return new Player(purchasePrice, lottos);
    }

    public void addLotteryResult(List<LotteryResult> lotteryResults) {
        this.lotteryResults.addAll(lotteryResults);
    }

    public PurchasePrice getPurchasePrice() {
        return purchasePrice;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    //지우기
    public List<LotteryResult> getLotteryResults() {
        return lotteryResults;
    }
}
