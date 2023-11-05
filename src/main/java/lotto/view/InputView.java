package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.message.ExceptionMessage;

public class InputView {
    private static final String READ_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String READ_WINNER_NUMBERS_MESSAGE = "당첨 번호를 쉼표(,)로 구분하여 입력해 주세요.";
    private static final String READ_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요";

    public static int readPurchaseAmount() {
        System.out.println(READ_PURCHASE_AMOUNT_MESSAGE);
        try {
            String inputPurchaseAmount = Console.readLine();
            return Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER.getMessage());
        }
    }

    public static List<Integer> readLottoNumbers() {
        System.out.println(READ_WINNER_NUMBERS_MESSAGE);
        String inputLottoNumbers = Console.readLine();
        try {
            return Arrays.stream(inputLottoNumbers.trim().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER.getMessage());
        }
    }

    public static int readBonusNumber() {
        System.out.println(READ_BONUS_NUMBER_MESSAGE);
        String inputBonusNumber = Console.readLine();
        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER.getMessage());
        }
    }
}
