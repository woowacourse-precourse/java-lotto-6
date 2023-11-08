package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoTotalPrize;
import lotto.model.constants.LottoWinningRank;
import lotto.exception.CustomIllegalArgumentException;
import lotto.exception.ExceptionMessage;
import lotto.view.message.ViewMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TextProcessor {
    private final static String SPLIT = ",";
    private final static String DELIMITER = ", ";

    public List<Integer> splitWinningNumbers(String inputWinningNumbers) {
        String[] winningNumbers = inputWinningNumbers.split(SPLIT);
        validateParseInputsWithEmptyCheck(winningNumbers);

        try {
            return parseWinningLottoNumbers(winningNumbers);
        } catch (NumberFormatException e) {
            throw new CustomIllegalArgumentException(ExceptionMessage.INVALID_INTEGER_FORMAT);
        }
    }

    public int parsePurchaseAmount(String inputAmount) {
        validateEmptyCheck(inputAmount, ExceptionMessage.EMPTY_PURCHASE_AMOUNT);

        return parseInput(inputAmount);
    }

    public int parseBonusNumber(String inputBonusNumber) {
        validateEmptyCheck(inputBonusNumber, ExceptionMessage.EMPTY_BONUS_NUMBER);

        return parseInput(inputBonusNumber);
    }

    private void validateEmptyCheck(String input, ExceptionMessage emptyMessage) {
        if (input.isEmpty()) {
            throw new CustomIllegalArgumentException(emptyMessage);
        }
    }

    private int parseInput(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new CustomIllegalArgumentException(ExceptionMessage.INVALID_INTEGER_FORMAT);
        }
    }

    public String generateLottoNumbersText(Lotto lotto) {
        StringBuilder builder = new StringBuilder();
        List<Integer> numbers = lotto.getNumbers();

        builder.append("[")
                .append(numbers.get(0));
        for (int i = 1; i < numbers.size(); i++) {
            builder.append(DELIMITER)
                    .append(numbers.get(i));
        }
        builder.append("]");

        return builder.toString();
    }

    public String generateLottoResult(LottoTotalPrize lottoResult) {
        StringBuilder builder = new StringBuilder();
        Map<LottoWinningRank, Integer> prizeResult = Collections.unmodifiableMap(lottoResult.getPrizeCounts());

        builder.append(ViewMessage.WINNING_STATISTICS_FIFTH
                .getMessage(prizeResult.get(LottoWinningRank.FIFTH)));
        builder.append(ViewMessage.WINNING_STATISTICS_FOURTH.
                getMessage(prizeResult.get(LottoWinningRank.FOURTH)));
        builder.append(ViewMessage.WINNING_STATISTICS_THIRD
                .getMessage(prizeResult.get(LottoWinningRank.THIRD)));
        builder.append(ViewMessage.WINNING_STATISTICS_SECOND
                .getMessage(prizeResult.get(LottoWinningRank.SECOND)));
        builder.append(ViewMessage.WINNING_STATISTICS_FIRST
                .getMessage(prizeResult.get(LottoWinningRank.FIRST)));

        return builder.toString();
    }

    private void validateParseInputsWithEmptyCheck(String[] winningNumbers) {
        if (Arrays.stream(winningNumbers)
                .anyMatch(String::isEmpty)) {
            throw new CustomIllegalArgumentException(ExceptionMessage.EMPTY_WINNING_NUMBER);
        }
    }

    private List<Integer> parseWinningLottoNumbers(String[] winningNumbers) {
        return Arrays.stream(winningNumbers)
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }
}
