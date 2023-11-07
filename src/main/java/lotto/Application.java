package lotto;


import lotto.entity.PrizePrint;
import lotto.entity.WinCount;
import lotto.entity.WinMessage;
import lotto.io.BonusNumberReader;
import lotto.generator.ClientLottoNumber;
import lotto.io.LottoNumberReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        ClientLottoNumber clientLottoNumber = new ClientLottoNumber();
        clientLottoNumber.NumberGenerator();

        System.out.println();
        System.out.println("당첨번호를 입력해 주세요.");
        LottoNumberReader lottoNumberReader = new LottoNumberReader();
        List<Integer> lotto_win_number = lottoNumberReader.lotto_reader();//로또번호 출력

        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        BonusNumberReader bonusNumber = new BonusNumberReader();
        int bonusnumber = bonusNumber.bonusnumber();

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        List<Integer> winCounts = new ArrayList<>();
        for (int i = 0; i < clientLottoNumber.LottoNumberList.size(); i++) {
            List<Integer> compare_list = clientLottoNumber.LottoNumberList.get(i);
            int winCount = WinCount.calculateWinCount(compare_list, lotto_win_number, bonusnumber);
            winCounts.add(winCount);
        }
        for (int i = 0; i < winCounts.size(); i++) {
            int winCount = winCounts.get(i);
        }
        int totalProfit = 0;
        int o = 3;
        for (WinMessage.WinType winType : WinMessage.WinType.values()) {
            int count = countOccurrences(winCounts, o);
            int prize = PrizePrint.CalculatorPrize.calculatePrize(o);
            totalProfit += prize * count;
            o++;
            System.out.println(winType.getLabel() + " - " + count + "개");
        }
        int p = clientLottoNumber.t * 1000;

        float a = (float) totalProfit / p * 10;
        System.out.println("총 수익률은 " + String.format("%.1f", a) + "%입니다.");
    }

    public static int countOccurrences(List<Integer> list, int target) {
        return Collections.frequency(list, target);
    }
}
