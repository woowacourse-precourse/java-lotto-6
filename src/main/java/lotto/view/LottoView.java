package lotto.view;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;
import lotto.model.Lotto;
import lotto.model.Lotto.WinningRank;

public class LottoView {

    // 로또 구입 금액 입력 받기
    public static Integer inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(Console.readLine());
        return price;
    }

    // 로또 구매 결과 출력
    public static void printPurchaseResult(List<Lotto> lottoList) {
        System.out.println();
        System.out.println(lottoList.size()+"개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    // 로또 당첨 번호 입력 받기
    public static String inputWinningNumber() {
        System.out.println();
        System.out.println("당첨번호를 입력해 주세요.");
        return Console.readLine();
    }

    // 보너스 번호 입력 받기
    public static String inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static void printWinningResults(int[] rankCounts) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        WinningRank[] ranks = WinningRank.values();
        Collections.reverse(Arrays.asList(ranks));
        for (WinningRank rank : ranks) {
            String matchingString = rank.getMatchingCount() + "개 일치";
            if (rank == WinningRank.SECOND) {
                matchingString = "5개 일치, 보너스 볼 일치";
            }
            if (rank != WinningRank.NONE) {
                System.out.printf("%s (%,d원) - %d개%n", matchingString, rank.getPrize(), rankCounts[rank.ordinal()]);
            }
        }

    }

}
