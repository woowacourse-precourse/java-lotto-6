package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.service.DrawingService;
import lotto.service.PurchaseService;
import lotto.util.UIVaildator;
import lotto.view.OutputView;
import lotto.view.inputView;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.service.PurchaseService;
import lotto.util.TypeConverter;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    UIVaildator uiVaildator = new UIVaildator();
    PurchaseService purchaseService = new PurchaseService();
    DrawingService drawingService = new DrawingService();
    Buyer buyer;
    WinningLotto winningLotto;
    public void run() {
        //로또 구매
        buyLotto();

        //로또 추첨
        drawLotto();
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
                uiVaildator.vaildateInt(inputMoney);
                buyer = new Buyer(TypeConverter.strToInt(inputMoney));
                purchaseService.purchaseLotto(buyer);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        OutputView.displayPurchaseHistory(buyer.getTicketQuantity(), buyer.getLottos());
    }
    public void drawLotto() {
        while (true) {
            try {
                String inputNumber = inputView.getRequestWinningNumber();
                String inputBunusNumber = inputView.getRequestBonusNumber();
                uiVaildator.vaildateInt(inputNumber, inputBunusNumber);
                winningLotto = new WinningLotto(TypeConverter.strToIntList(inputNumber),
                                                TypeConverter.strToInt(inputBunusNumber));

            } catch (IllegalArgumentException e) {

            }
        }
    }
}
