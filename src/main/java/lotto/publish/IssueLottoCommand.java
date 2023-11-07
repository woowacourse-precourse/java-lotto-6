package lotto.publish;

import lotto.Input.IssuedNumber;

public class IssueLottoCommand {

  private final IssuedNumber issuedNumber;

  private IssueLottoCommand(IssuedNumber issuedNumber) {
    this.issuedNumber = issuedNumber;
  }

  public static IssueLottoCommand of(IssuedNumber issuedNumber) {
    return new IssueLottoCommand(issuedNumber);
  }

  public IssuedNumber getIssuedNumber() {
    return issuedNumber;
  }
}
