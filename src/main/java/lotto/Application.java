package lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.userpick.UserPick;
import lotto.domain.purchase.Purchase;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Purchase purchase = new Purchase();
        int quantity = purchase.makePurchase();
        UserPick userPick = new UserPick();

        List<Lotto> lottoTicketList = Lotto.gatherLottoTickets(quantity);

        List<Object> pickedNumbers = userPick.pickNumbers();

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + "n" + "개");
        System.out.println("4개 일치 (50,000원) - " + "n" + "개");
        System.out.println("5개 일치 (1,500,000원) - " + "n" + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + "n" + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + "n" + "개");
        System.out.println("총 수익률은 " + "n" + "%입니다.");
    }
}
