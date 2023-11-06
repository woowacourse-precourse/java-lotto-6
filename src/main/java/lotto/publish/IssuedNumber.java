package lotto.publish;

import lotto.Either;

public class IssuedNumber {

  private int value;

  private IssuedNumber(int value) {
    this.value = value;
  }

  public static Either<String, IssuedNumber> of(int value) {
    if (value < 1) {
      return Either.left("발행 횟수는 1이상만 가능합니다.");
    }
    return Either.right(new IssuedNumber(value));
  }

  public int getValue() {
    return value;
  }
}
