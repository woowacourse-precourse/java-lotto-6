package lotto.view;

import lotto.domain.dto.LottoDto;
import lotto.domain.dto.LottoTicketDto;
import lotto.domain.dto.WinningResultDto;
import lotto.domain.Ranking;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    private static final String RESULT_START_MESSAGE =
            System.lineSeparator() + "당첨 통계" + System.lineSeparator() + "---------";
    public static final String RESULT_RANK_MESSAGE = "%d개 일치%s(%s원) - %d개" + System.lineSeparator();
    private static final String HAS_BONUS_MESSAGE = ", 보너스 볼 일치 ";

    public static void printErrorMessage(final String message) {
        System.out.println(message);
    }

    public static void printPurchaseLottoResult(final LottoTicketDto lottoTicketDto) {
        List<LottoDto> lottos = lottoTicketDto.getLottos();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (LottoDto lottoDto : lottos) {
            printLottoNumbers(lottoDto);
        }
    }
    public static void printLottoNumbers(LottoDto lottoDto){
        System.out.println(lottoDto.getLottoNumbers());
    }

    public static void printWinningResult(final WinningResultDto winningResultDto) {
        printHeader();
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        for (Ranking ranking : Ranking.rankingWithoutDefault()) {
            System.out.printf(RESULT_RANK_MESSAGE, ranking.getCorrectCount(), printIfSecond(ranking),
                    decimalFormat.format(ranking.getPrize()), winningResultDto.getWinningCount(ranking));
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", winningResultDto.getRateOfReturnPercent());
    }

    private static String printIfSecond(Ranking ranking) {
        if (ranking == Ranking.SECOND) {
            return HAS_BONUS_MESSAGE;
        }
        return " ";
    }

    private static void printHeader() {
        System.out.println(RESULT_START_MESSAGE);
    }
}
