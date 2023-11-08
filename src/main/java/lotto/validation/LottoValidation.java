package lotto.validation;

import java.util.List;

public class LottoValidation {
  private static final int STANDARD_UNIT = 1000;

  public static void validateOverStandardUnit(int amount) {
    if (amount < STANDARD_UNIT) {
      throw new IllegalArgumentException("[ERROR] 구입 금액은 최소 1000원입니다.");
    }
  }

  public static void validateIsStandardUnit(int amount) {
    if (amount % STANDARD_UNIT != 0) {
      throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
    }
  }

}