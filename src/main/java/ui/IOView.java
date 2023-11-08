package ui;

import java.util.List;
import lotto.LottoMoney;
import lotto.LottoPrizeBag;
import lotto.LottoTickets;
import lotto.LottoWinningNumber;
import lotto.LottoWinningNumber.Builder;

public class IOView {
    private IOView() {
    }

    public static LottoMoney getMoney() {
        OutputView.printForInputMoney();
        return InputView.getMoney();
    }

    public static void printLottoNumbers(LottoTickets lottoTickets) {
        OutputView.printAmount(lottoTickets.size());
        List<String> lottoNumbers = lottoTickets.sayLottoNumbers();
        OutputView.printLottoNumbers(lottoNumbers);


    }

    public static LottoWinningNumber getWinningNumbers() {
        Builder builder = LottoWinningNumber.builder();

        OutputView.printForInputCommonNumber();
        InputView.getCommonNumbers(builder);

        OutputView.printForInputBonusNumber();
        InputView.getBonusNumber(builder);

        return builder.build();
    }

    public static void printPrizes(LottoPrizeBag prizeBag) {
        OutputView.printStatics(prizeBag);
        OutputView.printRateOfReturn(prizeBag);

    }
}
