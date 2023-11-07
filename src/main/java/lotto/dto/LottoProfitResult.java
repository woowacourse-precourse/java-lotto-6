package lotto.dto;

import lotto.Prize;

import java.util.List;

public record LottoProfitResult(
        List<Info> profits,
        Double profitPercent
) {

    public record Info(
            int rank,
            int price,
            int count,
            boolean withBonus
    ) {

        public static Info from(Prize prize, int count) {
            return new Info(
                    prize.getMatch(),
                    prize.getProfit(),
                    count,
                    prize.isWithBonus()
            );
        }
    }

}
