package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import lotto.lottoUI.ERRORUI;
import lotto.lottoUI.LottoUI;

public class LottoPurchase {
    private static int Purchase_amount;

    public static void Set_amount() {
        boolean isValidAmount = false;
        while (!isValidAmount) {
            LottoUI.InputPurchaseAmount();
            try {
                Purchase_amount = Integer.parseInt(readLine());
                validatePurchaseAmount(Purchase_amount);
                isValidAmount = true; // 유효한 금액이 입력되면 루프 종료
            } catch (NumberFormatException ex) {
                ERRORUI.NumberFormatException();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        LottoPublisher lottoPublisher = new LottoPublisher(Purchase_amount);
        LottoPublisher.PrintLotto();
    }

    public static int GetPurchase_amount() {
        return Purchase_amount;
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ERRORUI.MultipleOfThousandError());
        }

        if (amount < 0) {
            throw new IllegalArgumentException(ERRORUI.InputNegativeError());
        }
    }

    public static void Set_amountWithNegativeAmount() {
        Purchase_amount = -1000; // 음수 값을 주어 예외를 발생시킴
        validatePurchaseAmount(Purchase_amount);
    }

    public static void Set_amountWithMultiplesOfThousand() {
        Purchase_amount = 2300; // 1000의 배수가 아닌 값을 주어 예외를 발생 시킴
        validatePurchaseAmount(Purchase_amount);
    }
}
