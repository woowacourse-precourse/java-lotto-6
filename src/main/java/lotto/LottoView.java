package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class LottoView {

    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        return Integer.parseInt(purchaseAmount);
    }

    public void displayPurchasedLottos(List<Lotto> purchasedLottos) {
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
        for (Lotto purchasedLotto : purchasedLottos) {
            System.out.println(purchasedLotto.getNumbers());
        }
    }

    public List<Integer> getWinnerNums() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winnerNums = Console.readLine();
        return Arrays.stream(winnerNums.split(",")).map(Integer::parseInt).toList();
    }

    public int getBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNum = Console.readLine();
        return Integer.parseInt(bonusNum);
    }

    public void printResult(List<Integer> results, double earningRate) {
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (" + df.format(Result.THREE.getEarnings()) + "원) - " + results.get(Result.THREE.ordinal()) + "개");
        System.out.println("4개 일치 (" + df.format(Result.FOUR.getEarnings()) + "원) - " + results.get(Result.FOUR.ordinal()) + "개");
        System.out.println("5개 일치 (" + df.format(Result.FIVE.getEarnings()) + "원) - " + results.get(Result.FIVE.ordinal()) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + df.format(Result.FIVE_BONUS.getEarnings()) + "원) - " + results.get(Result.FIVE_BONUS.ordinal()) + "개");
        System.out.println("6개 일치 (" + df.format(Result.SIX.getEarnings()) + "원) - " + results.get(Result.SIX.ordinal()) + "개");
        System.out.println("총 수익률은 " + earningRate + "%입니다.");
    }
}
