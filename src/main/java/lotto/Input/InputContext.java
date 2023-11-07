package lotto.Input;

import static java.lang.System.out;

import camp.nextstep.edu.missionutils.Console;
import lotto.Either;

public class InputContext {
  public static InputtedPurchaseAmountEvent inputPurchaseAmount(){
    out.println(InputPrompts.Input_MONEY.getMessage());
    String unValidatedString = Console.readLine();
    Either<String, IssuedNumber> stringIssuedNumberEither = PurchaseInputConext.inputPurchaseAmount(
        unValidatedString, 1000);
    if (stringIssuedNumberEither.isLeft()) {
      out.println(stringIssuedNumberEither.getLeft());
      return inputPurchaseAmount();
    }
    return InputtedPurchaseAmountEvent.of(stringIssuedNumberEither.getRight());
  }
}
