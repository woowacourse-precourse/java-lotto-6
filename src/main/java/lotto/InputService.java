package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputService {

    public static String getUserInputForPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return readLine();
    }

    private static int validateAmount(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.CONVERT_ERROR);
        }
    }



}