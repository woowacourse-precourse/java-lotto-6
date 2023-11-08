package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import java.util.List;

public class LottoController {

  private static final LottoController controller = new LottoController();

  private LottoController() {
  }

  public static LottoController getInstance() {
    return controller;
  }

  public int getUserInputForAmount() {
    while (true) {
      try {
        InputView.inputPriceMessage();
        String input = Console.readLine();
        return InputValidator.validatePurchaseAmount(input);
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  public List<Integer> getUserInputForWinningNumbers() {
    while (true) {
      try {
        InputView.inputWinningNumberMessage();
        final String input = Console.readLine();
        return InputValidator.validateWinningNumbers(input);
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  public int getUserInputForBonusNumber(List<Integer> winningNumbers) {
    while (true) {
      try {
        InputView.inputWinningBonusNumberMessage();
        final String input = Console.readLine();
        return InputValidator.validateBonusNumber(input, winningNumbers);
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

}
