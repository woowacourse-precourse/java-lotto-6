package lotto.exception;

public class NotPositiveLottoTicketsSizeException extends NotPositiveValueException {
    public NotPositiveLottoTicketsSizeException() {
        super("로또 구매 개수");
    }
}
