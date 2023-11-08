package lotto.Input.amount;

import lotto.Input.IssueLottoCommand;

public class InputtedPurchaseAmountEvent {

  private final IssuedNumber issuedNumber;

  private InputtedPurchaseAmountEvent(IssuedNumber issuedNumber) {
    this.issuedNumber = issuedNumber;
  }

  public static InputtedPurchaseAmountEvent of(IssuedNumber issuedNumber) {
    return new InputtedPurchaseAmountEvent(issuedNumber);
  }

  public IssueLottoCommand toIssueLottoCommand() {
    return IssueLottoCommand.of(issuedNumber);
  }
}
