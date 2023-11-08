package lotto.Controller;

import lotto.generator.CalculateProfitRate;
import lotto.generator.CalculateTotalProfit;
import lotto.generator.CalculateWinCounts;
import lotto.generator.ClientLottoNumber;
import lotto.view.PrintProfitRate;
import lotto.view.PrintView;
import lotto.view.PrintWinCounts;

import java.util.List;

public class LottoStart {
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
