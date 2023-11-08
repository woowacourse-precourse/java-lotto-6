package lotto.module.console.output;

public interface ConsoleWriter {
    void printInputPaymentMessage();

    void printInputWinningLottoNumbersMessage();

    void printInputLottoBonusNumbersMessage();

    void printPurchasedLottoTickets(final String purchasedLottoTicketsMessage);

    void printLottoWinningResult(final String lottoResultMessage);

    void printErrorMessage(final String errorMessage);

}
