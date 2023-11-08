package lotto.utils;

import static lotto.constants.LottoConstants.LOTTO_DIVISION;
import static lotto.constants.LottoConstants.LOTTO_MIN_LENGTH;
import static lotto.constants.LottoConstants.LOTTO_NUMBER_OVER_MAX;
import static lotto.constants.LottoConstants.LOTTO_SIZE_MAX_LENGTH;
import static lotto.exception.Validator.validateCheckPrice;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.exception.ErrorMsg;
import lotto.exception.UserInputException;

public class LottoUtils {

    public static int divisionLottoPrice(int price) {
        while (true) {
            try {
                validateCheckPrice(price);
                return (price / LOTTO_DIVISION);
            } catch (UserInputException e) {
                System.out.println(ErrorMsg.ERROR_LOTTO_PRICE_DIVISON.getMsg());
            } catch (NumberFormatException e) {
                System.out.println(ErrorMsg.ERROR_LOTTO_NUMBER_NOT_DIVISION_1000.getMsg());
                price = rePromptForPrice();
            }
        }
    }

    private static int rePromptForPrice() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException ex) {
            System.out.println(ErrorMsg.ERROR_LOTTO_NUMBER_NOT_DIVISION_1000.getMsg());
            return rePromptForPrice();
        }
    }

    public static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_LENGTH, LOTTO_NUMBER_OVER_MAX, LOTTO_SIZE_MAX_LENGTH);
    }
}
