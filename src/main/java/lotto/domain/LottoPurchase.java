package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class LottoPurchase {
    private static Integer purchaseAmount;

    public void lottoPurchaseManager() {
        setLottoPurchase(readPurchaseAmount());
    }

    public static void setLottoPurchase(String amount) {
        validate(amount);
        purchaseAmount = Integer.parseInt(amount);
    }

    public Integer getLottoPurchase() {
        return purchaseAmount;
    }

    private static String readPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Console.readLine();
    }

    private static void validate(String amount) {
        validateIsNumber(amount);
        validateIsDivisibleBy1000(amount);
        validateIsPositiveInteger(amount);
    }

    private static void validateIsNumber(String amount) {
        try {
            Double.parseDouble(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    private static void validateIsDivisibleBy1000(String amount) {
        if((Double.parseDouble(amount) % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
        }
    }

    private static void validateIsPositiveInteger(String amount) {
        if(Double.parseDouble(amount) <= 0) {
            throw new IllegalArgumentException("[ERROR] 최소 구입 금액은 1,000원입니다.");
        }
    }
}
