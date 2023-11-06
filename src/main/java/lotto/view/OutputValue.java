package lotto.view;

import java.util.List;

public class OutputValue {
    public static void guidePrize(List<Integer> resultList) {
        System.out.printf("%s%n", OutputMessage.PRIZE_GUIDE.getMessage());
        System.out.printf("%s%n", OutputMessage.THREE_MATCH.getMessage(resultList.get(0)));
        System.out.printf("%s%n", OutputMessage.FOUR_MATCH.getMessage(resultList.get(1)));
        System.out.printf("%s%n", OutputMessage.FIVE_MATCH.getMessage(resultList.get(2)));
        System.out.printf("%s%n", OutputMessage.BONUS_MATCH.getMessage(resultList.get(3)));
        System.out.printf("%s%n", OutputMessage.SIX_MATCH.getMessage(resultList.get(4)));
    }

    public static void guideRate(String rate) {
        System.out.printf("%s%n", OutputMessage.GUIDE_RATE.getMessage(rate));
    }

    public static void guidePurchaseList(int purchaseAmount) {
        System.out.printf("%n%s%n", OutputMessage.PURCHASE.getMessage(purchaseAmount / 1000));
    }
}
