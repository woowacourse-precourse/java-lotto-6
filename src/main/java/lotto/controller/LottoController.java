package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;
import lotto.service.PurchaseService;
import lotto.util.UIVaildator;
import lotto.view.OutputView;
import lotto.view.inputView;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.service.PurchaseService;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    UIVaildator uiVaildator = new UIVaildator();
    PurchaseService purchaseService = new PurchaseService();
    Buyer buyer;
    public void run() {
        //로또 구매
        buyLotto();

        //로또 추첨
//        drawLotto();
            // 당첨번호 입력
            //보너스 번호 입력
        //추첨 결과

            //추첨 결과 안내
            //수익률 안내
    }
    public void buyLotto() {
        while (true) {
            try {
                String inputMoney = inputView.getRequestMoney();
                uiVaildator.vaildateInput(inputMoney);
                buyer = new Buyer(inputMoney);
                purchaseService.purchaseLotto(buyer);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        OutputView.displayPurchaseHistory(buyer.getTicketQuantity(), buyer.getLottos());
    }
//        //구매 금액 입력
//        buyer.setPurchaseAmount(Integer.parseInt(money));
//        //수량으로 변환
//        buyer.setTicketQuantity(moneyToTicket.getTicket(buyer.getPurchaseAmount()));
////        int lottoTicket = moneyToTicket.getTicket(moneyForBuyLotto);
//        //수량만큼 로또 발행
//        tickets = lottoNumberGenerate.getTickets(buyer.getTicketQuantity());
//
//        OutputView.displayPurchaseHistory(buyer.getTicketQuantity(),tickets);
    public void drawLotto() {
        // 유효성 검사
//        UIVaildator.numberVaildate(number, bonusNumber);

//        lottoWinning.setNumbers(intArrNumbers);

        // 당첨 번호 출력
//        System.out.println(Arrays.toString(winnnigNumbers));

        // 보너스 번호 입력
//        int bonusNumbers = Integer.parseInt(inputView.getRequestBonusNumber());
        // 유효성 검사

        // 당첨 번호 출력
//        System.out.println(bonusNumbers);
    }
}
