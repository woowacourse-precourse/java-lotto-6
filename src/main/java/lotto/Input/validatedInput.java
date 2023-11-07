package lotto.Input;

import lotto.publish.IssueLottoCommand;

public class validatedInput {
  private final IssuedNumber issuedNumber;

  private validatedInput(IssuedNumber issuedNumber) {
    this.issuedNumber = issuedNumber;
  }

  public static validatedInput of(IssuedNumber issuedNumber) {
    return new validatedInput(issuedNumber);
  }

  public IssueLottoCommand toIssueLottoCommand() {
    return IssueLottoCommand.of(issuedNumber);
  }
}
