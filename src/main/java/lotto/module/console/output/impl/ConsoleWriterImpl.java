package lotto.module.console.output.impl;

import lotto.module.console.output.ConsoleWriter;

/**
 * 콘솔에 문자열을 출력하는 클래스
 */
public class ConsoleWriterImpl implements ConsoleWriter {
    private static final String INPUT_PAYMENT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    private ConsoleWriterImpl() {
    }

    public static ConsoleWriterImpl newInstance() {
        return new ConsoleWriterImpl();
    }

    @Override
    public void printInputPaymentMessage() {
        System.out.println(INPUT_PAYMENT_MESSAGE);
    }

    @Override
    public void printPurchasedLottoTickets(final String purchasedLottoTicketsMessage) {
        System.out.println(purchasedLottoTicketsMessage);
    }

    @Override
    public void printInputWinningLottoNumbersMessage() {
        System.out.println(INPUT_WINNING_LOTTO_NUMBERS_MESSAGE);
    }

    @Override
    public void printInputLottoBonusNumbersMessage() {
        System.out.println(INPUT_LOTTO_BONUS_NUMBER_MESSAGE);
    }

    @Override
    public void printLottoWinningResult(final String lottoResultMessage) {
        System.out.println(lottoResultMessage);
    }

    @Override
    public void printErrorMessage(final String errorMessage) {
        System.out.println(errorMessage);
    }

}
