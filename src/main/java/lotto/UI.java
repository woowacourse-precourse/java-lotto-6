package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UI {
    public static String inputMoneyValue() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        return money;
    }

    public static void printLottoNum(List<List<Integer>> lottoNum, int moneyValue) {
        System.out.println();
        System.out.println(moneyValue / 1000 + "개를 구매했습니다.");

        for (int i = 0; i < moneyValue / 1000; i++) {
            System.out.println(lottoNum.get(i));
        }
        System.out.println();
    }

    public static String inputWinningNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNum = Console.readLine();
        return winningNum;
    }

    public static String inputBonusNum() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }

    public static void printWinningStatistics(int[] result, double rate) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result[0] / Award.세개.get상금() + "개");
        System.out.println("4개 일치 (50,000원) - " + result[1] / Award.네개.get상금() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result[2] / Award.다섯개.get상금() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result[3] / Award.다섯개보너스.get상금() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result[4] / Award.여섯개.get상금() + "개");
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
