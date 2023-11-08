package lotto.dto;

import java.util.ArrayList;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.Ranking;

public class ConsumerDto {
    private PurchaseAmount purchaseAmount;
    private ArrayList<Lotto> consumerLottos;
    private Map<Ranking, Integer> resultBoard;
    private float returnOfRate;

    public PurchaseAmount getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public ArrayList<Lotto> getConsumerLottos() {
        return consumerLottos;
    }

    public void setConsumerLottos(ArrayList<Lotto> consumerLottos) {
        this.consumerLottos = consumerLottos;
    }

    public Map<Ranking, Integer> getResultBoard() {
        return resultBoard;
    }

    public void setResultBoard(Map<Ranking, Integer> resultBoard) {
        this.resultBoard = resultBoard;
    }

    public float getReturnOfRate() {
        return returnOfRate;
    }

    public void setReturnOfRate(float returnOfRate) {
        this.returnOfRate = returnOfRate;
    }
}
