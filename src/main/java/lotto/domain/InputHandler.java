package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Validator;
import lotto.constants.ErrorMessage;

public class InputHandler {
    // TODO : 사용자의 입력에 대한 처리

    public static User askPayment() {
        String input = "";
        do {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                input = Console.readLine();
                Validator.validatePayment(input);
                return new User(input);
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.NUMBER_FORMAT.getMessage());
            }
        } while (true);
    }

    public void askWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        Console.readLine();
    }

    public void askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        Console.readLine();
    }
}
