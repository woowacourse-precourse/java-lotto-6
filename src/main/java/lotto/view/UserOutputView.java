package lotto.view;

import lotto.controller.LottoController;

public class UserOutputView {

    public static  void outputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요");
    }

    public static void getBuyLottoTickets(){
        System.out.println(LottoController.getBuyLottoTicketsNum() + "개를 구입했습니다.");
    }

}
