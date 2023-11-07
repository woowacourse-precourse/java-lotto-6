package controller;

import static view.OutputLottoResultView.printLottoResult;

import domain.IncomeRate;
import domain.LottoResult;
import domain.LottoTicket;
import domain.Money;
import domain.WinningLotto;
import domain.generator.LottoGenerator;
import java.util.List;
import view.InputBonusNumberView;
import view.InputMoneyView;
import view.InputWinningLottoView;
import view.OutputLottoResultView;
import view.OutputLottoTicketView;

public class LottoController {
    public void run() {
        InputMoneyView inputMoneyView = new InputMoneyView();
        Money money = inputMoneyView.getValue();

        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoTicket lottoTicket = new LottoTicket(lottoGenerator.generateLottoTicket(money.buyLottoTicket()));

        OutputLottoTicketView.printLottoTicket(lottoTicket);

        InputWinningLottoView inputWinningLottoView = new InputWinningLottoView();
        InputBonusNumberView inputBonusNumberView = new InputBonusNumberView();

        List<Integer> winningNumbers = inputWinningLottoView.getValue();
        int bonusNumber = inputBonusNumberView.getValue();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        LottoResult lottoResult = new LottoResult();
        lottoResult.calcLottoResult(lottoTicket, winningLotto);

        IncomeRate incomeRate = new IncomeRate(money, lottoResult);

        printLottoResult(lottoResult, incomeRate);
    }
}
