package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoResult;
import lotto.model.Lottos;

public class LottoView {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_AMOUNT = "개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요";

    public LottoView() {}

    public String inputUserAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);

        return Console.readLine();
    }

    public void printLottoNumbers(Lottos lottos) {
        System.out.println();
        System.out.println(lottos.getSize() + PURCHASE_AMOUNT);
        System.out.println(lottos);
    }

    public String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

    public void printWinningStatistics(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoResult.getWinningResult(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResult.getWinningResult(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.getWinningResult(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.getWinningResult(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResult.getWinningResult(0) + "개");
        System.out.println("총 수익률은 " + String.format("%.1f", lottoResult.getEarningRate()) + "%입니다.");
    }
}
