package lotto.io;

import lotto.domain.Lottos;

public class Output {

    public void printInputMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printMyLottoCount(int money) {
        System.out.printf("%d개를 구매했습니다.", money/1000);
        System.out.println();
    }

    public void printInputWinningNumbersMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printInputBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
