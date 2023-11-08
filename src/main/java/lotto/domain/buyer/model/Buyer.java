package lotto.domain.buyer.model;

import lotto.domain.lotto.model.Lotto;

import java.util.List;
import java.util.Map;

public class Buyer {

    static final int LOTTO_NUMBER_SIZE = 6;

    private List<Lotto> lottos;
    private Map<String, String> result;
    private long profitRate;

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<String, String> getResult() {
        return result;
    }

    public void setResult(Map<String, String> result) {
        this.result = result;
    }

    public long getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(long profitRate) {
        this.profitRate = profitRate;
    }

    public void printLottos() {

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
    
    public void printResult() {
        //TODO 결과 출력
    }
    
    public void printProfitRate() {
        //TODO 수익률 출력
    }
}
