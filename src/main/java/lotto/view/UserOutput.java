package lotto.view;

import java.util.List;

public class UserOutput {
    public static void winningDetails(List counts) {
        System.out.println(String.format("3개 일치 (5,000원) - %d개", counts.get(0)));
        System.out.println(String.format("4개 일치 (50,000원) - %d개", counts.get(1)));
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개", counts.get(2)));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", counts.get(3)));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개", counts.get(4)));
    }

    public static String rateOfReturn(int winningAmount, int purchaseAmount) {
        return String.format("%.1f", (double) winningAmount / purchaseAmount * 100);
    }
}
