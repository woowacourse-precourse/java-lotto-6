package lotto.view;

import java.util.List;
import lotto.enums.LottoStatus;
import lotto.model.LottoResult;
import lotto.service.LottoDto;

public class OutputView {
    public static final String WINNING_STATISTICS = "당첨 통계";

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void displayLottos(List<LottoDto> lottoDtos) {
        printEmptyLine();
        System.out.println(lottoDtos.size() + "개를 구매했습니다.");
        for (int i = 0; i < lottoDtos.size(); i++) {
            System.out.println(lottoDtos.get(i).numbers());
        }
        printEmptyLine();
    }

    public static void displayResult(LottoResult lottoResult) {
        printEmptyLine();
        System.out.println(WINNING_STATISTICS);
        System.out.println("---");
        System.out.println(
                LottoStatus.FIFTH.getStatusMessage() + " - " + lottoResult.statusCount(LottoStatus.FIFTH) + "개");
        System.out.println(
                LottoStatus.FOURTH.getStatusMessage() + " - " + lottoResult.statusCount(LottoStatus.FOURTH) + "개");
        System.out.println(
                LottoStatus.THIRD.getStatusMessage() + " - " + lottoResult.statusCount(LottoStatus.THIRD) + "개");
        System.out.println(
                LottoStatus.SECOND.getStatusMessage() + " - " + lottoResult.statusCount(LottoStatus.SECOND) + "개");
        System.out.println(
                LottoStatus.FIRST.getStatusMessage() + " - " + lottoResult.statusCount(LottoStatus.FIRST) + "개");
        System.out.println("총 수익률은 " + lottoResult.caculateProfitRate() + "%입니다.");
    }

    public static void printEmptyLine() {
        System.out.println();
    }


}
