package lotto.controller;

import static lotto.service.Buyer.calculateLottoTickets;
import static lotto.view.IO.checkLottoTickets;
import static lotto.view.IO.requestPerchaseAmount;
import static lotto.view.constants.Front.CHECK_LOTTO_TICKETS;
import static lotto.view.constants.Front.REQUEST_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchaseAmount;
import lotto.service.Buyer;

public class LottoGame {
    public static void lottoGameStart(){
        requestPerchaseAmount(REQUEST_PURCHASE_AMOUNT);
        PurchaseAmount purchaseAmount = inputPurchaseAmount();
        Buyer buyer = Buyer.getInstance();
        int lottoTicketCount = buyer.calculateLottoTickets(purchaseAmount);
        checkLottoTickets(lottoTicketCount,CHECK_LOTTO_TICKETS);
        buyer.buyLottoTickets(lottoTicketCount);
    }

    private static PurchaseAmount inputPurchaseAmount(){
        while(true){
            String money = Console.readLine();
            try{
                PurchaseAmount purchaseAmount = new PurchaseAmount(money);
                return purchaseAmount;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
