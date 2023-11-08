package lotto.domain;

import java.util.List;

public class Revenue {
    public static void rateOfRevenue(List<Prize> prizeList, int purchaseLottoMoney) {
        //수익률 출력(소수점 둘째 자리에서 반올림)
        double sumRevenue = 0;
        for(int i = 0; i < prizeList.size(); i++){
            sumRevenue += prizeList.get(i).getPrizeAmount();
        }
        double rateOfRevenueValue = sumRevenue / purchaseLottoMoney * 100;
        String resultRevenue = String.format("%.1f", rateOfRevenueValue);
        System.out.println("총 수익률은 " + resultRevenue + "%입니다.");
    }
}
