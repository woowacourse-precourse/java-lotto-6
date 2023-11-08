package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class LottoConsole {
    public static String inputAmount() {
        System.out.println("구입금액을 입력해주세요.");
        return Console.readLine();
    }

    public static void printLottoListInfo(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        lottos.forEach(lotto -> {
            String lottoInfo = lotto.getNumbers()
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(lottoInfo);
        });
    }

    public static String inputAnswerNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static void printPrizeResults(List<LottoPrize> prizes, Double ROI) {
        Map<LottoPrize, Long> prizeCountMap = new HashMap<>();
        for (LottoPrize prize : LottoPrize.values()) {
            prizeCountMap.put(prize, 0L);
        }
        for (LottoPrize prize : prizes) {
            prizeCountMap.put(prize, prizeCountMap.get(prize) + 1);
        }

        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", prizeCountMap.get(LottoPrize.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개\n", prizeCountMap.get(LottoPrize.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", prizeCountMap.get(LottoPrize.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", prizeCountMap.get(LottoPrize.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", prizeCountMap.get(LottoPrize.FIRST));
        System.out.println("총 수익률은 " + ROI + "%입니다.");
    }
}
