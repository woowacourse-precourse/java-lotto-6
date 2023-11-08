package lotto.Input;

import static java.lang.System.out;

import camp.nextstep.edu.missionutils.Console;
import lotto.Either;
import lotto.Input.amount.InputtedPurchaseAmountEvent;
import lotto.Input.amount.IssuedNumber;
import lotto.Input.amount.PurchaseInputConext;
import lotto.Input.winningnumber.NumberEnteredCommand;
import lotto.Input.winningnumber.NumberEnteredEvent;
import lotto.Input.winningnumber.BonusNumberInputContext;
import lotto.Input.winningnumber.ValidatedBonusNumber;
import lotto.Input.winningnumber.WinningNumberInputContext;
import lotto.Lotto;

public class InputContext {

  private static final int LOTTO_PRICE = 1000;

  public static InputtedPurchaseAmountEvent inputPurchaseAmount() {
    out.println(InputPrompts.Input_MONEY.getMessage());
    String unValidatedString = Console.readLine();
    Either<String, IssuedNumber> stringIssuedNumberEither = PurchaseInputConext.inputPurchaseAmount(
        unValidatedString, LOTTO_PRICE);
    if (stringIssuedNumberEither.isLeft()) {
      out.println(stringIssuedNumberEither.getLeft());
      return inputPurchaseAmount();
    }
    return InputtedPurchaseAmountEvent.of(stringIssuedNumberEither.getRight());
  }

  public static StatisticsStartCommand inputWinningNumber(NumberEnteredCommand command) {
    out.println();
    out.println(InputPrompts.INPUT_WINNING_NUMBER.getMessage());
    Either<String, Lotto> either = WinningNumberInputContext.validatedWinningLotto(
        Console.readLine());
    if (either.isLeft()) {
      out.println(either.getLeft());
      return inputWinningNumber(command);
    }
    out.println();
    ValidatedBonusNumber bonusNumber = getValidatedBonusNumber(either);
    NumberEnteredEvent event = NumberEnteredEvent.of(either.getRight(), bonusNumber);
    out.println(event.getBonusNumber().getBonusNumber());
    return StatisticsStartCommand.of(event, command.getLottos(), LOTTO_PRICE);
  }

  private static ValidatedBonusNumber getValidatedBonusNumber(Either<String, Lotto> either) {
    out.println(InputPrompts.INPUT_BONUS_NUMBER.getMessage());
    Either<String, ValidatedBonusNumber> bonusNumberEither = BonusNumberInputContext.validatedBonusNumber(
        either.getRight(), Console.readLine());
    while (bonusNumberEither.isLeft()) {
      out.println(bonusNumberEither.getLeft());
      out.println(InputPrompts.INPUT_BONUS_NUMBER.getMessage());
      bonusNumberEither = BonusNumberInputContext.validatedBonusNumber(either.getRight(),
          Console.readLine());
    }
    return bonusNumberEither.getRight();
  }
}
