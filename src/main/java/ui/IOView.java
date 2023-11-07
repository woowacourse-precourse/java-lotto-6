package ui;

import dto.LottoMoney;
import java.util.List;
import lotto.LottoTickets;

public class IOView {
    private IOView() {
    }

    public static LottoMoney getMoney() {
        OutputView.printForBuy();
        LottoMoney lottoMoney = InputView.getMoney();
        OutputView.printAmount(lottoMoney);
        return lottoMoney;
    }

    public static void printLottoNumbers(LottoTickets lottoTickets) {
        List<String> lottoNumberLines = lottoTickets.sayLottoNumbers();
        for (String line : lottoNumberLines) {
            System.out.println(line);
        }
    }
}
