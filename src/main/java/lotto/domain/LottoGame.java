package lotto.domain;

import java.util.List;
import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.model.Result;
import lotto.model.Ticket;
import lotto.model.WinningNum;
import lotto.view.Output;

public class LottoGame {
    public static void play() {
        try {
            int payment = purchase();
            Ticket ticket = issuanceTicket(payment);
            WinningNum winningiNum = writeWinningNum();
            int bonusNum = writeBonusNum();
            List<Result> result = LottoController.determine(ticket, winningiNum, bonusNum);
            double rateOfReturn = LottoController.calculateReturn(result, payment);
            Output.printResult(result, rateOfReturn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static int purchase() {
        Output.inputPaymentMsg();
        int payment = InputController.setPayment();
        Output.printNumOfLotto(payment);
        return payment;
    }

    private static Ticket issuanceTicket(int payment) {
        Ticket ticket = new Ticket(LottoController.generateTicket(payment));
        Output.printTicket(ticket);
        return ticket;
    }

    private static WinningNum writeWinningNum() {
        Output.inputWinningNumMsg();
        return new WinningNum(InputController.setWinningNum());
    }

    private static int writeBonusNum() {
        Output.inputBonusNumMsg();
        return InputController.setBonusNum();
    }
}
