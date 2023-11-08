package lotto.view;

import static common.enumtype.ResultType.NOT_WIN;
import static common.enumtype.ResultType.SECOND_PLACE;

import common.enumtype.ResultType;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.dto.LottoNumbers;

public final class OutputView {

    private static final String LOTTO_NUMBERS_STRING_PREFIX = "[";
    private static final String SEPARATE = ", ";
    private static final String LOTTO_NUMBER_STRING_SUFFIX = "]\n";
    public static final String RESULT_FORMAT = "%d개 일치 (%s원) - %d개";
    public static final String SECOND_PLACE_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    public static final int DEFAULT_COUNT = 0;

    private OutputView() {
    }

    public static void printLottoNumbers(List<LottoNumbers> lottoNumbers) {
        StringBuilder sb = new StringBuilder();
        sb.append('\n').append(lottoNumbers.size()).append("개를 구매했습니다.\n");
        lottoNumbers
                .forEach(numbers -> makeLottoNumbersString(numbers, sb));
        System.out.println(sb);
    }

    public static void printWinningStatistics() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    public static void printLottoResult(Map<ResultType, Integer> lottoResult) {
        String collect = makeLottoResultString(lottoResult);
        System.out.println(collect);
    }

    public static void printTotalYieldRate(double yieldRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yieldRate);
    }

    private static void makeLottoNumbersString(LottoNumbers lottoNumbers, StringBuilder sb) {
        sb.append(LOTTO_NUMBERS_STRING_PREFIX);
        lottoNumbers.numbers().stream()
                .sorted()
                .forEach(number -> sb.append(number).append(SEPARATE));
        sb.delete(sb.length() - SEPARATE.length(), sb.length());
        sb.append(LOTTO_NUMBER_STRING_SUFFIX);
    }

    private static String makeLottoResultString(Map<ResultType, Integer> lottoResult) {
        return Arrays.stream(ResultType.values())
                .filter(value -> value != NOT_WIN)
                .map(value -> makeResultTypeString(value, lottoResult))
                .collect(Collectors.joining("\n"));
    }

    private static String makeResultTypeString(
            ResultType resultType,
            Map<ResultType, Integer> lottoResult
    ) {
        String format = getResultFormat(resultType);
        return String.format(format,
                resultType.getMatchCount(),
                convertNumberFormat(resultType),
                getResultCount(resultType, lottoResult)
        );
    }

    private static boolean isNotWin(ResultType resultType) {
        return resultType == NOT_WIN;
    }

    private static String getResultFormat(ResultType resultType) {
        if (isSecondPlace(resultType)) {
            return SECOND_PLACE_FORMAT;
        }
        return RESULT_FORMAT;
    }

    private static boolean isSecondPlace(ResultType resultType) {
        return resultType == SECOND_PLACE;
    }

    private static String convertNumberFormat(ResultType resultType) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        return numberFormat.format(resultType.getReward());
    }

    private static Integer getResultCount(ResultType resultType,
            Map<ResultType, Integer> lottoResult) {
        return lottoResult.getOrDefault(resultType, DEFAULT_COUNT);
    }
}
