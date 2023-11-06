package lotto.domain;

import java.util.List;
import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.model.Result;
import lotto.model.Ticket;
import lotto.model.WinningNum;
import lotto.view.Output;

public class LottoGame {
    public static void start() {
        try {
            Output.inputPaymentMsg();
            int payment = InputController.setPayment();
            Output.printNumOfLotto(payment);
            Ticket ticket = new Ticket(LottoController.generateTicket(payment));
            Output.printTicket(ticket);
            Output.inputWinningNumMsg();
            WinningNum winningiNum = new WinningNum(InputController.setWinningNum());
            Output.inputBonusNumMsg();
            int bonusNum = InputController.setBonusNum();
            List<Result> result = LottoController.determine(ticket, winningiNum, bonusNum);
            double rateOfReturn = LottoController.calculateReturn(result, payment);
            Output.printResult(result, rateOfReturn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
