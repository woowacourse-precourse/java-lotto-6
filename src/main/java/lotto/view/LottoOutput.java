package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.global.constant.LottoRankAndPrize;

import java.util.List;
import java.util.Map;

public class LottoOutput {

    private final String INITIAL_LOTTO_STATIC_MESSAGE = "당첨 통계";

    private StringBuffer stringBuffer;

    public String printRandomLotto(List<Integer> lottoNumbers){
        stringBuffer = new StringBuffer();

        stringBuffer.append("[");
        int lottoLength = lottoNumbers.size();
        for(int i = 0; i < lottoLength - 1; i++){
            stringBuffer.append(lottoNumbers.get(i)+", ");
        }
        stringBuffer.append(lottoNumbers.get(lottoLength - 1)+"]");
        String returnValue = stringBuffer.toString();
        System.out.println(returnValue);
        return returnValue;
    }

    public String printAllRandomLotto(List<Lotto> lottos){
        stringBuffer = new StringBuffer();

        for(Lotto lotto : lottos){
            stringBuffer.append(printRandomLotto(lotto.getNumbers()));
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    public String printLottoStatistics(Map<LottoRankAndPrize, Integer> totalRanks){
        for (Map.Entry<LottoRankAndPrize, Integer> entry : totalRanks.entrySet()) {
            LottoRankAndPrize rankAndPrize = entry.getKey();
            int count = entry.getValue();
        }
    }

    public String printFirstRank(LottoRankAndPrize lottoRankAndPrize){

    }
}
