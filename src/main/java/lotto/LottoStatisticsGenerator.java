package lotto;

import java.util.Map;

public class LottoStatisticsGenerator {

    private static final long[] prizeMoney = {5000, 50000, 1500000, 2000000000, 30000000};

    MoneyFormatUS moneyFormatUS = new MoneyFormatUS();

    public void statusEqualsCount(Map<String, Integer> equalsCount) {
        for(int i=3; i<=6; i++) {
            System.out.println(i+"개 일치 (" +
                    moneyFormatUS.moneyFormat(prizeMoney[i-3]) + "원) - " +
                    equalsCount.get(i+"개 일치") + "개");

            if(i==5) {
                System.out.println(i+"개 일치, 보너스 볼 일치 (" +
                        moneyFormatUS.moneyFormat(prizeMoney[i-1]) + "원) - " +
                        equalsCount.get(i+"개 일치, 보너스 볼 일치") + "개");
            }
        }
    }

    public double returnRate(Map<String, Integer> equalsCount, int buyNumber) {
        long sum = 0;
        for(int i=3; i<=6; i++) {
            sum +=equalsCount.get(i+"개 일치") * prizeMoney[i-3];

            if(i==5) {
                sum += equalsCount.get("5개 일치, 보너스 볼 일치") * prizeMoney[i-1];
            }
        }
        double result = ((double)sum/(double)(buyNumber*1000) * 100.0);
        return Math.round(result * 10) / 10.0;
    }
}
