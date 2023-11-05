package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.List;

public class ConsoleView implements View {
    private void out(String message) {
        System.out.println(message);
    }

    private void printLotto(Lotto lotto) {
        out(lotto.toString());
    }

    @Override
    public String getPurchaseAmount() {
        out("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    public String getWinningNumbers() {
        out("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    public String getBonusNumber() {
        out("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    public void printAllLotto(List lottos) {
        out(lottos.size() + "개를 구매했습니다.");
        for (Object temp : lottos) {
            Lotto lotto = (Lotto) temp;
            printLotto(lotto);
        }
    }

    @Override
    public void printWinningDetails(List scores) {
        out("3개 일치 (5,000원) - " + scores.get(0) + "개");
        out("4개 일치 (50,000원) - " + scores.get(1) + "개");
        out("5개 일치 (1,500,000원) - " + scores.get(2) + "개");
        out("5개 일치, 보너스 볼 일치 (30,000,000원) - " + scores.get(3) + "개");
        out("6개 일치 (2,000,000,000원) - " + scores.get(4) + "개");
    }

    @Override
    public void printTotalReturn(float totalReturn) {
        out("총 수익률은 " + String.format("%.2f", totalReturn) +"%입니다.");
    }

    @Override
    public void printError(String errorMessage) {
        out("[ERROR] " + errorMessage);
    }
}
