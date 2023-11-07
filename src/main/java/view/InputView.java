package view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final int VALID_LOTTO_SIZE = 6;
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final String SPLIT_DELIMITER = ", ";
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String MESSAGE_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_INPUT_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_INPUT_LOTTO_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String MESSAGE_LOTTO_QUANTITY = "%d개를 구매했습니다.";
    private static final String ERROR_MESSAGE_FOR_DUPLICATE_LOTTO_NUMBER = "숫자는 중복될 수 없습니다.";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int scanInputMoney() {
        System.out.println(MESSAGE_INPUT_MONEY);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static List<Integer> scanInputLottoNumbers() {
        System.out.println(MESSAGE_INPUT_LOTTO_NUMBERS);
        return 
    }


}
