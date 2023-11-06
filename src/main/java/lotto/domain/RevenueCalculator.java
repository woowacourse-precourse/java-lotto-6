    package lotto.domain;

    public class RevenueCalculator {


        public double calculateRevenueRate(long totalEarnings, Money money) {
            if(money.getAmount() == LottoConfig.ZERO.getValue()){
                return LottoConfig.ZERO.getValue();
            }

            return (double) totalEarnings / money.getAmount() * LottoConfig.PROFIT_RATE_BASE.getValue();
        }

    }
