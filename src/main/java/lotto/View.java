package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class View {
    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int number = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                number = Integer.parseInt(Console.readLine());
                if (number % 1000 != 0 || number < 1000) throw new IllegalArgumentException();
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력하실 수 있습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1,000원 단위로 입력하세요.");
            }
        }
        return number;
    }

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static String[] getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine().split(",");
    }

    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static void printResult(double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRank rank : LottoRank.values()) {
            System.out.println(rank.getPrizeInfo() + rank.getAdditionalMatches() + "개");
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }
}
