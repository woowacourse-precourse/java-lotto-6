package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.enums.LottoPrize;
import lotto.domain.LottoResult;

public class OutputView {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s\n";
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public void println() {
        System.out.println();
    }

    public void printError(String errorMessage) {
        System.out.printf(ERROR_MESSAGE_FORMAT, errorMessage);
    }

    public void printMoneyInputMessage() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }

    public void printTicket(long ticket) {
        System.out.printf("%d개를 구매했습니다.\n", ticket);
    }

    public void printLottoList(List<Lotto> wallet) {
        wallet.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printWinningLottoInputMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberInputMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printPrizeCount(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", lottoResult.getCount(LottoPrize.FIFTH_PLACE));
        System.out.printf("4개 일치 (50,000원) - %d개\n", lottoResult.getCount(LottoPrize.FORTH_PLACE));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", lottoResult.getCount(LottoPrize.THIRD_PLACE));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", lottoResult.getCount(LottoPrize.SECOND_PLACE));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", lottoResult.getCount(LottoPrize.FIRST_PLACE));
    }

    public void printMoneyRate(double rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rate);
    }
}
