package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.InputValidator;

public class InputView {

  private final InputValidator inputValidator;

  public InputView(InputValidator inputValidator) {
    this.inputValidator = inputValidator;
  }

  private enum InputMessage {
    PURCHASE_MONEY("구매금액을 입력해 주세요."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
      this.message =  message;
    }
  }

  public String inputPurchaseMoneyOfLotto() {
    System.out.println(InputMessage.PURCHASE_MONEY.message);
    String input = Console.readLine();
    inputValidator.basicValidation(input);
    return input;
  }

//  public String inputWinningNuber() {
//    System.out.println(InputMessage.WINNING_NUMBER.message);
//    String input = Console.readLine();
//    inputValidator.basicValidation(input);
//    return input;
//  }

  public String inputBonusNumber() {
    System.out.println(InputMessage.BONUS_NUMBER.message);
    String input = Console.readLine();
    inputValidator.basicValidation(input);
    return input;
  }
}
