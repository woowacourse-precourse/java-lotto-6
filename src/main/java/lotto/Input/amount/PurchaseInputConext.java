package lotto.Input.amount;

import lotto.Either;

public class PurchaseInputConext {

  public static Either<String, IssuedNumber> inputPurchaseAmount(String unValidatedInput, int standardPrice) {
    try {
      int i = validated(unValidatedInput, standardPrice);
      return Either.right(IssuedNumber.of(i / standardPrice).getRight());
    } catch (IllegalArgumentException e) {
      return Either.left("[ERROR]: " + e.getMessage());
    }
  }

  private static int validated(String unValidatedInput, int standardPrice) {
    if (!unValidatedInput.matches("^[\\d]+$")) {
      throw new IllegalArgumentException("숫자만 입력 가능합니다.");
    }
    int i = Integer.parseInt(unValidatedInput);
    if (i < standardPrice || i % standardPrice != 0) {
      throw new IllegalArgumentException("구입 금액은 1000원 이상이며 1000원 단위로만 가능합니다.");
    }
    return i;
  }
}
