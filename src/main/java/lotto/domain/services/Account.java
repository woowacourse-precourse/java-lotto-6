package lotto.domain.services;

import lotto.contants.LottoEnum;
import lotto.controller.view.Output;

import java.util.Map;

public class Account {
    private final Output output;

    public Account(Output output) {
        this.output = output;
    }

    public void profitAccount(Map<LottoEnum.grade, Integer> gradeMap, int amount){
        double prize =
                gradeMap.get(LottoEnum.grade.FIFTH) * 5000 +
                        gradeMap.get(LottoEnum.grade.FOURTH) * 50000 +
                        gradeMap.get(LottoEnum.grade.THIRD) * 1500000 +
                        gradeMap.get(LottoEnum.grade.SECOND) * 30000000 +
                        gradeMap.get(LottoEnum.grade.FIRST) * 2000000000;

        double profitRate = prize*100/(double)amount;
        double roundedProfitRate = Math.round(profitRate*100.0)/100.0;
        output.printProfitRate(roundedProfitRate);
    }
}
