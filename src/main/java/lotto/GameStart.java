package lotto;

import java.util.List;

public class GameStart {

  public static void run() {
    InputPrice.createPriceNumber();
    lottoPurchaseMessage();
    InputNumber.createPrizeNumber();
  }

  public static void lottoPurchaseMessage() {
    int count = InputPrice.createPriceNumber() / 1000;
    System.out.println(count + "개를 구매했습니다.");
    List<Integer> prizeNumberList = InputNumber.createPrizeNumber();
    System.out.println(prizeNumberList);
  }
}
