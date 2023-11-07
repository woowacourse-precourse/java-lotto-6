package lotto.domain;

import java.util.Map;
import lotto.domain.dto.LottoResultDTO;

public class Calculator {

    public static double profitCalculator(User user, LottoResultDTO lottoResultDTO){
        int amount = user.getAmount();
        int totalPrizeMoney = calculateResultTotalMoney(lottoResultDTO);

        return totalPrizeMoney/(double) amount * 100;
    }

    private static int calculateResultTotalMoney(LottoResultDTO lottoResultDTO){
        int totalMoney = 0;
        Map<LottoRank, Integer> lottoResultInfo = lottoResultDTO.getLottoResultInfo();

        for(LottoRank rank : lottoResultInfo.keySet()){
            totalMoney += rank.getMoney();
        }
        System.out.println(totalMoney);
        return totalMoney;
    }
}
