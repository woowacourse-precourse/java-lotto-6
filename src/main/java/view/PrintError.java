package view;

/*
에러 메시지 관리, 출력
 */
public class PrintError {

  public PrintError() {

  }


  // 구입 금액이 숫자가 아닐 때 출력하는 메세지
  public void moneyNotNumber() {
    System.out.println("[ERROR] 구입금액은 숫자로 입력하여야 합니다.");
  }

  // 구입 금액이 1000 단위가 아닐 떄 출력하는 메세지
  public void moneyUnitOfThousand() {
    System.out.println("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
  }

  // 6자리가 아닐 때 출력하는 메세지
  public void numberSizeMessage() {
    System.out.println("[ERROR] 로또 번호는 6자리여야 합니다.");
  }

  // 1 ~ 45 사이의 숫자가 아닐 때 출력하는 메세지
  public void numberRangeMessage() {
    System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
  }

  // 중복 숫자가 있을 때 출력하는 메세지
  public void numberDuplicatedMessage() {
    System.out.println("[ERROR] 로또 번호는 중복되면 안됩니다.");
  }

  // 로또 번호와 보너스 번호는 중복될 때 출력하는 메세지
  public void numberBonusNumberDuplicatedMessage() {
    System.out.println("[ERROR] 로또 번호와 보너스 번호는 중복되면 안됩니다.");
  }



}
