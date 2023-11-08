package controller;

import static controller.InputController.getBonusNumberInput;
import static controller.InputController.getMoneyInput;
import static controller.InputController.getWinningNumbersInput;
import static model.LottoGenerate.generateLottoTickets;
import static model.LottoGenerate.lottoTicketsCount;
import static view.View.lottoTicketsCountPrint;
import static view.View.lottoTicketsPrint;

import java.util.List;
import model.Lotto;

public class LottoController {
    public static void buyLotto() {
        int lottoTicketsCount = lottoTicketsCount(getMoneyInput());
        lottoTicketsCountPrint(lottoTicketsCount);
        List<Lotto> lottoTickets = generateLottoTickets(lottoTicketsCount);
        lottoTicketsPrint(lottoTickets);
    }

    public static void lottoMachine() {
        List<Integer> lottoWinningNumbers = getWinningNumbersInput();
        int lottoBonusNumber = getBonusNumberInput(lottoWinningNumbers);
    }
}
