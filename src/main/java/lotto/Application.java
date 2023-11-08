package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("구매금액을 입력해 주세요.");
        int buyMoney = Integer.parseInt(Console.readLine());
        int count = buyMoney / 1000;
        System.out.println(count + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
            System.out.println(lotto);
        }
        //당첨번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] selectNumbers = Console.readLine().split(",");
        Set<Integer> winningNumberSet = new TreeSet<>();
        for (String selectNumber : selectNumbers) {
            winningNumberSet.add(Integer.parseInt(selectNumber.trim()));
        }
        //보너스 번호
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        winStatistic(lottos, winningNumberSet, bonusNumber, buyMoney);
        Console.close();
    }
    static void winStatistic(List<Lotto> lottos, Set<Integer> winningNumberSet, int bonusNumber, int buyMoney) {
        Map<LottoRank, Integer> prizeCount = initializePrizeCount();
        long totalPrize = calculatePrizes(lottos, winningNumberSet, bonusNumber, prizeCount);
        printStatistics(prizeCount, totalPrize, buyMoney);
    }
    private static Map<LottoRank, Integer> initializePrizeCount() {
        Map<LottoRank, Integer> prizeCount = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            prizeCount.put(rank, 0);
        }
        return prizeCount;
    }
    private static long calculatePrizes(List<Lotto> lottos, Set<Integer> winningNumberSet, int bonusNumber, Map<LottoRank, Integer> prizeCount) {
        long totalPrize = 0;
        for (Lotto lotto : lottos) {
            LottoRank rank = determineLottoRank(lotto, winningNumberSet, bonusNumber);
            prizeCount.put(rank, prizeCount.get(rank) + 1);
            totalPrize += rank.getPrizeMoney();
        }
        return totalPrize;
    }
    private static LottoRank determineLottoRank(Lotto lotto, Set<Integer> winningNumberSet, int bonusNumber) {
        int matchCount = 0;
        boolean bonusMatch = false;
        for (int number : lotto.getNumbers()) {
            if (winningNumberSet.contains(number)) {
                matchCount++;
            } else if (number == bonusNumber) {
                bonusMatch = true;
            }
        }
        return LottoRank.valueOf(matchCount, bonusMatch);
    }

    private static void printStatistics(Map<LottoRank, Integer> prizeCount, long totalPrize, int buyMoney){

    }
}
