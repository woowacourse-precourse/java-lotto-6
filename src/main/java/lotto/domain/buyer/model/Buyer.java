package lotto.domain.buyer.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

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

    public Map<String, Integer> getResult() {
        return result;
    }

    public void setResult(Map<String, Integer> result) {
        this.result = result;
    }

    public long getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(long profitRate) {
        this.profitRate = profitRate;
    }

    public void printLottos() {

        StringBuilder sb = new StringBuilder();

        for(Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            sb.append("[");
            for(int i=0; i<LOTTO_NUMBER_SIZE-1; i++) {
                sb.append(lottoNumbers.get(i) + ", ");
            }
            sb.append(lottoNumbers.get(lottoNumbers.size()));
            sb.append("]");
            sb.toString();
        }
    }
    
    public void printResult() {
        //TODO 결과 출력
    }
    
    public void printProfitRate() {
        //TODO 수익률 출력
    }
}
