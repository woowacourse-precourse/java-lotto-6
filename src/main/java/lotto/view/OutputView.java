package lotto.view;

import static lotto.model.Lotto.allLottoList;
import static lotto.model.User.lottoBoughtNum;

import lotto.model.LottoRank;

import java.util.List;


public class OutputView {
    public static void printLottoBuyPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printBoughtNum() {
        System.out.println();
        System.out.println(lottoBoughtNum + "개를 구매했습니다.");
    }

    public static void printLotto() {
        List<List<Integer>> allLottoList = allLottoList();

        for (List<Integer> lotto : allLottoList) {
            System.out.println(lotto);
        }

    }

    public static void printUserNum() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNum() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printStats() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printLottoResult() {
        System.out.println("3개 일치 (5,000원) - " + rank5th + "개");
        System.out.println("4개 일치 (50,000원) - " + rank4th + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rank3rd + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rank2nd + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rank1st + "개");
    }

    public static void printRateOfReturn() {
        System.out.println("총 수익률은 " + formattedRateOfReturn + "입니다.");
    }
}
