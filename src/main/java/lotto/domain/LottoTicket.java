package lotto.domain;

public class LottoTicket {
    private static final int TICKET_PRICE = 1000;
    int ticketNumber;

    public LottoTicket(String input) {
        validateIsNumber(input);
        validateIsDivided(input);
        ticketNumber = Integer.parseInt(input) / TICKET_PRICE;
    }

    public int getTicketNumber () {
        return ticketNumber;
    }

    private void validateIsNumber(String input) {
        if (input.matches("\\d*")) {
            return;
        }
        throw new IllegalArgumentException("숫자를 입력하세요.");
    }

    private void validateIsDivided(String input) {
        int paid = Integer.parseInt(input);
        if (paid % TICKET_PRICE == 0) {
            return;
        }
        throw new IllegalArgumentException(String.format("잔돈이 남습니다. %d 원 단위로 입력해주세요. ", TICKET_PRICE));
    }
}
