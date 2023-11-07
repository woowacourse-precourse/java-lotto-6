package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;

public class InputView {

    private final static String PURCHASE_AMOUNT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WIN_NUMBERS_REQUEST_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String NUMBER_REGEX = "^[0-9]+$";
    private static final String WIN_LOTTO_REGEX = "^\\d+,\\d+,\\d+,\\d+,\\d+,\\d+$";
    private static final String WIN_LOTTO_FORMAT_EXCEPTION_MESSAGE = "[ERROR] 1,2,3,4,5,6 형식으로 입력해주세요. %s";
    private static final String SPLIT_REGEX = ",";

    public long getPurchaseAmount() {
        try {
            System.out.println(PURCHASE_AMOUNT_REQUEST_MESSAGE);
            String input = Console.readLine();
            validate(input);
            return Long.parseLong(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
    }

    private void validate(String input) {
        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    public List<Integer> getWinLottoNumber() {
        try {
            System.out.println(WIN_NUMBERS_REQUEST_MESSAGE);
            String input = Console.readLine();
            validateWinLotto(input);
            return Stream.of(input.split(SPLIT_REGEX))
                    .map(Integer::parseInt)
                    .toList();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinLottoNumber();
        }
    }

    private static void validateWinLotto(String input) {
        if (!input.matches(WIN_LOTTO_REGEX)) {
            throw new IllegalArgumentException(String.format(WIN_LOTTO_FORMAT_EXCEPTION_MESSAGE, input));
        }
    }

    public int getBonusBall() {
        try {
            System.out.println(BONUS_NUMBER_REQUEST_MESSAGE);
            String input = Console.readLine();
            validate(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusBall();
        }
    }
}
