package lotto;

import static lotto.Input.inputBonusNumber;
import static lotto.Input.inputLottoNumber;
import static lotto.Input.inputWinningNumbers;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

  public static void main(String[] args) {
    int purchaseCount;
    ArrayList<Integer> winningNumbers;
    int bonusNumber;

    while (true) {
      try {
        System.out.println("구입금액을 입력해 주세요.");
        purchaseCount = inputLottoNumber(Console.readLine()) / Const.LOTTO_PRICE;
        break;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }

    System.out.println(purchaseCount + "개를 구매했습니다.");
    List<Lotto> lottos = new ArrayList<>();
    for (int i = 0; i < purchaseCount; i++) {
      Lotto lotto = new Lotto();
      lottos.add(lotto);
      lotto.printNumbers();
    }

    while (true) {
      try {
        System.out.println("당첨 번호를 입력해 주세요.");
        winningNumbers = (ArrayList<Integer>) inputWinningNumbers(Console.readLine());
        break;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }

    while (true) {
      try {
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = inputBonusNumber(Console.readLine(), winningNumbers);
        break;
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }

    int priceSum = 0;
    double returnRate;
    Map<Rank, Integer> rankCount = new HashMap<>();
    rankCount.put(Rank.FIRST, 0);
    rankCount.put(Rank.SECOND, 0);
    rankCount.put(Rank.THIRD, 0);
    rankCount.put(Rank.FORTH, 0);
    rankCount.put(Rank.FIFTH, 0);

    for (Lotto lotto : lottos) {
      Rank rank = lotto.confirmRank((List<Integer>)winningNumbers.clone(), bonusNumber);
      if (rank != null) {
        priceSum += rank.getPrice();
        rankCount.put(rank, rankCount.get(rank) + 1);
      }
    }
    returnRate = Math.round((double) priceSum * 10 / purchaseCount) / 100.0;
    Print.printStatistics(rankCount, returnRate);
  }
}
