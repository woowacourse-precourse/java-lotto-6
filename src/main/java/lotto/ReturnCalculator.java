package lotto;

import java.util.Map;

public class ReturnCalculator {
    public int totalWinningAmount = 0;
    private Map<LottoMessage, Integer> lottoResult;

    public ReturnCalculator(Map<LottoMessage, Integer> lottoResult) {

        this.lottoResult = lottoResult;
    }
    public void calculrator(){
        for(Map.Entry<LottoMessage, Integer> entry : lottoResult.entrySet()){
            if(entry.getValue() > 0){
                totalWinningAmount += entry.getKey().winningAmount * entry.getValue();
            }
            System.out.println(entry.getKey().message + " - " + entry.getValue() + "개");
        }
    }
}
