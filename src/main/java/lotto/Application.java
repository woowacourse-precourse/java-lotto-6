package lotto;

import java.util.List;

public class Application {
  public static void main(String[] args) {

    // 금액 입력
    LottoPurchaseAmountValidator print = new LottoPurchaseAmountValidator();
    int price = print.validatePurchaseAmount();
    System.out.println();

    // 몇 장인지 파악
    int page = print.calculateNumberOfTickets(price);
    System.out.println(page + "개를 구매했습니다.");

    // 랜덤한 로또 번호
    List<Lotto> randomLottoList = new Lotto().generateMultipleLotto(page);
    for (Lotto lott : randomLottoList) {
      System.out.println(lott.getNumbers());
    }

    // 당첨 로또 번호 입력
    InputLottoNumber inputLottoNumber = new InputLottoNumber();
    inputLottoNumber.inputNumber();
    inputLottoNumber.bonusNumber();

    // 비교


  }
}
