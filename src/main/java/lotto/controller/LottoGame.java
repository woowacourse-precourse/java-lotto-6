package lotto.controller;

import static lotto.service.Buyer.buyLottoTickets;
import static lotto.service.Validator.validateDividedBy1000Won;
import static lotto.service.Validator.validateLess1000Won;
import static lotto.service.Validator.validateNumber;
import static lotto.view.IO.checkLottoTickets;
import static lotto.view.IO.requestPerchaseAmount;
import static lotto.view.constants.Front.CHECK_LOTTO_TICKETS;
import static lotto.view.constants.Front.REQUEST_PERCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchaseAmount;
import lotto.view.IO;
import lotto.view.constants.Front;

public class LottoGame {
    public static void lottoGameStart(){
        requestPerchaseAmount(REQUEST_PERCHASE_AMOUNT);
        PurchaseAmount purchaseAmount = inputPurchaseAmount();
        int lottoTicketCount = buyLottoTickets(purchaseAmount);
        checkLottoTickets(lottoTicketCount,CHECK_LOTTO_TICKETS);
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
