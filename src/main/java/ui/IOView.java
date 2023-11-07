package ui;

import dto.BonusNumberDTO;
import dto.CommonNumberDTO;
import dto.LottoMoneyDTO;
import dto.WinningNumberDTO;
import java.util.List;
import lotto.LottoTickets;

public class IOView {
    private IOView() {
    }

    public static LottoMoneyDTO getMoney() {
        OutputView.printForInputMoney();
        LottoMoneyDTO lottoMoney = InputView.getMoney();
        OutputView.printAmount(lottoMoney);
        return lottoMoney;
    }

    public static void printLottoNumbers(LottoTickets lottoTickets) {
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
