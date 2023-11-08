package lotto.Input.winningnumber;

import lotto.Either;
import lotto.Lotto;

public class BonusNumberInputContext {

  public static Either<String, ValidatedBonusNumber> validatedBonusNumber(Lotto lotto, String unValidatedBonusNumber) {
    return validatedBonusNumber(unValidatedBonusNumber, lotto);
  }

  private static Either<String, ValidatedBonusNumber> validatedBonusNumber(String unValidatedBonusNumber, Lotto lotto) {
    try {
      ValidatedBonusNumber validatedBonusNumber = ValidatedBonusNumber.of(unValidatedBonusNumber);
      isAlreadyExist(unValidatedBonusNumber, lotto);
      return Either.right(validatedBonusNumber);
    } catch (IllegalArgumentException e) {
      return Either.left("[ERROR]"+ e.getMessage());
    }
  }

  private static void isAlreadyExist(String unValidatedBonusNumber, Lotto lotto) {
    if (lotto.getNumbers().contains(Integer.parseInt(unValidatedBonusNumber))) {
      throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
  }
}
