package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.lottoUI.ERRORUI;
import lotto.lottoUI.LottoUI;

public class BuyLotto {
    private static int Purchase_amount;

    public static void Set_amount() {
        while (true) {
            LottoUI.InputPurchaseAmount();
            try {
                Purchase_amount = Integer.parseInt(readLine());
                if (validatePurchaseAmount(Purchase_amount)) {
                    break;
                }
            } catch (NumberFormatException ex) {
                ERRORUI.NumberFormatException();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        PublishLotto.PrintLotto(GetPurchase_amount());
    }

    public static int GetPurchase_amount() {
        return Purchase_amount;
    }

    private static boolean validatePurchaseAmount(int amount) {
        System.out.println(amount);
        if (amount % 1000 != 0) {
            System.out.println(ERRORUI.MultipleOfThousandError());
            return false;
        }

        if (amount < 0) {
            System.out.println(ERRORUI.InputNegativeError());
            return false;
        }

        if (amount % 1 != 0) {
            System.out.println(ERRORUI.InputDecimalPointNumberError());
            return false;
        }

        return true;
    }
}