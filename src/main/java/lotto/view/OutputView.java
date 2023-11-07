package lotto.view;

public class OutputView {
  public static final String TICKET_NUMBER = "개를 구매했습니다.";

  public static void printTicketNumber(int ticket){
    System.out.println(ticket + TICKET_NUMBER);
  }
}
