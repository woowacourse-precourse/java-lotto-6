package lotto;

import java.util.List;

public class Buyer {
    private final int purchaseAmount;
    private final LottoMachine lottoMachine;
    private List<Lotto> myLotteries;


    public Buyer(int purchaseAmount, LottoMachine lottoMachine) {
        this.purchaseAmount = purchaseAmount;
        this.lottoMachine = lottoMachine;
    }

    public void buyLotteries() {
        myLotteries = lottoMachine.publishLotteries(purchaseAmount);
    }

    public double calculateReturnRate(long prizeSum) {
        double seedMoney = 1000 * purchaseAmount;
        return (double) Math.round((prizeSum / seedMoney) * 1000) / 10;
    }

    // myLotteries를 할당하지 않은 영우 get요청을 한다면 illegalstateExcept 추가하기
    public List<Lotto> getMyLotteries() {
        return myLotteries;
    }
}
