package lotto.controller;


import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.model.BundleGenerator;
import lotto.model.LottoBundle;
import lotto.model.LottoDTO;
import lotto.util.exception.parental.InputValidationException;
import lotto.util.exception.parental.MathOperationException;
import lotto.model.BonusNumber;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final boolean TRUE = true;
    private static final boolean FALSE = false;

    boolean validInput = FALSE;

    WinningNumbers winningNumbers;
    BonusNumber bonusNumber;
    BundleGenerator bundleGenerator;
    LottoBundle lottoBundle;
    PurchaseAmount amount;

    public void winningResult() {
        /*로또 구매 금액 입력, 검증, 로또 번호 생성*/
        purchaseLottoTickets();
        /*로또 번들 생성, 로또 번호 출력*/
        generateLottoBundle();
        /*당첨 번호 입력, 검증*/
        setWinningNumbers();
        /*보너스 번호 입력, 검증*/
        setBonusNumber();
        /* 당첨 통계 출력*/
        ProfitController profitController = new ProfitController(lottoBundle, amount);
        profitController.displayProfitReport(winningNumbers, bonusNumber);
    }

    private void purchaseLottoTickets() {
        validInput = FALSE;
        while (!validInput) {
            try {
                InputView.promptForPurchaseAmount();
                amount = new PurchaseAmount(Console.readLine());
                bundleGenerator = new BundleGenerator(amount);
                OutputView.displayPurchaseAmount(amount);
                validInput = TRUE;
            } catch (MathOperationException | AssertionError |NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void generateLottoBundle() {
        lottoBundle = new LottoBundle(bundleGenerator.generateLotto());
        List<LottoDTO> lottoDTO = lottoBundle.generateLottoTicketReport();
        for (LottoDTO dto : lottoDTO) {
            OutputView.displayLottoNumbers(dto);
        }
    }

    private void setWinningNumbers() {
        validInput = FALSE;
        while(!validInput) {
            try {
                InputView.promptForWinningNumbers();
                winningNumbers = new WinningNumbers(Console.readLine());
                validInput = TRUE;
            } catch (InputValidationException | AssertionError |NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void setBonusNumber() {
        validInput = FALSE;
        while(!validInput) {
            try {
                InputView.promptForBonusNumber();
                bonusNumber = new BonusNumber(Console.readLine(), winningNumbers);
                validInput = TRUE;
            } catch (InputValidationException | AssertionError |NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
