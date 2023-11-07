package lotto.view;


public class OutputView {

    private enum OutputPhrase {
        BUY_HOWMUCH("%d개를 구매했습니다.\n");
        private final String message;

        OutputPhrase(String message) {
            this.message = message;
        }

    }


    public void printTicketNumber(int ticketNumber) {
        System.out.printf(OutputPhrase.BUY_HOWMUCH.message, ticketNumber);
    }

    public void printWinningNumber() {
        //비교 이후 구현
    }
}