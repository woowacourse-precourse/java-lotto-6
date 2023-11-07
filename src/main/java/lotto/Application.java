package lotto;

import lotto.entity.CalculatorPrize;
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
            int winCount = calculateWinCount(compare_list, lotto_win_number, bonusnumber);
            winCounts.add(winCount);
        }
        for (int i = 0; i < winCounts.size(); i++) {
            int winCount = winCounts.get(i);
        }
        int totalProfit = 0;
        int o = 3;
        for (WinMessage.WinType winType : WinMessage.WinType.values()) {
            int count = countOccurrences(winCounts, o);
            int prize = CalculatorPrize.calculatePrize(o);
            totalProfit += prize * count;
            o++;
            System.out.println(winType.getLabel() + " - " + count + "개");
        }
        int p = clientLottoNumber.t * 1000;

        float a = (float) totalProfit / p * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", a) + "%입니다.");
    }

    public static int countOccurrences(List<Integer> list, int target) {
        return Collections.frequency(list, target);
    }

    private static int calculateWinCount(List<Integer> userNumbers, List<Integer> winNumbers, int bonusNumber) {
        int count = 0;

        // 모든 번호가 일치하는 경우를 처리합니다.
        if (userNumbers.containsAll(winNumbers)) {
            return 7;
        }

        // 일치하는 번호 개수를 세기 위한 루프
        for (int number : userNumbers) {
            if (winNumbers.contains(number)) {
                count++;
                // 5개 번호가 일치하고 보너스 번호까지 일치하는 경우
                if (count == 5 && userNumbers.contains(bonusNumber)) {
                    return 6;
                }
            }
        }

        return count;
    }
}
    THREE_NUMBERS_MATCHES("3개 일치 (5,000원) - %d개\n", 5000),
    FOUR_NUMBERS_MATCHES("4개 일치 (50,000원) - %d개\n", 50000),
    FIVE_NUMBERS_MATCHES("5개 일치 (1,500,000원) - %d개\n", 1500000),
    FIVE_AND_BONUS_NUMBERS_MATCHES("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", 30000000),
    SIX_NUMBERS_MATCHES("6개 일치 (2,000,000,000원) - %d개\n", 2000000000);
