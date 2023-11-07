package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.inputvalidator.InputValidator;

public class InputView {
    private final InputValidator inputValidator = new InputValidator();
    // input에서는 빈칸가 없는지 확인과 숫자 ','로만 이루어져 있는지 확인

    public int inputPrice() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String userInput = Console.readLine();
                inputValidator.validate(userInput);

                return Integer.parseInt(userInput);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public String inputWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String userInput = Console.readLine();
                inputValidator.validate(userInput);

                return userInput;
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public int inputBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String userInput = Console.readLine();
                inputValidator.bonusNumberInputValidate(userInput);

                return Integer.parseInt(userInput);
            } catch (IllegalArgumentException e) {
            }
        }
    }

}
