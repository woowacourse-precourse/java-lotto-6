package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoPriceValidator;
import lotto.validator.WinningNumberValidator;

public class InputView {
    private static final String READ_LOTTO_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String READ_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private static final String WINNING_NUMBER_DELIMETER = ",";

    public static BigDecimal readLottoPrice() {
        System.out.println(READ_LOTTO_PRICE_MESSAGE);
        String input = Console.readLine();

        try {
            LottoPriceValidator.validate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readLottoPrice();
        }

        return new BigDecimal(input);
    }

    public static List<Integer> readWinningNumber() {
        System.out.println();
        System.out.println(READ_WINNING_NUMBER_MESSAGE);
        String input = Console.readLine();

        List<String> list;
        try {
            WinningNumberValidator.validateFormat(input);

            list = Arrays.asList(input.split(WINNING_NUMBER_DELIMETER));
            WinningNumberValidator.validateDuplicate(list);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readWinningNumber();
        }

        return list.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public static int readBonusNumber(List<Integer> winNumbers) {
        System.out.println();
        System.out.println(READ_BONUS_NUMBER_MESSAGE);
        String num = Console.readLine();

        try {
            BonusNumberValidator.validateBonusNumber(winNumbers, num);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBonusNumber(winNumbers);
        }

        return Integer.parseInt(num);
    }
}