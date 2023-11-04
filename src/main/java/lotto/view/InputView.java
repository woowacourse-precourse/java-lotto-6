package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.Validation;

public class InputView {

    /**
     * 당첨 번호를 입력받는 함수
     *
     * @return : 숫자 리스트 형식의 당첨 번호
     * @throws IllegalArgumentException : 숫자 리스트 변환에 실패
     */
    public static List<Integer> askWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            String input = Console.readLine();
            return Arrays.stream(input.split(",", -1)).map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 올바른 형식이 아닙니다.");
        }
    }

    /**
     * 보너스 번호를 입력받는 함수
     *
     * @param lotto : 당첨 번호
     * @return : 보너스 번호
     * @throws IllegalArgumentException : 숫자 여부, 번호 개수, 번호 범위, 즁복
     */
    public static int askBonusNumber(Lotto lotto) throws IllegalArgumentException {
        System.out.println("보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                Validation.bonusNumber(input, lotto);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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