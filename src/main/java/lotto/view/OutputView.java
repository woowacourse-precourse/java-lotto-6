package lotto.view;

import lotto.config.LottoMessage;
import lotto.dto.response.LottoResultsDto;

public class OutputView {

    public OutputView() {
    }

    public void printEnterPurchaseAmount() {
        printMessage(LottoMessage.ENTER_PURCHASE_AMOUNT.getMessage());
    }

    // TODO : 원시 타입 포장
    public void printTicketPurchasedCount(int count) {
        printMessage(LottoMessage.TICKET_PURCHASED_COUNT.getFormattedMessage(count));
    }

    public void printEnterWinningNumbers() {
        printMessage(LottoMessage.ENTER_WINNING_NUMBERS.getMessage());
    }

    public void printEnterBonusNumber() {
        printMessage(LottoMessage.ENTER_BONUS_NUMBER.getMessage());
    }

    public void printMatchResult(LottoResultsDto lottoResultsDTO) {
        printMessage(lottoResultsDTO.formatResults());
    }

    // TODO : 원시 타입 포장
    public void printTotalProfitRate(float profitRate) {
        printMessage(LottoMessage.TOTAL_PROFIT_RATE.getFormattedMessage(profitRate));
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    public static OutputView getInstance() {
        return OutputView.LazyHolder.INSTANCE;
    }


    private static class LazyHolder {
        private static final OutputView INSTANCE = new OutputView();
    }

}

/**
 * 구입금액을 입력해 주세요.
 * 8000
 *
 * 8개를 구매했습니다.
 * [8, 21, 23, 41, 42, 43]
 * [3, 5, 11, 16, 32, 38]
 * [7, 11, 16, 35, 36, 44]
 * [1, 8, 11, 31, 41, 42]
 * [13, 14, 16, 38, 42, 45]
 * [7, 11, 30, 40, 42, 43]
 * [2, 13, 22, 32, 38, 45]
 * [1, 3, 5, 14, 22, 45]
 *
 * 당첨 번호를 입력해 주세요.
 * 1,2,3,4,5,6
 *
 * 보너스 번호를 입력해 주세요.
 * 7
 *
 * 당첨 통계
 * ---
 * 3개 일치 (5,000원) - 1개
 * 4개 일치 (50,000원) - 0개
 * 5개 일치 (1,500,000원) - 0개
 * 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
 * 6개 일치 (2,000,000,000원) - 0개
 * 총 수익률은 62.5%입니다.
 */