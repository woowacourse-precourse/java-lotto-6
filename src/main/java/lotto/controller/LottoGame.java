package lotto.controller;

import static lotto.service.Buyer.calculateLottoTickets;
import static lotto.service.Buyer.getInstance;
import static lotto.view.IO.checkLottoTickets;
import static lotto.view.IO.requestBonusNumber;
import static lotto.view.IO.requestPerchaseAmount;
import static lotto.view.IO.requestWinningNumbers;
import static lotto.view.IO.showResults;
import static lotto.view.constants.Front.CHECK_LOTTO_TICKETS;
import static lotto.view.constants.Front.REQUEST_BONUS_NUMBER;
import static lotto.view.constants.Front.REQUEST_PURCHASE_AMOUNT;
import static lotto.view.constants.Front.REQUEST_WINNING_NUMBERS;
import static lotto.view.constants.Front.SHOW_THE_WINNING_STATISTICS;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.service.Buyer;
import lotto.service.Checker;

public class LottoGame {
    public static void lottoGameStart(){
        requestPerchaseAmount(REQUEST_PURCHASE_AMOUNT);
        PurchaseAmount purchaseAmount = inputPurchaseAmount();
        Buyer buyer = Buyer.getInstance();
        int lottoTicketCount = buyer.calculateLottoTickets(purchaseAmount);
        checkLottoTickets(lottoTicketCount,CHECK_LOTTO_TICKETS);
        buyer.buyLottoTickets(lottoTicketCount);
        requestWinningNumbers(REQUEST_WINNING_NUMBERS);
        WinningNumbers winningNumbers = inputWinningNumbers();
        requestBonusNumber(REQUEST_BONUS_NUMBER);
        BonusNumber bonusNumber = inputBonusNumber(winningNumbers);
        Checker checker = new Checker(bonusNumber, winningNumbers, buyer.getLottoTickets());
        checker.checkLottoTickets();
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

    private static WinningNumbers inputWinningNumbers(){
        while(true){
            String numbers = Console.readLine();
            try{
                WinningNumbers winningNumbers = new WinningNumbers(numbers);
                return winningNumbers;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static BonusNumber inputBonusNumber(WinningNumbers winningNumbers){
        while(true){
            String number = Console.readLine();
            try{
                BonusNumber bonusNumber = new BonusNumber(number, winningNumbers);
                return bonusNumber;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
