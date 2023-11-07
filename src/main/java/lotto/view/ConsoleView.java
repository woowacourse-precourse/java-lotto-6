package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.Ranking;

import java.util.List;

public class ConsoleView implements View {
    private String in(){
        return Console.readLine();
    }
    private void out(String message) {
        System.out.println(message);
    }

    private void printLotto(Lotto lotto) {
        out(lotto.toString());
    }

    @Override
    public String getPurchaseAmount() {
        out("구입금액을 입력해 주세요.");
        return in();
    }

    @Override
    public String getWinningNumbers() {
        out("당첨 번호를 입력해 주세요.");
        return in();
    }

    @Override
    public String getBonusNumber() {
        out("보너스 번호를 입력해 주세요.");
        return in();
    }

    @Override
    public void printAllLottery(List<Lotto> lotteries) {
        out(lotteries.size() + "개를 구매했습니다.");
        for (Lotto lottery : lotteries) {
            printLotto(lottery);
        }
    }

    @Override
    public void printScoreDetails(List rankings) {
        out("당첨 통계");
        out("---");
        out("3개 일치 (5,000원) - " + Ranking.getCount(rankings, Ranking.FIFTH) + "개");
        out("4개 일치 (50,000원) - " + Ranking.getCount(rankings, Ranking.FORTH) + "개");
        out("5개 일치 (1,500,000원) - " + Ranking.getCount(rankings, Ranking.THIRD) + "개");
        out("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Ranking.getCount(rankings, Ranking.SECOND) + "개");
        out("6개 일치 (2,000,000,000원) - " + Ranking.getCount(rankings, Ranking.FIRST) + "개");
    }

    @Override
    public void printTotalReturn(float totalReturn) {
        out("총 수익률은 " + String.format("%.1f", totalReturn) +"%입니다.");
    }

    @Override
    public void printError(String errorMessage) {
        out("[ERROR] " + errorMessage);
    }
}
