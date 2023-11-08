package lotto;

import java.util.ArrayList;
import java.util.List;

public class GameStart {

  private static List<Integer> lotto = new ArrayList<>();

  private static List<Lotto> lottoList;

  public static void run() {
    int count = InputPrice.createPriceNumber();
    lottoPurchaseMessage(count);
    InputNumber.createPrizeNumber();
    statistics();
  }

  public static void lottoPurchaseMessage(int ccount) {
    int count = ccount / 1000;
    System.out.println("");
    System.out.println(count + "개를 구매했습니다.");

    makeLottoList(count);
    System.out.println("");

    //List<Integer> prizeNumberList = InputNumber.createPrizeNumber();
    //System.out.println(prizeNumberList);
  }


  public static Lotto makeLotto() {
    Random lottoNums = new Random();
    lotto = new ArrayList<>();

    lotto = lottoNums.createLottoGroup();
    System.out.println(lotto);

    return new Lotto(lotto);
  }

  private static List<Lotto> makeLottoList(int lottoCount) {
    lottoList = new ArrayList<>();
    for (int i = 0; i < lottoCount; i++) {
      lottoList.add(makeLotto());
    }
    return lottoList;
  }

  public static void statistics() {
    System.out.println("당첨 통계");
    System.out.println("---");

  }
}
