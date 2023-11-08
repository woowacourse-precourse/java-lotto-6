package lotto.view;

import lotto.domain.Lottos;

public class OutputView {
    public void printMoneyPrompt() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoPurchaseMessage(long money) {
        System.out.println(money / 1000 + "개를 구매했습니다.");
    }

    public void printWinningLottoPrompt() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberPrompt() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printUserLottos(Lottos userLottos) {
        System.out.println(userLottos);
    }

    public void printLottoResult(String result) {
        System.out.println(result);
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
