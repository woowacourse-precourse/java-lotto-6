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
        return stringBuffer.toString();
    }

    public void printAllRandomLotto(List<Lotto> lottos){
        System.out.println();
        System.out.format("%d개를 구매했습니다.\n",lottos.size());
        for(Lotto lotto : lottos){
            System.out.println(printRandomLotto(lotto.getNumbers()));
        }
        System.out.println();
    }

    public String printLottoStatistics(LottoResult lottoResult){

        Map<LottoRankAndPrize, Integer> totalRanks = lottoResult.getTotalRanks();
        stringBuffer = new StringBuffer();
        stringBuffer.append(INITIAL_LOTTO_STATIC_MESSAGE);
        stringBuffer.append(printFifthRank(totalRanks.get(LottoRankAndPrize.FIFTH_RANK))+"\n");
        stringBuffer.append(printFourthRank(totalRanks.get(LottoRankAndPrize.FOURTH_RANK))+"\n");
        stringBuffer.append(printThirdRank(totalRanks.get(LottoRankAndPrize.THIRD_RANK))+"\n");
        stringBuffer.append(printSecondRank(totalRanks.get(LottoRankAndPrize.SECOND_RANK))+"\n");
        stringBuffer.append(printFirstRank(totalRanks.get(LottoRankAndPrize.FIRST_RANK))+"\n");
        stringBuffer.append(String.format("총 수익률은 %.1f%%입니다", lottoResult.calculateProfitPercentage()));
        String result = stringBuffer.toString();
        System.out.println(result);
        return result;
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
