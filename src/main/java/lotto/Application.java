package lotto;


import lotto.entity.PrizePrint;
import lotto.entity.WinCount;
import lotto.entity.WinMessage;
import lotto.io.BonusNumberReader;
import lotto.generator.ClientLottoNumber;
import lotto.io.LottoNumberReader;
import lotto.service.NumCountInList;
import lotto.view.PrintView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        ClientLottoNumber clientLottoNumber = new ClientLottoNumber();
        clientLottoNumber.NumberGenerator();

        PrintView printView = new PrintView();
        printView.outView();

        List<Integer> lottoWinNumber = PrintView.lottoWinNumber;
        int bonusNumber = PrintView.bonusNumber;

        List<Integer> winCounts = new ArrayList<>();
        for (int i = 0; i < clientLottoNumber.LottoNumberList.size(); i++) {
            List<Integer> compare_list = clientLottoNumber.LottoNumberList.get(i);
            int winCount = WinCount.calculateWinCount(compare_list, lottoWinNumber, bonusNumber);
            winCounts.add(winCount);
        }
        for (int i = 0; i < winCounts.size(); i++) {
            int winCount = winCounts.get(i);
        }
        int totalProfit = 0;
        int o = 3;
        for (WinMessage.WinType winType : WinMessage.WinType.values()) {
            int count = NumCountInList.countOccurrences(winCounts, o);
            int prize = PrizePrint.CalculatorPrize.calculatePrize(o);
            totalProfit += prize * count;
            o++;
            System.out.println(winType.getLabel() + " - " + count + "개");
        }
        int p = clientLottoNumber.t * 1000;

        float a = (float) totalProfit / p * 10;
        System.out.println("총 수익률은 " + String.format("%.1f", a) + "%입니다.");
    }
}
