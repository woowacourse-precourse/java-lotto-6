package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.view.validation.InputValidation.inputValidate;

public class InputView {

    public String inputMoney() {
        System.out.print("구입금액을 입력해 주세요.\n");
        return inputValidate(Console.readLine());
    }

    public String inputWinningNumbers() {
        System.out.print("당첨 번호를 입력해 주세요.\n");
        return inputValidate(Console.readLine());
    }

    public String inputBonusNumber() {
        System.out.print("보너스 번호를 입력해 주세요.\n");
        return inputValidate(Console.readLine());
    }
}
