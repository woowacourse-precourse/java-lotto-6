package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.enums.LottoStatus;
import lotto.service.LottoDto;
import lotto.service.LottoResultDto;

public class OutputView {
    public static final String WINNING_STATISTICS = "당첨 통계";

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void displayLottos(List<LottoDto> lottoDtos) {
        printEmptyLine();
        System.out.println(lottoDtos.size() + "개를 구매했습니다.");
        for (LottoDto lottoDto : lottoDtos) {
            System.out.println(lottoDto.numbers());
        }
        printEmptyLine();
    }

    public static void displayResult(LottoResultDto lottoResultDto) {
        Map<LottoStatus, Integer> lottoStatusCounts = lottoResultDto.lottoStatusCounts();
        printEmptyLine();
        System.out.println(WINNING_STATISTICS);
        System.out.println("---");
        System.out.println(
                LottoStatus.FIFTH.getStatusMessage() + " - " + lottoStatusCounts.get(LottoStatus.FIFTH) + "개");
        System.out.println(
                LottoStatus.FOURTH.getStatusMessage() + " - " + lottoStatusCounts.get(LottoStatus.FOURTH) + "개");
        System.out.println(
                LottoStatus.THIRD.getStatusMessage() + " - " + lottoStatusCounts.get(LottoStatus.THIRD) + "개");
        System.out.println(
                LottoStatus.SECOND.getStatusMessage() + " - " + lottoStatusCounts.get(LottoStatus.SECOND) + "개");
        System.out.println(
                LottoStatus.FIRST.getStatusMessage() + " - " + lottoStatusCounts.get(LottoStatus.FIRST) + "개");
    }

    public static void printEmptyLine() {
        System.out.println();
    }


    public static void displayProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

}
