package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.Validation;

public class InputView {

    private static final String ERROR_MESSAGE = "[ERROR] 올바른 형식이 아닙니다.";

    /**
     * 당첨 번호를 입력받는 함수
     *
     * @return : 숫자 리스트 형식의 당첨 번호
     * @throws NumberFormatException : 숫자 리스트로 변환 실패
     */
    public static List<Integer> askWinningNumber() throws NumberFormatException {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber;
        try {
            String input = Console.readLine();
            winningNumber = Arrays.stream(input.split(",", -1)).map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_MESSAGE);
        }
        return winningNumber;
    }

    /**
     * 보너스 번호를 입력받는 함수
     *
     * @return : 보너스 번호
     * @throws NumberFormatException : 숫자로 변환 실패
     */
    public static int askBonusNumber() throws NumberFormatException {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = 0;
        try {
            String input = Console.readLine();
            bonusNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_MESSAGE);
        }
        return bonusNumber;
    }

    /**
     * 구입 금액을 입력받는 함수
     *
     * @return : 구입 금액
     * @throws IllegalArgumentException : 숫자 여부, 번호 개수, 번호 범위, 단위
     */
    public static int askPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                Validation.price(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}