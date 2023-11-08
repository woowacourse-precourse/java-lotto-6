package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerate {
    public static int lottoTicketsCount(int moneyNumber) {
        return moneyNumber / 1000;
    }

    private static List<Integer> generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    private static Lotto lottoAscendingOrder(List<Integer> numbers) {
        Collections.sort(numbers);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    public static List<Lotto> generateLottoTickets(int lottoTicketsCount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 1; i <= lottoTicketsCount; i++) {
            List<Integer> numbers = generateLotto();
            Lotto lotto = lottoAscendingOrder(numbers);
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }

    public static void classifyLottoResult(List<Integer> lottoResult,
                                           int matchingCount,
                                           boolean matchBonus) {

        if (matchingCount == 3) {
            lottoResult.set(0, lottoResult.get(0) + 1);
        }
        if (matchingCount == 4) {
            lottoResult.set(1, lottoResult.get(1) + 1);
        }
        if (matchingCount == 5 && !matchBonus) {
            lottoResult.set(2, lottoResult.get(2) + 1);
        }
        if (matchingCount == 5 && matchBonus) {
            lottoResult.set(3, lottoResult.get(3) + 1);
        }
        if (matchingCount == 6) {
            lottoResult.set(4, lottoResult.get(4) + 1);
        }
    }

    public static List<Integer> generateLottoResult(List<Lotto> lottoTickets,
                                                    List<Integer> lottoWinngNumbers,
                                                    int lottoBonusNumber) {
        Integer[] tempArray = {0, 0, 0, 0, 0};
        List<Integer> lottoResult = new ArrayList<>(List.of(tempArray));
        for (Lotto lotto : lottoTickets) {
            int matchingCount = lotto.getLottoMatchingCount(lottoWinngNumbers);
            boolean matchBonus = lotto.getLottoMatchBonus(lottoBonusNumber);
            classifyLottoResult(lottoResult, matchingCount, matchBonus);
        }
        return lottoResult;
    }

    public static Double calculateLottoRate(int lottoTickets, List<Integer> lottoResult) {
        int money = lottoTickets * 1000;
        int earning = (lottoResult.get(0) * 5000) +
                (lottoResult.get(1) * 50000) +
                (lottoResult.get(2) * 1500000) +
                (lottoResult.get(3) * 30000000) +
                (lottoResult.get(4) * 2000000000);
        double rate = (double) earning / money;
        rate = Math.round(rate * 1000.0) / 10.0;
        return rate;
    }
}
