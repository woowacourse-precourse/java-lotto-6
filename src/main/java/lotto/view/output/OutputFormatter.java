package lotto.view.output;

import lotto.dto.LottoDto;
import lotto.model.LottoResult;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class OutputFormatter {
    private static final String PURCHASE_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    private static final String LOTTO_STATISTICS_MESSAGE = "당첨 통계\n---\n";
    private static final String FIVE_MATCH_WITH_BONUS_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String MATCH_MESSAGE_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String TOTAL_EARNINGS_MESSAGE = "총 수익률은 %s입니다.";
    private static final String EARNINGS_RATE_FORMAT = "%,.1f%%";
    private static final String LEFT_SQUARE_BRACKET = "[";
    private static final String RIGHT_SQUARE_BRACKET = "]";
    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";
    private static final String COMMA = ",";

    private OutputFormatter() {
    }

    public static String makePurchaseLottos(List<LottoDto> lottoDto) {
        String purchasedLottosCount =  String.format(PURCHASE_MESSAGE_FORMAT, lottoDto.size());

        String purchasedLottos = lottoDto.stream()
                .map(OutputFormatter::makeLottoDtoFormat)
                .collect(Collectors.joining(NEW_LINE));

        return purchasedLottosCount + NEW_LINE + purchasedLottos;
    }

    private static String makeLottoDtoFormat(LottoDto lottoDto) {
        List<Integer> lottoDtoNumbers = lottoDto.getNumbers();

        String result = lottoDtoNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(COMMA + SPACE, LEFT_SQUARE_BRACKET, RIGHT_SQUARE_BRACKET));
        return result;
    }

    public static String makeLottoResult(List<LottoResult> LottoResults) {
        String resultLines = Arrays.stream(LottoResult.values())
                .map(LottoResult -> makeLottoResultLine(LottoResults, LottoResult))
                .collect(Collectors.joining(NEW_LINE));

        return LOTTO_STATISTICS_MESSAGE + resultLines;
    }

    private static String makeLottoResultLine(List<LottoResult> LottoResults, LottoResult lottoResult) {
        Long count = LottoResults.stream()
                .filter(result -> result == lottoResult)
                .count();

        if (lottoResult == LottoResult.FIVE_MATCH_WITH_BONUS) {
            return makeFiveMatchWithBonus(count, lottoResult);
        }

        return makeMatch(count, lottoResult);
    }

    private static String makeFiveMatchWithBonus(Long count, LottoResult lottoResult) {
        return String.format(FIVE_MATCH_WITH_BONUS_MESSAGE_FORMAT,
                lottoResult.getMatchingNumbers(),
                lottoResult.getPrizeAmount(),
                count);
    }

    private static String makeMatch(Long count, LottoResult lottoResult) {
        return String.format(MATCH_MESSAGE_FORMAT,
                lottoResult.getMatchingNumbers(),
                lottoResult.getPrizeAmount(),
                count);
    }

    public static String makeTotalEarningsRate(double totalEarningsRate) {
        String formattedEarningsRate = String.format(EARNINGS_RATE_FORMAT, totalEarningsRate);
        return String.format(TOTAL_EARNINGS_MESSAGE, formattedEarningsRate);
    }

}
