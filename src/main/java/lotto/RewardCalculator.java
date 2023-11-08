package lotto;

import java.util.Collections;
import java.util.List;

import lotto.LottoEnum.Prize;

public class RewardCalculator {
    public int getReward(Prize lottoResult) {
        if (lottoResult == Prize.FIRST) {
            return 2000000000;
        } else if (lottoResult == Prize.SECOND) {
            return 30000000;
        } else if (lottoResult == Prize.THIRD) {
            return 1500000;
        } else if (lottoResult == Prize.FOURTH) {
            return 50000;
        } else if (lottoResult == Prize.FIFTH) {
            return 5000;
        }

        return 0;
    }

    public int getTotalReward(List<Prize> lottoResults) {
        int totalReward = 0;

        for (Prize lottoResult : lottoResults) {
            totalReward += getReward(lottoResult);
        }

        return totalReward;
    }

    public void printResult(List<Prize> lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개", Collections.frequency(lottoResults,Prize.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개", Collections.frequency(lottoResults,Prize.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개", Collections.frequency(lottoResults,Prize.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", Collections.frequency(lottoResults,Prize.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개", Collections.frequency(lottoResults,Prize.FIRST));
        System.out.printf("총 수익률은 %f.1 %%입니다.", (((float)getTotalReward(lottoResults)) / 1000 / lottoResults.size() * 100));
    }
}
