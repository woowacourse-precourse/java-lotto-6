package lotto.view;

import static lotto.common.ErrorMessages.BONUS_DUPLICATE_MESSAGE;
import static lotto.common.InputOutputMessages.INPUT_BONUS_NUMBER;
import static lotto.common.InputOutputMessages.INPUT_MONEY;
import static lotto.common.InputOutputMessages.INPUT_WINNING_NUMBER;
import static lotto.common.InputOutputMessages.OUTPUT_DASHES;
import static lotto.common.InputOutputMessages.OUTPUT_PURCHASED_LOTTO_COUNT_FORMAT;
import static lotto.common.InputOutputMessages.OUTPUT_RANK_RESULT_FORMAT;
import static lotto.common.InputOutputMessages.OUTPUT_STATISTICS_HEADER;
import static lotto.common.InputOutputMessages.OUTPUT_TOTAL_PROFIT_RATE_FORMAT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import lotto.common.InputOutputMessages;
import lotto.common.LottoRank;
import lotto.dto.request.LottoNumberRequest;
import lotto.dto.request.LottoPurchaseCostRequest;
import lotto.dto.request.LottoRequest;
import lotto.dto.response.LottoBuyResponse;
import lotto.dto.response.LottoGameResultResponse;
import lotto.dto.response.LottoResponse;
import lotto.exception.InputValidationException;

public class InputOutputView {
    public static final int COUNT_DEFAULT_VALUE = 0;

    public LottoPurchaseCostRequest inputMoney() {
        return getUserInput(INPUT_MONEY, LottoPurchaseCostRequest::new);
    }

    public LottoRequest inputWinningNumbers() {
        return getUserInput(INPUT_WINNING_NUMBER, LottoRequest::new);
    }

    public LottoNumberRequest inputBonusNumber(LottoRequest winningNumbers) {
        return getUserInput(INPUT_BONUS_NUMBER, input -> {
            LottoNumberRequest request = new LottoNumberRequest(input);

            if (isBonusNumberIncluded(winningNumbers, request)) {
                throw new InputValidationException(BONUS_DUPLICATE_MESSAGE);
            }

            return request;
        });
    }

    private boolean isBonusNumberIncluded(LottoRequest winningNumbers, LottoNumberRequest request) {
        return winningNumbers.contains(request.getLottoNumber());
    }

    public <T> T getUserInput(InputOutputMessages inputMessage, Function<String, T> parser) {
        System.out.println(inputMessage.getMessage());
        while (true) {
            try {
                String input = Console.readLine();
                return parser.apply(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    public void printBuyLottos(LottoBuyResponse lottoBuyResponse) {
        System.out.printf(OUTPUT_PURCHASED_LOTTO_COUNT_FORMAT.getMessage(), lottoBuyResponse.getCount());
        lottoBuyResponse.getBuyLottoNumbers()
                .stream()
                .map(LottoResponse::getLotto)
                .forEach(System.out::println);
    }

    public void printResult(LottoGameResultResponse response) {
        Map<LottoRank, Integer> gameResults = response.getGameResultCounts();

        System.out.println(OUTPUT_STATISTICS_HEADER.getMessage());
        System.out.println(OUTPUT_DASHES.getMessage());
        Arrays.stream(LottoRank.getSortedValues())
                .filter(rank -> rank != LottoRank.NO_RANK)
                .forEach(rank -> System.out.printf(OUTPUT_RANK_RESULT_FORMAT.getMessage(), rank.getDescription(),
                        gameResults.getOrDefault(rank, COUNT_DEFAULT_VALUE)));
        System.out.printf(OUTPUT_TOTAL_PROFIT_RATE_FORMAT.getMessage(), response.getProfitRate());
    }
}
