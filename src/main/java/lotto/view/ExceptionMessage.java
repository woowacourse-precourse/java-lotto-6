package lotto.view;

public class ExceptionMessage {
  private static final String INTEGER_ERROR = "[ERROR] 숫자만 입력해 주세요.";
  private static final String MIN_VALUE_ERROR = "[ERROR] 1000 이상의 금액을 입력해 주세요.";
  private static final String DIVISION_ERROR = "[ERROR] 1000 단위의 금액을 입력해 주세요.";

  public static void typeException() {
    System.out.println(INTEGER_ERROR);
  }

  public static void minException() {
    System.out.println(MIN_VALUE_ERROR);
  }

  public static void divisionException() {
    System.out.println(DIVISION_ERROR);
  }
}
