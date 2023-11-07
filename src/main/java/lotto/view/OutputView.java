package lotto.view;

public class OutputView {
    private static final String PURCHASE_TICKET_COUNT_MESSAGE = "개를 구매했습니다.";
    
    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
    
    public void printTicketCount(int ticketCount) {
        System.out.println(ticketCount + PURCHASE_TICKET_COUNT_MESSAGE);
    }
    
    public void printNewLine() {
        System.out.println();
    }
}
