package lotto.view;

import lotto.LottoPurchaseInfo;

public class OutputView {

    public static void printLottoPurchaseInfo(LottoPurchaseInfo lottoPurchaseInfo) {
        System.out.println(lottoPurchaseInfo.getCount() + "개를 구매했습니다.");
        System.out.println(lottoPurchaseInfo.getLottosNumber());
    }



    public static void printException(IllegalArgumentException e) {
        System.out.println("[ERROR] : " + e.getMessage());
    }
}
