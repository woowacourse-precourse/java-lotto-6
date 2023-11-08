package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.inputvalidator.InputValidator;

public class InputView {
    private final InputValidator inputValidator = new InputValidator();

    public int inputPrice() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String userInput = Console.readLine();
                System.out.println();

                inputValidator.priceInputValidate(userInput);

                return Integer.parseInt(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String inputWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String userInput = Console.readLine();
                System.out.println();

                inputValidator.lottoWinningNumberValidate(userInput);

                return userInput;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
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
                System.out.println(e.getMessage());
            }
        }
    }

}
