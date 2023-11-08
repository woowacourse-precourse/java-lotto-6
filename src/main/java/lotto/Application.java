package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
  public static void main(String[] args) {
    // TODO: 프로그램 구현
    // Input 받는 함수 호출
    int purchase = getInput();

    // 로또 리스트 초기화
    List<Lotto> lottoList = new ArrayList<>();
    Lotto winningLotto;

    //로또 리스트 만들기
    generateLotto(purchase, lottoList);

    // 당첨 번호 입력
    winningLotto = getLottoNumber();

    // 보너스 번호 입력
    Integer bonus = getBonus(winningLotto);

    // 당첨 통계
    getStatistics(lottoList, winningLotto, bonus, purchase);
  }

  private static void getStatistics(List<Lotto> lottoList, Lotto winningLotto, Integer bonus, int purchase) {
    int[] result = new int[7];
    int bonusCount = 0;
    for (Lotto lotto : lottoList) {
      int count = 0;
      for (Integer number : lotto.getNumbers()) {
        if (winningLotto.getNumbers().contains(number)) {
          count++;
        }
      }
      if (count == 5 && lotto.getNumbers().contains(bonus)) {
        bonusCount++;
      }
      result[count]++;
    }

    System.out.println("당첨 통계");
    System.out.println("---");
    System.out.println("3개 일치 (5,000원) - " + result[3] + "개");
    System.out.println("4개 일치 (50,000원) - " + result[4] + "개");
    System.out.println("5개 일치 (1,500,000원) - " + result[5] + "개");
    System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + bonusCount + "개");
    System.out.println("6개 일치 (2,000,000,000원) - " + result[6] + "개");
    System.out.println("총 수익률은 " + getProfit(result, purchase) + "%입니다.");
  }

  private static String getProfit(int[] result, int purchase) {
    int total = 0;
    for (int i = 3; i < result.length; i++) {
      total += result[i] * getPrize(i);
    }
    return String.format("%.1f", (double) total / purchase * 100);
  }

  private static int getPrize(int i) {
    switch (i) {
      case 3:
        return 5000;
      case 4:
        return 50000;
      case 5:
        return 1500000;
      case 6:
        return 2000000000;
      default:
        return 0;
    }
  }

  private static int getBonus(Lotto winningLotto) {
    int bonusNumber;
    try {
      System.out.println("보너스 번호를 입력해 주세요.");
      bonusNumber = Integer.parseInt(Console.readLine());
      for (int number : winningLotto.getNumbers()) {
        if (bonusNumber == number) {
          throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복되는 숫자가 있습니다");
        }
      }
    } catch (IllegalArgumentException e) {
      System.out.println("[ERROR] 당첨 번호와 중복되는 숫자가 있습니다");
      bonusNumber = getBonus(winningLotto);
    }
    return bonusNumber;
  }

  private static Lotto getLottoNumber() {
    Lotto list;
    try {
      System.out.println("당첨 번호를 입력해 주세요");
      list = new Lotto(Arrays.stream(Console.readLine().split(","))
              .map(Integer::parseInt)
              .collect(Collectors.toList()));
      validateWinningLotto(list);
      return list;
    } catch (IllegalArgumentException e) {
      System.out.println("[ERROR] 유효한 6개의 숫자를 1~45 사이에서 입력해 주세요.");
      return getLottoNumber();
    }
  }

  private static void validateWinningLotto(Lotto numbers) {
    if (numbers.getNumbers().size() != 6 || numbers.getNumbers().stream().distinct().count() != 6 ||
            numbers.getNumbers().stream().anyMatch(number -> number < 1 || number > 45)) {
      throw new IllegalArgumentException("[ERROR] 유효한 6개의 숫자를 1~45 사이에서 입력해 주세요.");
    }
  }

  private static int getInput() {
    int purchase = 0;
    try {
      System.out.println("구입금액을 입력해 주세요.");
      purchase = Integer.parseInt(Console.readLine());
      if (purchase % 1000 != 0) {
        throw new IllegalArgumentException("Purchase amount must be a multiple of 1000.");
      }
    } catch (NumberFormatException e) {
      System.out.println("[ERROR] 숫자가 아닙니다");
      purchase = getInput();
    } catch (IllegalArgumentException e) {
      System.out.println("[ERROR] 잘못된 값을 입력하였습니다");
      purchase = getInput();
    }
    return purchase;
  }

  private static void generateLotto(int purchase, List<Lotto> lottoList) {
    for (int i = 0; i < purchase / 1000; i++) {
      lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
    }

    System.out.println(purchase / 1000 + "개를 구매했습니다.");
    for (Lotto l : lottoList) {
      l.printLotto();
    }
  }
}
