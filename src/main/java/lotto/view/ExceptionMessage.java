package lotto.view;

public class ExceptionMessage {
  private static final String INTEGER_ERROR = "[ERROR] 숫자만 입력해 주세요.";
  private static final String MIN_VALUE_ERROR = "[ERROR] 1000 이상의 금액을 입력해 주세요.";
  private static final String DIVISION_ERROR = "[ERROR] 1000 단위의 금액을 입력해 주세요.";
  private static final String LENGTH_6_ERROR = "[ERROR] 6개의 숫자를 쉼표로 구분하여 입력해 주세요.";
  private static final String WINNING_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
  private static final String WINNING_DUPLICATE_ERROR = "[ERROR] 로또 번호가 중복됩니다.";





  public static void typeException() {
    System.out.println(INTEGER_ERROR);
  }

  public static void minException() {
    System.out.println(MIN_VALUE_ERROR);
  }

  public static void divisionException() {
    System.out.println(DIVISION_ERROR);
  }

  public static void length6Exception(){
    System.out.println(LENGTH_6_ERROR);
  }

  public static void rangeException(){
    System.out.println(WINNING_RANGE_ERROR);
  }
  public static void duplicateException(){
    System.out.println(WINNING_DUPLICATE_ERROR);
  }
}
