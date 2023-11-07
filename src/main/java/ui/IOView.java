package ui;

import dto.WinningNumberDTO;
import java.util.List;
import lotto.LottoTickets;

public class IOView {
    private IOView() {
    }

    public static int getMoney() {
        OutputView.printForInputMoney();
        return InputView.getMoney();
    }

    public static void printLottoNumbers(LottoTickets lottoTickets) {
        OutputView.printAmount(lottoTickets.size());
        List<String> lottoNumbers = lottoTickets.sayLottoNumbers();
        OutputView.printLottoNumbers(lottoNumbers);


    }

    public static WinningNumberDTO getWinningNumbers() {
        OutputView.printForInputCommonNumber();
        List<Integer> commonNumbers = InputView.getCommonNumbers();

        OutputView.printForInputBonusNumber();
        int bonusNumber = InputView.getBonusNumber(commonNumbers);

        return new WinningNumberDTO(commonNumbers, bonusNumber);
    }
}
