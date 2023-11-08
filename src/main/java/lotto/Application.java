package lotto;

import lotto.generator.ClientLottoNumber;
import lotto.service.CalculateProfitRate;
import lotto.service.CalculateTotalProfit;
import lotto.service.CalculateWinCounts;
import lotto.service.PrintWinCounts;
import lotto.view.PrintProfitRate;
import lotto.view.PrintView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run() {
        ClientLottoNumber clientLottoNumber = new ClientLottoNumber();
        clientLottoNumber.NumberGenerator();

        PrintView printView = new PrintView();
        printView.outView();

        List<Integer> lottoWinNumber = PrintView.lottoWinNumber;
        int bonusNumber = PrintView.bonusNumber;

        List<Integer> winCounts = CalculateWinCounts.calculateWinCounts(clientLottoNumber.LottoNumberList, lottoWinNumber, bonusNumber);
        PrintWinCounts.printWinCounts(winCounts);

        int totalProfit = CalculateTotalProfit.calculateTotalProfit(winCounts, clientLottoNumber.t);
        float profitRate = CalculateProfitRate.calculateProfitRate(totalProfit, clientLottoNumber.t);
        PrintProfitRate.printProfitRate(profitRate);
    }



}
