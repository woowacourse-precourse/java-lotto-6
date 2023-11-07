package ui;

import dto.LottoMoney;
import java.text.MessageFormat;

class OutputView {
    private OutputView() {
    }

    public static void printForBuy() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static void printAmount(LottoMoney lottoMoney) {
        String formatted = MessageFormat.format("{0}개를 구매했습니다.", lottoMoney.getAmount());
        System.out.println(formatted);
    }

    public static void printLottos(Object lottos) {
        System.out.println();
    }

    public static void printWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
