package lotto.model;

import java.util.Objects;

public class Number {

  private static final int MIN_NUMBER_RANGE = 1;
  private static final int MAX_NUMBER_RANGE = 45;

  private int number;

  public Number(int number) {
    validateRangeNumber(number);
    this.number = number;
  }

  private void validateRangeNumber(int number) {
    if (isInRange(number)) {
      throw new IllegalArgumentException();
    }
  }

  private boolean isInRange(int number) {
    return number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE;
  }

  public int getNumber() {
    return number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Number number1 = (Number) o;
    return number == number1.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }
}
