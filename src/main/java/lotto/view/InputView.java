package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.Converter;
import lotto.validation.InputValidator;

public class InputView {

  private final InputValidator inputValidator;
  private final Converter converter;

  public InputView(InputValidator inputValidator, Converter converter) {
    this.inputValidator = inputValidator;
    this.converter = converter;
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

  public int inputPurchaseMoneyOfLotto() {
    System.out.println(InputMessage.PURCHASE_MONEY.message);
    String input = Console.readLine();
    validatePurchaseMoney(input);

    return converter.toNumber(input);
  }

  public List<Integer> inputWinningNumbers() {
    System.out.println(InputMessage.WINNING_NUMBER.message);
    String input = Console.readLine();
    String[] inputNumbers = converter.toSplit(input);
    validateWinningNumbers(input, inputNumbers);

    return Arrays.stream(inputNumbers)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  public String inputBonusNumber() {
    System.out.println(InputMessage.BONUS_NUMBER.message);
    String input = Console.readLine();
    validateBonusNumber(input);

    return input;
  }

  private void validatePurchaseMoney(String input) {
    inputValidator.validateInputEmpty(input);
    inputValidator.validateInputBlank(input);
    inputValidator.validateInputNumeric(input);
  }

  private void validateWinningNumbers(String input, String[] inputNumbers) {
    inputValidator.validateInputEmpty(input);
    inputValidator.validateInputBlank(input);
    inputValidator.validateNumbersNumeric(inputNumbers);
  }

  private void validateBonusNumber(String input) {
    inputValidator.validateInputEmpty(input);
    inputValidator.validateInputBlank(input);
    inputValidator.validateInputNumeric(input);
  }
}
