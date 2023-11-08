package lotto.domain;

import java.util.Map;
import lotto.domain.dto.LottoResultDTO;

public class Calculator {
    private static final int RATE = 100;

    public static double profitCalculator(User user, LottoResultDTO lottoResultDTO) {
        int amount = user.getAmount();
        int totalPrizeMoney = calculateTotalPrizeMoney(lottoResultDTO);

        return totalPrizeMoney / (double) amount * RATE;
    }

    private static int calculateTotalPrizeMoney(LottoResultDTO lottoResultDTO) {
        int totalMoney = 0;
        Map<LottoRank, Integer> lottoResultInfo = lottoResultDTO.getLottoResultInfo();

        for (LottoRank rank : lottoResultInfo.keySet()) {
            totalMoney += rank.getMoney();
        }
        return totalMoney;
    }
}
