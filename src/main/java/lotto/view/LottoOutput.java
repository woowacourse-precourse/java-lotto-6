package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.global.constant.LottoConstant;
import lotto.global.constant.LottoRankAndPrize;
import java.util.List;
import java.util.Map;

public class LottoOutput {

    public LottoOutput(){
    }

    private final String INITIAL_LOTTO_STATIC_MESSAGE = "당첨 통계\n---\n";

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

    public String printLottoStatistics(LottoResult lottoResult){

        Map<LottoRankAndPrize, Integer> totalRanks = lottoResult.getTotalRanks();
        stringBuffer = new StringBuffer();
        stringBuffer.append(INITIAL_LOTTO_STATIC_MESSAGE);
        stringBuffer.append(printFirstRank(totalRanks.get(LottoRankAndPrize.FIRST_RANK))+"\n");
        stringBuffer.append(printSecondRank(totalRanks.get(LottoRankAndPrize.SECOND_RANK))+"\n");
        stringBuffer.append(printThirdRank(totalRanks.get(LottoRankAndPrize.THIRD_RANK))+"\n");
        stringBuffer.append(printFourthRank(totalRanks.get(LottoRankAndPrize.FOURTH_RANK))+"\n");
        stringBuffer.append(printFifthRank(totalRanks.get(LottoRankAndPrize.FIFTH_RANK))+"\n");
        stringBuffer.append(String.format("총 수익률은 %.1f%%입니다", lottoResult.calculateProfitPercentage()));
        return stringBuffer.toString();
    }

    public String printFirstRank(int rankCount){
        return printLottoRankFormat(LottoConstant.PRINT_FIRST_RANK, rankCount);
    }

    public String printSecondRank(int rankCount){
        return printLottoRankFormat(LottoConstant.PRINT_SECOND_RANK, rankCount);
    }

    public String printThirdRank(int rankCount){
        return printLottoRankFormat(LottoConstant.PRINT_THIRD_RANK, rankCount);
    }

    public String printFourthRank(int rankCount){
        return printLottoRankFormat(LottoConstant.PRINT_FOURTH_RANK, rankCount);
    }

    public String printFifthRank(int rankCount){
        return printLottoRankFormat(LottoConstant.PRINT_FIFTH_RANK, rankCount);
    }

    public String printLottoRankFormat(String lottoRankMessage, int rankCount){
        return lottoRankMessage + rankCount + "개";
    }
}
