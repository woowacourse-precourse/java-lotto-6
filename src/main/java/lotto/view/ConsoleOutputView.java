package lotto.view;

import static lotto.view.LottoGameMessage.COUNT_OF_PURCHASED_LOTTO;
import static lotto.view.LottoGameMessage.REQUEST_BONUS_LOTTO_NUMBER;
import static lotto.view.LottoGameMessage.REQUEST_PURCHASE_AMOUNT;
import static lotto.view.LottoGameMessage.REQUEST_WINNING_LOTTO_NUMBERS;
import static lotto.view.LottoGameMessage.WINNING_STATISTICS;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import lotto.dto.LottoNumbersResult;
import lotto.dto.LottoRankResultDTO;
import lotto.model.LottoRankResult;
import lotto.model.LottoRank;

public class ConsoleOutputView {
    public void requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT.getMessage());
    }

    public void printCountOfLotto(int count) {
        printBlankLine();
        System.out.printf(COUNT_OF_PURCHASED_LOTTO.getMessage(), count);
        printBlankLine();
    }

    public void printLottoNumbers(LottoNumbersResult lottoNumbers) {
        System.out.println(lottoNumbers.getFormattedLottoNumbers());
    }

    public void requestWinningLottoNumbers() {
        printBlankLine();
        System.out.println(REQUEST_WINNING_LOTTO_NUMBERS.getMessage());
    }

    public void requestBonusLottoNumber() {
        printBlankLine();
        System.out.println(REQUEST_BONUS_LOTTO_NUMBER.getMessage());
    }

    public void printWinningStatistics() {
        printBlankLine();
        System.out.println(WINNING_STATISTICS.getMessage());
    }

    public void printWinningNumberCount(LottoRankResultDTO result) {
        System.out.printf(result.getRankMessage(), result.getCount());
        printBlankLine();
    }

    private void printBlankLine() {
        System.out.println();
    }
}
