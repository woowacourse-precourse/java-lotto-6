package lotto.view;

import static lotto.constants.MessageConstants.EXTRA_MESSAGE_FOR_BONUS_NUMBER;
import static lotto.constants.MessageConstants.LOTTO_NUMBER_SEPARATOR;
import static lotto.constants.MessageConstants.OUTPUT_MESSAGE_FOR_BUY_AMOUNT;
import static lotto.constants.MessageConstants.OUTPUT_MESSAGE_FOR_EARNING_RATIO;
import static lotto.constants.MessageConstants.OUTPUT_MESSAGE_FOR_LINE_SEPARATOR;
import static lotto.constants.MessageConstants.OUTPUT_MESSAGE_FOR_LOTTO_FORMAT;
import static lotto.constants.MessageConstants.OUTPUT_MESSAGE_FOR_RESULT;
import static lotto.constants.MessageConstants.OUTPUT_MESSAGE_FOR_RESULT_INIT;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.dto.GameResultDto;
import lotto.domain.dto.OrderResultDto;

public class OutputView {


    public void printOrderResult(OrderResultDto orderResultDto) {
        printBuyAmount(orderResultDto.quantity());
        for (Lotto lotto : orderResultDto.items()) {
            printLottoInAscendingOrder(lotto);
        }
    }

    private void printBuyAmount(int quantity) {
        System.out.printf(OUTPUT_MESSAGE_FOR_BUY_AMOUNT.getMessage() + "%n", quantity);
    }

    private void printLottoInAscendingOrder(Lotto lotto) {
        List<String> sortedNumbers = lotto.getNumbers().stream().sorted()
                .map(lottoNumber -> String.valueOf(lottoNumber.getNumber()))
                .toList();
        System.out.printf(OUTPUT_MESSAGE_FOR_LOTTO_FORMAT.getMessage() + "%n",
                String.join(LOTTO_NUMBER_SEPARATOR.getMessage(), sortedNumbers));
    }

    public void printGameResult(GameResultDto gameResultDto) {
        System.out.println(OUTPUT_MESSAGE_FOR_RESULT_INIT);
        System.out.println(OUTPUT_MESSAGE_FOR_LINE_SEPARATOR);
        printPrizesResult(gameResultDto);
        printWinningPercentage(gameResultDto.winningPercentage());
    }

    private void printPrizesResult(GameResultDto gameResultDto) {
        Map<Prize, Integer> prizeIntegerMap = gameResultDto.prizeCounter();
        prizeIntegerMap.keySet().stream()
                .sorted(Collections.reverseOrder())
                .forEach(key -> printPrizeResult(key,
                        prizeIntegerMap.get(key)));
    }

    private void printPrizeResult(Prize key, int count) {
        System.out.printf(OUTPUT_MESSAGE_FOR_RESULT + "%n", key.getNumberOfMatches(),
                getBonusNumberMessage(key.isBonusIncluded()),
                key.getPrizeMoney(), count);
    }

    private String getBonusNumberMessage(boolean bonusIncluded) {
        if (bonusIncluded) {
            return EXTRA_MESSAGE_FOR_BONUS_NUMBER.getMessage();
        }
        return "";
    }

    private void printWinningPercentage(float percentage) {
        System.out.printf(OUTPUT_MESSAGE_FOR_EARNING_RATIO + "%n", percentage);
    }

}
