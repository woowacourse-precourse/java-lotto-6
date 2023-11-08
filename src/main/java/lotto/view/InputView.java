package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String START_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_ERROR = "[ERROR] 금액은 숫자를 입력해야 합니다.";
    private static final String LUCKY_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_REQUEST_MESSAGE = "보너스 번호를 입력해 주세요.";

    public int inputMoney() {
        while (true) {
            try {
                System.out.println(START_MESSAGE);
                return Integer.parseInt(Console.readLine());

            } catch (IllegalArgumentException e) {
                System.out.println(NUMBER_ERROR);
            }
        }
    }

    public String inputLucky() {
        System.out.println(LUCKY_REQUEST_MESSAGE);
        return Console.readLine();
    }

    public int inputBonus() {
        while (true) {
            try {
                System.out.println(BONUS_REQUEST_MESSAGE);
                String bonus = Console.readLine();
                return Integer.parseInt(bonus);
            } catch (IllegalArgumentException e) {
                System.out.println(NUMBER_ERROR);
            }
        }
    }
}
