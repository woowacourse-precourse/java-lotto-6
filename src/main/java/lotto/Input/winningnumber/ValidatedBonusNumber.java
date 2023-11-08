package lotto.Input.winningnumber;

public class ValidatedBonusNumber {

  private final int bonusNumber;

  private ValidatedBonusNumber(int bonusNumber) {
    this.bonusNumber = bonusNumber;
  }

  public static ValidatedBonusNumber of(String bonusNumber) {
    String regex = "^(?:[1-9]|[1-3][0-9]|4[0-5])$";
    if (!bonusNumber.matches(regex)) {
      throw new IllegalArgumentException("보너스 번호는 1~45 사이의 숫자만 가능합니다.");
    }
    return new ValidatedBonusNumber(Integer.parseInt(bonusNumber));
  }

  public int getBonusNumber() {
    return bonusNumber;
  }
}
