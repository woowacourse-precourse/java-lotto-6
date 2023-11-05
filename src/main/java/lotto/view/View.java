package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoTicket;

public class View {
    public View() {
    }

    public void inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public String input() {
        return Console.readLine();
    }

    public void displayPurchaseQuantityMessage(LottoTicket lottoTicket) {
        System.out.println();
        System.out.println(lottoTicket.getLottoTicketCount()+"개를 구매했습니다.");
    }
}
