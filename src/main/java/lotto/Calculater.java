package lotto;

import java.util.HashMap;

public class Calculater {
    public static int calculatePrize1(HashMap<Integer, Integer> winHashTable){ // 3 ~ 5등인 로또를 확인하고, 3 ~ 5등 로또 당첨금을 리턴한다
        int totalPrizeMoney = 0; // 총 당첨금을 담기 위해 선언
        if(winHashTable.get(5) > 0){ // 5등인 로또가 1개 이상이면
            totalPrizeMoney+= LottoPrize.THREE_MATCH.getPrizeAmount() * winHashTable.get(5); // 5000 * 5등 로또 개수
        }
        if(winHashTable.get(4) > 0){ // 4등인 로또가 1개 이상이면
            totalPrizeMoney+= LottoPrize.FOUR_MATCH.getPrizeAmount() * winHashTable.get(4); // 50000 * 4등 로또 개수
        }
        if(winHashTable.get(3) > 0){ // 3등 로또가 1개 이상이면
            totalPrizeMoney+= LottoPrize.FIVE_MATCH.getPrizeAmount() * winHashTable.get(3); // 1500000 * 3등 로또 개수
        }
        return totalPrizeMoney;
    }
    public static int calculatePrize2(HashMap<Integer, Integer> winHashTable){ // 1 ~ 2등인 로또를 확인하고, 1 ~ 2등 로또 당첨금을 리턴한다
        int totalPrizeMoney = 0; // 총 당첨금을 담기 위해 선언
        if(winHashTable.get(2) > 0){ // 2등인 로또가 1개 이상이면
            totalPrizeMoney+= LottoPrize.FIVE_MATCH_WITH_BONUS.getPrizeAmount() * winHashTable.get(2); // 30000000 * 2등 로또 개수
        }
        if(winHashTable.get(1) > 0){ // 1등인 로또가 1개 이상이면
            totalPrizeMoney+= LottoPrize.SIX_MATCH.getPrizeAmount() * winHashTable.get(1); // 2000000000 * 1등 로또 개수
        }
        return totalPrizeMoney;
    }
    public static double changeToRate(int totalMoney, int perchaseInput){ // 총 수익률을 구한다
        double totalRate = (double)totalMoney/perchaseInput; // 당첨 금액/구매 금액
        String totalRateToString = String.format("%.1f", totalRate * 100); // 100을 곱하면 총 수익률을 구할 수 있다
        return Double.parseDouble(totalRateToString);
    }
}
