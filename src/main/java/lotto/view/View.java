package lotto.view;

import java.util.List;

public class View {
    public static void printPurchasedLotteries(int count){
        System.out.println();
        System.out.printf("%d개를 구매했습니다.", count);
        System.out.println();
    }
    public static void printPurchasedLotteries(List<Integer> nums){
        System.out.println(nums);
    }
}
