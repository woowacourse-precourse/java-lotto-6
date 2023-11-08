package lotto.view.output;

import lotto.domain.prize.constants.PrizeGrade;
import lotto.dto.FinalResultResponse;
import lotto.view.constants.PrintablePrizeGrade;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Optional;

import static lotto.view.constants.PrintFormat.SEPARATOR_FORMAT;
import static lotto.view.constants.PrintMessage.*;

public final class FinalResultWriter extends OutputWriter {
    private FinalResultWriter() {
    }

    public static void responseTotalYield(final FinalResultResponse response) {
        String formattedYieldMessage = String.format(
                RESPONSE_YIELD.getMessage(), response.getFormattedYield());
        println(formattedYieldMessage);
    }

    public static void responseMatchingResult(FinalResultResponse response) {
        printNewLine();
        printMessage(RESPONSE_PRIZE_STATISTICS);
        printMessage(RESPONSE_SEPARATOR);

        EnumMap<PrizeGrade, Integer> prizeGradeIntegerEnumMap = response.finalResults().getFinalResults();
        PrintablePrizeGrade[] printablePrizeTypes = PrintablePrizeGrade.values();

        Arrays.stream(printablePrizeTypes)
                .forEach(type -> printEachMatchingResult(type, prizeGradeIntegerEnumMap));
    }


    private static void printEachMatchingResult(
            PrintablePrizeGrade type,
            EnumMap<PrizeGrade, Integer> prizeGradeIntegerEnumMap
    ) {
        DecimalFormat seperatedFormat = SEPARATOR_FORMAT.getFormat();

        PrizeGrade grade = type.getGrade();
        int typeMatchingCount = grade.getPrizeMatchingCount();

        String decimalTypeFormattedPrizeAmount = seperatedFormat.format(grade.getPrizeAmount());
        Integer wrappedMappingCount = prizeGradeIntegerEnumMap.get(type.getGrade());
        int defaultMatchingCount = getDefaultMatchingCount(wrappedMappingCount);

        String eachResultMessage = String.format(
                type.getFormat(),
                typeMatchingCount,
                decimalTypeFormattedPrizeAmount,
                defaultMatchingCount
        );

        System.out.println(eachResultMessage);
    }

    private static int getDefaultMatchingCount(Integer matchingCount) {
        return Optional.ofNullable(matchingCount)
                .orElse(0);
    }
}
