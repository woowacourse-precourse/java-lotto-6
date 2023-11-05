package lotto.Controller;

public class UIController {

    public static Integer makePurchasePrice() {
        int price = 0;
        while (true) {
            try {

                // TODO : printPurchasePriceInstruction , getPurchasePrice , validatePurchasePrice

                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입금액은 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1이상의 천단위 숫자만 가능합니다.");
            }
        }
        return price;
    }

}
