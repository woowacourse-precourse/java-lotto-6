package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.constant.ExceptionMessage.ERROR_NOT_IN_SPLIT_WORD;
import static lotto.constant.ExceptionMessage.ERROR_NOT_NUMBER;
import static lotto.constant.GuideMessage.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoResult;

public class LottoView {

    int inputNumber(String message) {

        printMessage(message);
        String input = readLine();

        return getStringToInt(input);
    }

    void printMessage(String message) {
        System.out.println(message);
    }

    List<Integer> inputNumbers(String message) {

        printMessage(message);
        String input = readLine();

        return convertStringToList(input);
    }

    void printLottoResult(Map<LottoResult, Integer> results, double rateOfReturn) {

        printMessage("당첨 통계");
        printMessage("---");
        printMessage(LOTTO_NUMBER_THREE_NUMBER_MATCH + convertLottoCountToString(results.get(LottoResult.FIFTH_PLACE)));
        printMessage(LOTTO_NUMBER_FOUR_NUMBER_MATCH + convertLottoCountToString(results.get(LottoResult.FOURTH_PLACE)));
        printMessage(LOTTO_NUMBER_FIVE_NUMBER_MATCH + convertLottoCountToString(results.get(LottoResult.THIRD_PLACE)));
        printMessage(LOTTO_NUMBER_FIVE_NUMBER_MATCH_AND_BONUS + convertLottoCountToString(results.get(LottoResult.SECOND_PLACE)));
        printMessage(LOTTO_NUMBER_ALL_NUMBER_MATCH + convertLottoCountToString(results.get(LottoResult.FIRST_PLACE)));
        printRateOfReturn(rateOfReturn);
    }

    private String convertLottoCountToString(int count) {
        return count + "개";
    }

    private void printRateOfReturn(double rateOfReturn) {
        DecimalFormat decFormat = new DecimalFormat("###,###.0");
        System.out.println("총 수익률은 " + decFormat.format(rateOfReturn) + "%입니다.");
    }

    private List<Integer> convertStringToList(String input) {

        validateStringInSplitWord(input);

        String[] splitInput = input.split(",");

        List<Integer> numbers = new ArrayList<>();

        for (String word : splitInput) {
            numbers.add(getStringToInt(word));
        }

        return numbers;
    }

    private int getStringToInt(String input) {

        int number;

        try {
            number = Integer.parseInt(input);

        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException(ERROR_NOT_NUMBER);
        }

        return number;
    }

    private void validateStringInSplitWord(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(ERROR_NOT_IN_SPLIT_WORD);
        }
    }

}
