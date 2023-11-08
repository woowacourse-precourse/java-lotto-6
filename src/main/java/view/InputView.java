package view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static validate.Validate.validateMinimumPurchaseAmount;
import static validate.Validate.validateNotDividePurchaseAmount;
import static validate.Validate.validateNumberExceptionHandler;

public class InputView {

    public static final String USER_PURCHASE_AMOUNT_MESSAGE = "구매금액을 입력해주세요";
    public static final String RESULT_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int purchaseAmount() {
        System.out.println(USER_PURCHASE_AMOUNT_MESSAGE);
        try {
            int userPurchaseAmount = validateNumberExceptionHandler(readLine());
            validateMinimumPurchaseAmount(userPurchaseAmount);
            validateNotDividePurchaseAmount(userPurchaseAmount);
            return userPurchaseAmount;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return purchaseAmount();
        }
    }

    public static String[] inputLottoResultNumber() {
        System.out.println(RESULT_NUMBER_MESSAGE);
        try {
            String inputLottoResultNumber = readLine();
            String[] lottoResult = inputLottoResultNumber.split(",");
            System.out.println();
            return lottoResult;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLottoResultNumber();
        }
    }

    public static int inputBonusResultNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        try {
            int inputBonusNumber = validateNumberExceptionHandler(readLine());
            System.out.println();

            return inputBonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusResultNumber();
        }
    }

}
