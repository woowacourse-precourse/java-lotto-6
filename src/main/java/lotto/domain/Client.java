package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;

import lotto.validation.Validation;

public class Client {
    private static final int PURCHASE_AMOUNT_MINIMUM_UNIT = 1000;
    private final ArrayList<Lotto> clientLottoList = new ArrayList<>();
    private final HashMap<Prize,Integer> result = new HashMap<>();
    private final int purchaseAmount;

    public Client(int purchaseAmount){
        validateBuyAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public ArrayList<Lotto> getClientLottoList(){
        return clientLottoList;
    }

    public void addClientLotto(Lotto lotto) {
        clientLottoList.add(lotto);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private void validateBuyAmount(int amount) {
        Validation.validateMultipleNumber(amount, PURCHASE_AMOUNT_MINIMUM_UNIT);
    }

    public HashMap<Prize, Integer> getResult() {
        return result;
    }

    public double getEarningRate() {
        double origin = (getPrizeSum()/(double)purchaseAmount)*100;
        return Math.round(origin*10)/10.0;
    }

    public long getPrizeSum() {
        long sum = 0L;
        for (Prize prize : result.keySet()) {
            sum += prize.getReward() * result.get(prize);
        }
        return sum;
    }
}
