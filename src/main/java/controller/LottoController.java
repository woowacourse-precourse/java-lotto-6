package controller;

import static controller.InputController.getBonusNumberInput;
import static controller.InputController.getMoneyInput;
import static controller.InputController.getWinningNumbersInput;
import static model.LottoGenerate.calculateLottoRate;
import static model.LottoGenerate.generateLottoResult;
import static model.LottoGenerate.generateLottoTickets;
import static model.LottoGenerate.lottoTicketsCount;
import static view.View.lottoRateMessagePrint;
import static view.View.lottoResultMessagePrint;
import static view.View.lottoTicketsCountPrint;
import static view.View.lottoTicketsPrint;

import java.util.List;
import model.Lotto;

public class LottoController {
    public static List<Lotto> buyLotto() {
        int lottoTicketsCount = lottoTicketsCount(getMoneyInput());
        lottoTicketsCountPrint(lottoTicketsCount);
        List<Lotto> lottoTickets = generateLottoTickets(lottoTicketsCount);
        lottoTicketsPrint(lottoTickets);
        return lottoTickets;
    }

    public static void lottoMachine(List<Lotto> lottoTickets) {
        List<Integer> lottoWinningNumbers = getWinningNumbersInput();
        int lottoBonusNumber = getBonusNumberInput(lottoWinningNumbers);
        List<Integer> lottoResult = generateLottoResult(lottoTickets, lottoWinningNumbers, lottoBonusNumber);
        System.out.println(lottoResult);
        lottoResultMessagePrint(lottoResult);
        double rate = calculateLottoRate(lottoTickets.size(), lottoResult);
        lottoRateMessagePrint(rate);
    }
}
