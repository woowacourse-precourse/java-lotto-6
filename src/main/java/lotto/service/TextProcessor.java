package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoTotalPrize;
import lotto.model.constants.LottoWinningRank;
import lotto.exception.CustomIllegalArgumentException;
import lotto.exception.ExceptionMessage;
import lotto.view.message.ViewMessage;

import java.util.Arrays;
import java.util.List;

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
        validateEmptyCheck(inputAmount.trim(), ExceptionMessage.EMPTY_PURCHASE_AMOUNT);

        return parseInput(inputAmount);
    }

    public int parseBonusNumber(String inputBonusNumber) {
        validateEmptyCheck(inputBonusNumber.trim(), ExceptionMessage.EMPTY_BONUS_NUMBER);

        return parseInput(inputBonusNumber);
    }

    private void validateEmptyCheck(String input, ExceptionMessage emptyMessage) {
        if (input == null || input.isEmpty()) {
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

        builder.append("[").append(numbers.get(0));
        for (int i = 1; i < numbers.size(); i++) {
            builder.append(DELIMITER).append(numbers.get(i));
        }
        builder.append("]");

        return builder.toString();
    }

    public String generateLottoResult(LottoTotalPrize lottoResult) {
        return ViewMessage.WINNING_STATISTICS_FIFTH
                .getMessage(getPrizeCount(lottoResult, LottoWinningRank.FIFTH)) +
                ViewMessage.WINNING_STATISTICS_FOURTH
                        .getMessage(getPrizeCount(lottoResult, LottoWinningRank.FOURTH)) +
                ViewMessage.WINNING_STATISTICS_THIRD
                        .getMessage(getPrizeCount(lottoResult, LottoWinningRank.THIRD)) +
                ViewMessage.WINNING_STATISTICS_SECOND
                        .getMessage(getPrizeCount(lottoResult, LottoWinningRank.SECOND)) +
                ViewMessage.WINNING_STATISTICS_FIRST
                        .getMessage(getPrizeCount(lottoResult, LottoWinningRank.FIRST));
    }

    private Integer getPrizeCount(LottoTotalPrize lottoResult, LottoWinningRank lottoWinningRank) {
        return lottoResult.getPrizeCounts().get(lottoWinningRank);
    }

    private void validateParseInputsWithEmptyCheck(String[] winningNumbers) {
        if (Arrays.stream(winningNumbers)
                .anyMatch(string -> string.trim().isEmpty())) {
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
