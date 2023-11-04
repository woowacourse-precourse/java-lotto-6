package lotto.view;

import lotto.model.GameResult;
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
        System.out.println(userLottos);
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
        System.out.println(gameResult);
    }
}
