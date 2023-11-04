package lotto.view;

import java.util.ArrayList;
import java.util.List;
import lotto.model.GameResult;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Lottos;

public class OutputView {
    public static void showErrorMessage(String e){
        System.out.println("[ERROR]" + e);
    }
    public void showInputMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void showLottoAmountMessage(Integer ticketAmount) {
        System.out.println(ticketAmount + "개를 구매했습니다.");
    }

    public void showUserLottoMessage(Lottos userLottos) {
        StringBuilder sb  = new StringBuilder();
        for(Lotto lotto : userLottos.getLottosForMessage()){
            List<Integer> result = new ArrayList<>(lotto.getNumbersForMessage());
            result.sort((a,b)->a-b);
            sb.append(result+"\n");
        }
        System.out.println(sb);
    }

    public void showInputLottoNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void showInputLottoBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void showResultHeadMessage() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void showGameResult(GameResult gameResult) {
        StringBuilder sb = new StringBuilder();
        for (LottoResult result : LottoResult.values()) {
            if(!result.equals(LottoResult.NOTHING_MATCHES))
                sb.append(result.getMessage()).append(" - ").append(gameResult.getResultCounts().getOrDefault(result,0)).append("개\n");
        }
        sb.append("총 수익률은 ").append(String.format("%.1f", gameResult.getTotalProfit())).append("%입니다.");
        System.out.println(sb.toString());
    }
}
