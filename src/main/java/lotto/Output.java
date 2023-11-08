package lotto;

import java.util.List;

public class Output {
    public void outputPurchaseAmount() {
        System.out.println("구입금액을 입력 주세요.");
    }

    public void outputTicketPurchaseHistory(int ticket, List<List<Integer>> allTicketNumbers) {
        System.out.println(ticket + "개를 구했습니다.");
        for (int i = 0; i < ticket; i++) {
            System.out.println(allTicketNumbers.get(i));
        }
    }
}
