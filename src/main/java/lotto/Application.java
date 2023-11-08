package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = "";

        while (purchaseAmount.isEmpty()) {
            purchaseAmount = Console.readLine();
            if (!isValidPurchaseAmount(purchaseAmount)) {
                purchaseAmount = "";
                IllegalArgumentException e = new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위입니다.");
                System.out.println(e.getMessage());
            }
        }

        return purchaseAmount;
    }

    public static boolean isValidPurchaseAmount(String amount) {
        try {
            double value = Double.parseDouble(amount);
            return value % 1000 == 0;
        } catch (NumberFormatException e) {
            return false; // 숫자로 변환할 수 없는 경우 유효하지 않음
        }
    }

    public static int calculateAndPrintLottoQuantity(String purchaseAmount) {
        int lottoQuantity = Integer.parseInt(purchaseAmount) / 1000;
        System.out.println(lottoQuantity + "개를 구매했습니다.");
        return lottoQuantity;
    }

    public static void main(String[] args) {
        String purchaseAmount = inputPurchaseAmount();
        System.out.println();

        int lottoQuantity = calculateAndPrintLottoQuantity(purchaseAmount);
        // generateAndPrintLottoNumbers();
    }
}
