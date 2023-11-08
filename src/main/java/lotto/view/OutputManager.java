package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.enums.LottoPrize;
import lotto.enums.OutputMessages;

public class OutputManager {
    public void printLottoProfit(User user) {
        System.out.println(OutputMessages.RESULT_MESSAGE.getMessage());
        for (LottoPrize lottoPrize : user.getLottoResult().keySet()) {
            if (lottoPrize.equals(LottoPrize.NOT_THING_MATCH)) {
                continue;
            }
            System.out.println(getEachPriceCountMessage(lottoPrize, user.getLottoResult()));
        }
        System.out.println(getTotalProfitMessage(user.getProfitability()));
    }

    public void printUserLottos(User user) {
        System.out.println(String.format(OutputMessages.PRINT_LOTTO_COUNT_MESSAGE.getMessage(),user.getLottoTicketCount()));
        user.getLottos().forEach(lotto -> {
            System.out.println(convertLottoNumbersToString(lotto.getNumbers()));
        });
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    private String convertLottoNumbersToString(List<Integer> numbers) {
        String result = numbers.stream().map(String::valueOf)
                .collect(Collectors.joining(OutputMessages.DIVISION_MARK.getMessage()));
        return "[" + result + "]";
    }

    private String getEachPriceCountMessage(LottoPrize lottoPrize, Map<LottoPrize, Integer> lottoResult) {
        return String.format(lottoPrize.getMessage(), lottoResult.get(lottoPrize));
    }

    private String getTotalProfitMessage(Double profit) {
        return String.format(OutputMessages.TOTAL_PROFIT_MESSAGE.getMessage(), profit);
    }
}
