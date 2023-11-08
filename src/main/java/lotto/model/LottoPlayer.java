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
    private int totalSpendings;


    public LottoPlayer(){
        this.purchasedLottos = new ArrayList<>();
        this.winningsCountMap = new HashMap<>();
        this.totalWinnings = 0;
        this.totalSpendings = 0;
    }

    public void purchaseLottos(int numberOfLottos) {
        this.purchasedLottos.addAll(LottoGame.generatePurchasedLotto(numberOfLottos));
        this.totalSpendings += numberOfLottos * LottoConstants.LOTTO_PRICE.getPrice();// 가정: Lotto.PRICE는 로또의 가격
    }


    public List<Lotto> getPurchasedLottos(){
        return purchasedLottos;
    }

    public void updateTotalWinning(long winning){
        this.totalWinnings += winning;
    }

    public double getEarningRate() {
        if (totalSpendings == 0) {
            throw new ArithmeticException("지출이 0이어서 수익률을 계산할 수 없습니다.");
        }
        double earningRate = ((double) totalWinnings / totalSpendings) * 100; // 여기서 100을 곱함
        earningRate = Math.round(earningRate * 100) / 100.0; // 소수점 둘째 자리까지 반올림
        return earningRate;
    }


}
