package lotto.utils.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Parser;
import lotto.validation.Validator;

import java.util.List;

public class InputManager {
    private static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private InputManager() {
    }

    public static int receivePurchasePrice() {
        int result;
        try {
            System.out.println(INPUT_PURCHASE_PRICE_MESSAGE);
            String input = Console.readLine();
            Validator.validatePurchasePrice(input);

            result = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return receivePurchasePrice();
        }
        return result;
    }

    public static List<Integer> receiveNumbers() {
        List<Integer> numbers = null;
        try {
            System.out.println();
            System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
            String input = Console.readLine();

            Validator.validateNumbers(input);
            numbers = Parser.stringToIntList(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return receiveNumbers();
        }
        return numbers;
    }

    public static int receiveBonusNumber(List<Integer> lottoNumbers) {
        int result;
        try {
            System.out.println();
            System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
            String input = Console.readLine();
            Validator.validateBonusNumber(lottoNumbers, input);

            result = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return receiveBonusNumber(lottoNumbers);
        }
        return result;
    }
}
