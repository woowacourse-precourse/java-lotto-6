package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.enums.LottoStatus;
import lotto.service.LottoDto;
import lotto.service.LottoResultDto;

public class OutputView {

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void displayLottos(List<LottoDto> lottoDtos) {
        printEmptyLine();
        StringBuilder lottoStringBuilder = new StringBuilder();

        lottoStringBuilder.append(lottoDtos.size()).append("개를 구매했습니다.").append("\n");
        for (LottoDto lottoDto : lottoDtos) {
            lottoStringBuilder.append(lottoDto.numbers()).append("\n");
        }

        System.out.println(lottoStringBuilder);
    }

    public static void displayResult(LottoResultDto lottoResultDto) {
        Map<LottoStatus, Integer> lottoStatusCounts = lottoResultDto.lottoStatusCounts();
        printEmptyLine();
        StringBuilder lottoResultStringBuilder = new StringBuilder();
        lottoResultStringBuilder.append("당첨 통계").append("\n");
        lottoResultStringBuilder.append("---").append("\n");

        for (LottoStatus status : LottoStatus.values()) {
            if (status != LottoStatus.SIXTH) {
                lottoResultStringBuilder.append(status.getStatusMessage()).append(" - ")
                        .append(lottoStatusCounts.get(status))
                        .append("개")
                        .append("\n");
            }
        }

        System.out.print(lottoResultStringBuilder);
    }

    public static void printEmptyLine() {
        System.out.println();
    }


    public static void displayProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }

}
