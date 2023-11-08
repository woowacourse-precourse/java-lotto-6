package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class LottoGame {

    private final static User user = new User();
    private final static LottoStore lottoStore = new LottoStore();

    public static void start() {
        int pay = inputPay();
        List<Lotto> lottos = lottoStore.buyLottos(pay);
        printLottos(lottos);

        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber();

        WinningInfo winningInfo = new WinningInfo(winningNumbers, bonusNumber);
        long sum = printResult(winningInfo, lottos);
        printRate(sum, pay);
    }

    private static int inputPay() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputBuy = Console.readLine();
        System.out.println();
        return user.pay(inputBuy);
    }

    private static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    private static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNumbers = Console.readLine();
        System.out.println();
        return user.inputWinningNumbers(inputWinningNumbers);
    }

    private static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();
        System.out.println();
        return user.inputBonusNumber(inputBonusNumber);
    }

    private static long printResult(WinningInfo winningInfo, List<Lotto> lottos) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<Winnings, List<Winnings>> lottoResults = getLottoResults(winningInfo, lottos);
        System.out.println("3개 일치 (5,000원) - " + lottoResults.get(Winnings.FIFTH_PLACE).size() + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResults.computeIfAbsent(Winnings.FOURTH_PLACE, k -> new ArrayList<>()).size() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResults.computeIfAbsent(Winnings.THIRD_PLACE, k -> new ArrayList<>()).size() + "개");
        System.out.println("5개 일치 (30,000,000원), 보너스 볼 일치 - " + lottoResults.computeIfAbsent(Winnings.SECOND_PLACE, k -> new ArrayList<>()).size() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResults.computeIfAbsent(Winnings.FIRST_PLACE, k -> new ArrayList<>()).size() + "개");

        return getSum(lottoResults);
    }

    private static Map<Winnings, List<Winnings>> getLottoResults(WinningInfo winningInfo, List<Lotto> lottos) {
        return lottos.stream()
                .map(winningInfo::check)
                .collect(Collectors.groupingBy(Winnings::getSelf));
    }

    private static long getSum(Map<Winnings, List<Winnings>> lottoResults) {
        AtomicLong sum = new AtomicLong();

        lottoResults.values()
                .forEach(winningsList -> winningsList
                        .forEach(winnings -> sum.addAndGet(winnings.getWinningsNumber())));

        return sum.get();
    }

    private static void printRate(long sum, int pay) {
        System.out.println("총 수익률은 " + Math.round(((double) pay) / sum * 10) / 10 + "%입니다.");
    }
}
