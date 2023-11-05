package lotto.view.output;

import lotto.dto.LottoDto;
import lotto.model.LottoResult;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputFormatter {
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String LEFT_SQUARE_BRACKET = "[";
    private static final String RIGHT_SQUARE_BRACKET = "]";
    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";
    private static final String COMMA = ",";

    private OutputFormatter() {
    }

    public static String makePurchaseLottos(List<LottoDto> lottoDto) {
        String result = lottoDto.stream()
                .map(OutputFormatter::makeLottoDtoFormat)
                .collect(Collectors.joining(NEW_LINE));
        return lottoDto.size() + PURCHASE_MESSAGE + NEW_LINE + result;
    }

    private static String makeLottoDtoFormat(LottoDto lottoDto) {
        List<Integer> lottoDtoNumbers = lottoDto.getNumbers();

        String result = lottoDtoNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(COMMA + SPACE, LEFT_SQUARE_BRACKET, RIGHT_SQUARE_BRACKET));
        return result;
    }

    public static String makeTotalEarningsRate(double totalEarningsRate) {
        String formattedEarningsRate = String.format("%,.1f%%", totalEarningsRate);
        return "총 수익률은 " + formattedEarningsRate + "입니다.";
    }

    public static String makeLottoResult(List<LottoResult> results) {
        String result = "당첨 통계" + NEW_LINE + "---";

        String resultLines = Arrays.stream(LottoResult.values())
                .map(r -> makeLottoResultLine(results, r))
                .collect(Collectors.joining(NEW_LINE));

        return result + NEW_LINE + resultLines;
    }

    private static String makeLottoResultLine(List<LottoResult> results, LottoResult lottoResult) {
        Long count = results.stream()
                .filter(r -> r == lottoResult)
                .count();

        if (lottoResult == LottoResult.FIVE_MATCH_WITH_BONUS) {
            return makeFiveMatchWithBonus(count, lottoResult);
        }

        return makeMatch(count, lottoResult);
    }

    private static String makeFiveMatchWithBonus(Long count, LottoResult lottoResult) {
        return lottoResult.getMatchingNumbers()
                + "개 일치, 보너스 볼 일치 ("
                + lottoResult.getPrizeAmount()
                + "원) - "
                + count
                + "개";
    }

    private static String makeMatch(Long count, LottoResult lottoResult) {
        return lottoResult.getMatchingNumbers()
                + "개 일치 ("
                + lottoResult.getPrizeAmount()
                + "원) - "
                + count
                + "개";
    }

}
