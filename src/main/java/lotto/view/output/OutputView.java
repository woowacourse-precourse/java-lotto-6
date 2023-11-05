package lotto.view.output;

import lotto.dto.LottoDto;
import lotto.model.LottoResult;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printPurchaseLottos(List<LottoDto> lottoDto) {
        System.out.println(lottoDto.size() + "개를 구매했습니다.");
        lottoDto.stream()
                .forEach(OutputView::printLottoDto);
    }

    private static void printLottoDto(LottoDto lottoDto) {
        List<Integer> lottoDtoNumbers = lottoDto.getNumbers();

        String result = lottoDtoNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result);
    }

    public static void printTotalEarningsRate(double totalEarningsRate) {
        String formattedEarningsRate = String.format("%,.1f%%", totalEarningsRate);
        System.out.println("총 수익률은 " + formattedEarningsRate + "입니다.");
    }

    public static void printLottoResult(List<LottoResult> results) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Arrays.stream(LottoResult.values())
                .forEach(r -> printLottoResultLine(results, r));
    }

    private static void printLottoResultLine(List<LottoResult> results, LottoResult lottoResult) {
        Long count = results.stream()
                .filter(r -> r == lottoResult)
                .count();

        if (lottoResult == LottoResult.FIVE_MATCH_WITH_BONUS) {
            printFiveMatchWithBonus(count, lottoResult);
            return;
        }

        printMatch(count, lottoResult);
    }

    private static void printFiveMatchWithBonus(Long count, LottoResult lottoResult) {
        System.out.println(lottoResult.getMatchingNumbers()
                + "개 일치, 보너스 볼 일치 ("
                + lottoResult.getPrizeAmount()
                + "원) - "
                + count
                + "개"
        );
    }

    private static void printMatch(Long count, LottoResult lottoResult) {
        System.out.println(lottoResult.getMatchingNumbers()
                + "개 일치 ("
                + lottoResult.getPrizeAmount()
                + "원) - "
                + count
                + "개"
        );
    }
}
