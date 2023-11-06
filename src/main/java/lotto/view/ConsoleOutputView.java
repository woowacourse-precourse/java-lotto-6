package lotto.view;

import static lotto.view.LottoGameMessage.COUNT_OF_PURCHASED_LOTTO;
import static lotto.view.LottoGameMessage.REQUEST_BONUS_LOTTO_NUMBER;
import static lotto.view.LottoGameMessage.REQUEST_PURCHASE_AMOUNT;
import static lotto.view.LottoGameMessage.REQUEST_WINNING_LOTTO_NUMBERS;
import static lotto.view.LottoGameMessage.WINNING_STATISTICS;

import lotto.dto.LottoNumbersDTO;
import lotto.dto.LottoRankResultDTO;

public class ConsoleOutputView {
    public void requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT.getMessage());
    }

    public void printCountOfLotto(int count) {
        printBlankLine();
        System.out.printf(COUNT_OF_PURCHASED_LOTTO.getMessage(), count);
        printBlankLine();
    }

    public void printLottoNumbers(LottoNumbersDTO lottoNumbersDTO) {
        System.out.println(lottoNumbersDTO.getFormattedLottoNumbers());
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

    public void printWinningNumberCount(LottoRankResultDTO lottoRankResultDTO) {
        System.out.printf(lottoRankResultDTO.getRankMessage(), lottoRankResultDTO.getCount());
        printBlankLine();
    }

    private void printBlankLine() {
        System.out.println();
    }
}
