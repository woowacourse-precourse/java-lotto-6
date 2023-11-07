package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Display {
    static int readPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        try {
            int price = Integer.parseInt(input);
            if(price % 1000 > 0) {
                throw new IllegalStateException();
            }
            System.out.println(price / 1000 + "개를 구매했습니다.");
            return price;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    static Lotto readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();
        try {
            String[] tokens = input.split(",");
            return new Lotto(Arrays.stream(tokens).map(Integer::parseInt)
                    .collect(Collectors.toList()));
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    static Bonus readBonusNumber(Lotto winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return new Bonus(bonusNumber, winningNumbers);
    }

    public static void showIssuedLottos(List<Lotto> issuedLottos) {
        for(Lotto lotto : issuedLottos) {
            System.out.println(lotto);
        }
    }


    public static void showRanks(Map<Rank, Integer> resultRanks) {
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println("3개 일치 (5,000원) - " + resultRanks.getOrDefault(Rank.fifth, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + resultRanks.getOrDefault(Rank.fourth, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + resultRanks.getOrDefault(Rank.third, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultRanks.getOrDefault(Rank.second, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + resultRanks.getOrDefault(Rank.first, 0) + "개");
    }

    public static void showStatistics(double revenueRate) {
        System.out.println("총 수익률은 " + revenueRate + "%입니다.");
    }
}
