package ui;

import dto.BonusNumberDTO;
import dto.CommonNumberDTO;
import dto.MoneyDTO;
import dto.WinningNumberDTO;
import java.util.List;
import lotto.LottoTickets;

public class IOView {
    private IOView() {
    }

    public static MoneyDTO getMoney() {
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
        CommonNumberDTO commonNumbers = InputView.getCommonNumbers();

        OutputView.printForInputBonusNumber();
        BonusNumberDTO bonusNumber = InputView.getBonusNumbers(commonNumbers);

        return new WinningNumberDTO(commonNumbers, bonusNumber);
    }
}
