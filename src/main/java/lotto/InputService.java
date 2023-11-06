package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputService {

    public static final int AMOUNT_UNIT = 1000;

    public static int getUserInputForPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        int purchaseAmount = validateAmount(readLine());
        validateAmountUnit(purchaseAmount);
        return purchaseAmount;
    }

    public static Lotto getUserInputForLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = readLine();
        return validateLottoNumbersFormat(numbers);
    }

    private static Lotto validateLottoNumbersFormat(String numbers) {
        try {
            List<Integer> lotto = Stream.of(numbers.trim().split("\\s*, \\s*"))
                    .mapToInt(Integer::parseInt).boxed()
                    .collect(Collectors.toList());
            return new Lotto(lotto);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.CONVERT_AMOUNT_ERROR);
        }
    }

    private static int validateAmount(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.CONVERT_AMOUNT_ERROR);
        }
    }

    private static void validateAmountUnit(int purchaseAmount) {
        checkAmountIsSufficient(purchaseAmount);
        checkAmountUnitIsCorrect(purchaseAmount);
    }

    private static void checkAmountUnitIsCorrect(int purchaseAmount) {
        if (purchaseAmount % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_AMOUNT_ERROR);
        }
    }

    private static void checkAmountIsSufficient(int purchaseAmount) {
        if (purchaseAmount < AMOUNT_UNIT) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_AMOUNT_ERROR);
        }
    }


}