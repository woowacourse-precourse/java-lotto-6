package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.View.UIView;

public class UIController {

    public static Integer makePurchasePrice() {
        int price = 0;
        while (true) {
            try {
                UIView.printPurchasePriceInstruction();
                price = getPurchasePrice();

                // TODO : validatePurchasePrice

                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입금액은 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1이상의 천단위 숫자만 가능합니다.");
            }
        }
        return price;
    }


    private static int getPurchasePrice() {
        return Integer.parseInt(Console.readLine());
    }
}
