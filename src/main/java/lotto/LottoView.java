package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.text.NumberFormat;
import java.util.Locale;

public class LottoView {

    ErrorHandler errorHandler = new ErrorHandler();
    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요");
        String amount = Console.readLine();
        errorHandler.checkIfNumber(amount);
        return Integer.parseInt(amount);
    }

    public void printPurchasedLottoNumbers(Lotto[] lottos) {
        System.out.println(lottos.length + "개를 구매했습니다.");
        for (int i = 0; i < lottos.length; i++) {
            System.out.println(lottos[i].getNumbers());
        }
    }

    public String inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public Integer inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
        String nums = Console.readLine();
        errorHandler.checkIfNumber(nums);
        return Integer.parseInt(nums);
    }

    public void printWinningInformation(Rank[] ranks) {
        System.out.println("당첨 통계");
        System.out.println("---");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.KOREA);
        String countIndex = "";
        for (Rank rank : ranks) {
            countIndex = rank.getRank() + "개 일치 ";
            if (rank.getRank().equals("5B")) {
                countIndex = "5개 일치, 보너스 볼 일치 ";
            }
            System.out.println(countIndex + "(" + numberFormat.format(rank.getMoney()).replace("₩", "") + "원) - "
                    + rank.getAmount() + "개");
        }
    }

    public void printProfitRate(double profitRate) {
        String formatted = String.format("%.1f", profitRate);
        System.out.println("총 수익률은 " + formatted + "%입니다.");
    }

}
