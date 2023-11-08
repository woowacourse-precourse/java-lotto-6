package lotto.model;
import lotto.Lotto;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import lotto.Lotto.LottoConstants;


public class LottoPlayer {

    private List<Lotto> purchasedLottos = new ArrayList<>();
    private Map<Integer, Long> winningsCountMap;
    private long totalWinnings;
    private long totalSpendings;


    public LottoPlayer(){
        this.purchasedLottos = new ArrayList<>();
        this.winningsCountMap = new HashMap<>();
        this.totalWinnings = 0;
        this.totalSpendings = 0;
    }

    public void purchaseLottos(int numberOfLottos) {
        this.purchasedLottos.addAll(LottoGame.generatePurchasedLotto(numberOfLottos));
        this.totalSpendings += (long) numberOfLottos * LottoConstants.LOTTO_PRICE.getPrice();
    }


    public List<Lotto> getPurchasedLottos(){
        return purchasedLottos;
    }

    public void updateTotalWinning(long winning){
        this.totalWinnings += winning;
    }

    public long getTotalWinnings() {
        return this.totalWinnings;
    }

    public long getTotalSpendings() {
        return this.totalSpendings;
    }


    public double getEarningRate() {
        double earningRate = ((double) totalWinnings / totalSpendings) * 100;
        return Math.round(earningRate * 100) / 100.0;
    }


}
