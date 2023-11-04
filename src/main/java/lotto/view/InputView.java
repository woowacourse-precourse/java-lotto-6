package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String ERROR_MESSAGE = "[ERROR] 올바른 형식이 아닙니다.";

    public static void askPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void askWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    /**
     * 숫자 리스트를 입력받는 함수
     *
     * @return : 숫자 리스트
     * @throws NumberFormatException : 숫자 리스트로 변환 실패한 경우
     */
    public static List<Integer> askNumbers() throws NumberFormatException {
        List<Integer> numbers;
        try {
            String input = Console.readLine();
            numbers = Arrays.stream(input.split(",", -1)).map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_MESSAGE);
        }
        return numbers;
    }

    /**
     * 숫자를 입력받는 함수
     *
     * @return : 숫자
     * @throws NumberFormatException : 숫자로 변환 실패한 경우
     */
    public static int askNumber() throws NumberFormatException {
        int number = 0;
        try {
            String input = Console.readLine();
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_MESSAGE);
        }
        return number;
    }
}