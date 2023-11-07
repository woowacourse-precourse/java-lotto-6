package lotto.utils;

import static lotto.constants.LottoConstants.LOTTO_DIVISION;
import static lotto.constants.LottoConstants.LOTTO_MIN_LENGTH;
import static lotto.constants.LottoConstants.LOTTO_NOT_DIVISION;
import static lotto.constants.LottoConstants.LOTTO_NUMBER_OVER_MAX;
import static lotto.constants.LottoConstants.LOTTO_SIZE_MAX_LENGTH;
import static lotto.constants.LottoConstants.PATTERN;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.text.DecimalFormat;
import java.util.List;
import lotto.constants.LottoMsg;
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
            }
            price = Integer.parseInt(Console.readLine());
        }
    }

    public static void validateCheckPrice(int price) {
        if (price % LOTTO_DIVISION != LOTTO_NOT_DIVISION) {
            throw new UserInputException(ErrorMsg.ERROR_LOTTO_PRICE_DIVISON.getMsg());
        }
    }

    public static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_LENGTH, LOTTO_NUMBER_OVER_MAX, LOTTO_SIZE_MAX_LENGTH);
    }

    public static void rateFormat(double rateNumber) {
        DecimalFormat decimalFormat = new DecimalFormat(PATTERN);
        System.out.println(
                String.format(LottoMsg.LOTTO_LATE.getMsg(), decimalFormat.format(rateNumber)));
    }

    public static int getPriceForIntegerParser(String price) {
        String priceParser = price.replaceAll("[^0-9]", "");
        return Integer.parseInt(priceParser);
    }
}
