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
import view.OutputLottoTicketView;

public class LottoController {
    public void run() {
        InputMoneyView inputMoneyView = new InputMoneyView();
        Money money = getValidMoney(inputMoneyView);

        InputWinningLottoView inputWinningLottoView = new InputWinningLottoView();
        InputBonusNumberView inputBonusNumberView = new InputBonusNumberView();

        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoTicket lottoTicket = new LottoTicket(lottoGenerator.generateLottoTicket(money.getNumberOfLottoTicket()));

        OutputLottoTicketView.printLottoTicket(lottoTicket);

        List<Integer> winningNumbers = getValidWinningNumbers(inputWinningLottoView);
        int bonusNumber = getValidBonusNumber(inputBonusNumberView);

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        LottoResult lottoResult = new LottoResult();
        lottoResult.calcLottoResult(lottoTicket, winningLotto);

        IncomeRate incomeRate = new IncomeRate(money, lottoResult);

        printLottoResult(lottoResult, incomeRate);
    }

    private Money getValidMoney(InputMoneyView inputMoneyView) {
        while (true) {
            try {
                return new Money(inputMoneyView.getValue());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> getValidWinningNumbers(InputWinningLottoView inputWinningLottoView) {
        while (true) {
            try {
                return inputWinningLottoView.getValue();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getValidBonusNumber(InputBonusNumberView inputBonusNumberView) {
        while (true) {
            try {
                return inputBonusNumberView.getValue();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
