package lotto;

import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.model.Result;
import lotto.model.Ticket;
import lotto.model.WinningNum;
import lotto.view.Output;

public class Application {
    public static void main(String[] args) {
        Output.inputAmountMsg();
        int amount = InputController.setAmount();
        Output.printNumOfLotto(amount);

        Ticket ticket = new Ticket(LottoController.generateTicket(amount));
        Output.printTicket(ticket.getLottos());
        Output.inputWinningNumMsg();
        WinningNum winningiNum = new WinningNum(InputController.setWinningNum());
        Output.inputBonusNumMsg();
        int bonusNum = InputController.setBonusNum();
        Result result = new Result(LottoController.determine(ticket.getLottos(), winningiNum.getNumbers(), bonusNum));
        double rateOfReturn = LottoController.calculateReturn(result.getResult(), amount);
        Output.printResult(LottoController.countResult(result.getResult()),rateOfReturn);

        // TODO: 프로그램 구현
    }
}

