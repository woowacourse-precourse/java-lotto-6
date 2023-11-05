package lotto.view;

import static lotto.common.ErrorMessages.BONUS_DUPLICATE_MESSAGE;
import static lotto.common.InputOutputMessages.INPUT_BONUS_NUMBER;
import static lotto.common.InputOutputMessages.INPUT_MONEY;
import static lotto.common.InputOutputMessages.INPUT_WINNING_NUMBER;
import static lotto.common.InputOutputMessages.OUTPUT_DASHES;
import static lotto.common.InputOutputMessages.OUTPUT_PURCHASED_LOTTO_COUNT_FORMAT;
import static lotto.common.InputOutputMessages.OUTPUT_STATISTICS_HEADER;
import static lotto.common.InputOutputMessages.OUTPUT_TOTAL_PROFIT_RATE_FORMAT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import lotto.common.InputOutputMessages;
import lotto.common.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.dto.LottoBuyResponse;
import lotto.dto.LottoGameResultResponse;
import lotto.exception.InputValidationException;

public class InputOutputView {

    public Money inputMoney() {
        return getUserInput(INPUT_MONEY, Money::new);
    }

    public Lotto inputWinningNumbers() {
        return getUserInput(INPUT_WINNING_NUMBER, Lotto::createLotto);
    }

    public int inputBonusNumber(Lotto winningNumbers) {
        return getUserInput(INPUT_BONUS_NUMBER, input -> {
            int bonusNumber = Integer.parseInt(input);

            if (winningNumbers.containsNumber(bonusNumber)) {
                throw new InputValidationException(BONUS_DUPLICATE_MESSAGE);
            }

            return bonusNumber;
        });
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
        lottoBuyResponse.getBuyLottoNumbers().stream()
                .forEach(System.out::println);
    }

    public void printResult(LottoGameResultResponse response) {
        Map<LottoRank, Integer> gameResults = response.getGameResultCounts();

        System.out.println(OUTPUT_STATISTICS_HEADER);
        System.out.println(OUTPUT_DASHES);
        Arrays.stream(LottoRank.getSortedValues())
                .filter(rank -> rank != LottoRank.NO_RANK)
                .forEach(rank -> {
                    System.out.printf("%s - %s개\n", rank.getDescription(), gameResults.getOrDefault(rank, 0));
                });
        System.out.printf(OUTPUT_TOTAL_PROFIT_RATE_FORMAT.getMessage(), response.getProfitRate());
    }
}
