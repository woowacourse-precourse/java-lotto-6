package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {
  public static final String TICKET_NUMBER = "개를 구매했습니다.";

  public static void printTicketNumber(int ticket){
    System.out.println(ticket + TICKET_NUMBER);
  }

  public void printLottoList(int ticket, List<Lotto> lottos){
    for(Lotto lotto : lottos){
      System.out.print(lotto);
    }
  }
}
