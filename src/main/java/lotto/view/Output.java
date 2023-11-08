package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class Output {

  public static void printPurchasedLottoCount(int count) {
    System.out.println(count + "개를 구매했습니다.");
  }

  public static void printGeneratedLottoNumbers(List<Lotto> lottoTickets) {
    lottoTickets.stream()
        .map(Lotto::getNumbers)
        .map(numbers -> {
          List<Integer> sortedNumbers = new ArrayList<>(numbers);
          Collections.sort(sortedNumbers);
          return sortedNumbers;
        })
        .forEach(sortedNumbers -> {
          String formattedNumbers = sortedNumbers.stream()
              .map(number -> String.valueOf(number))
              .collect(Collectors.joining(", ", "[", "]"));
          System.out.println(formattedNumbers);
        });
  }



  public static void printResult(List<Integer> resultList) {
    System.out.println("당첨 통계");
    System.out.println("---");
    System.out.printf("3개 일치 (5,000원) - %d개%n", resultList.get(4));
    System.out.printf("4개 일치 (50,000원) - %d개%n", resultList.get(3));
    System.out.printf("5개 일치 (1,500,000원) - %d개%n", resultList.get(2));
    System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", resultList.get(1));
    System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", resultList.get(0));
  }

  public static void printProfitRate(double profitRate) {
    System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
  }
}
