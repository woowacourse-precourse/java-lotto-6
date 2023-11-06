package lotto;

import java.util.List;

public class Output {
    private void getPriceMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private void countTicketMessage(int lottoCnt) {
        System.out.println(lottoCnt + "개를 구매했습니다.");
    }

    private void viewNumberList(List<Integer> numberGroup) {
        System.out.println(numberGroup);
    }

    private void getLotteryNumsMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private void getBonusNumMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    private void viewRate(double rate) {
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
