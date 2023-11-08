package lotto;

import lotto.generator.ClientLottoNumber;
import lotto.generator.CalculateProfitRate;
import lotto.generator.CalculateTotalProfit;
import lotto.generator.CalculateWinCounts;
import lotto.view.PrintWinCounts;
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
