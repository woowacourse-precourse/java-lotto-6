package lotto.controller;

import static lotto.view.View.checkLottoTickets;
import static lotto.view.View.requestBonusNumber;
import static lotto.view.View.requestPerchaseAmount;
import static lotto.view.View.requestWinningNumbers;
import static lotto.view.constants.ViewConstants.CHECK_LOTTO_TICKETS;
import static lotto.view.constants.ViewConstants.REQUEST_BONUS_NUMBER;
import static lotto.view.constants.ViewConstants.REQUEST_PURCHASE_AMOUNT;
import static lotto.view.constants.ViewConstants.REQUEST_WINNING_NUMBERS;

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
        checker.calculateToTalProfit(purchaseAmount);
        Console.close();
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
