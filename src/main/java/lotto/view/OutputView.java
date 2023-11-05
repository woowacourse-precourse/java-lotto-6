package lotto.view;


import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Rank;
import lotto.domain.dto.DrawingResultDto;
import lotto.domain.dto.LottoDto;
import lotto.domain.dto.LottosDto;
import lotto.domain.dto.PurchaseAmountDto;

public class OutputView {
    public static final String LOTTO_PURCHASE_RESULT_MESSAGE = "%d개를 구매했습니다.\n";
    public static final String WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---";
    public static final String DRAW_RESULT_EXCLUDING_SECOND_MESSAGE = "%d개 일치, (%d원) - %d개\n";
    public static final String DRAWING_RESULT_FOR_SECOND_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원) - %d개\n";

    public void printPurchaseQuantityLottos(final PurchaseAmountDto purchaseAmountDto) {
        System.out.printf("\n" + LOTTO_PURCHASE_RESULT_MESSAGE, purchaseAmountDto.purchaseQuantityLottos());
    }

    public void printIssuedPurchaseResult(final LottosDto lottosDto) {
        List<LottoDto> lottos = lottosDto.lottos();

        for (LottoDto lotto : lottos) {
            String convertedLotto = convertFrom(lotto);
            System.out.println(convertedLotto);
        }
    }

    private String convertFrom(final LottoDto lottoDto) {
        return String.join(", ", String.valueOf(lottoDto.numbers()));
    }

    public void printDrawingResult(final DrawingResultDto drawingResultDto) {
        Map<Rank, Integer> results = drawingResultDto.drawingResults();

        System.out.println(WINNING_STATISTICS_MESSAGE);

        for (Entry<Rank, Integer> rankIntegerEntry : results.entrySet()) {
            if (rankIntegerEntry.getKey() == Rank.NONE) {
                continue;
            }

            if (rankIntegerEntry.getKey() == Rank.SECOND) {
                printSecondRankResult(rankIntegerEntry);
                continue;
            }

            printNonSecondRankResults(rankIntegerEntry);
        }
    }

    private void printNonSecondRankResults(Entry<Rank, Integer> rankIntegerEntry) {
        System.out.printf(DRAW_RESULT_EXCLUDING_SECOND_MESSAGE, rankIntegerEntry.getKey().getMatchNumberCount(),
                rankIntegerEntry.getKey().getWinningAmount(), rankIntegerEntry.getValue());
    }

    private void printSecondRankResult(Entry<Rank, Integer> rankIntegerEntry) {
        System.out.printf(DRAWING_RESULT_FOR_SECOND_MESSAGE, rankIntegerEntry.getKey().getMatchNumberCount(),
                rankIntegerEntry.getKey().getWinningAmount(), rankIntegerEntry.getValue());
    }
}
