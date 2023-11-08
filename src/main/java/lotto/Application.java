package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    //당처금
    private static final long PRIZE_FIRST = 2_000_000_000;
    private static final long PRIZE_SECOND = 30_000_000;
    private static final long PRIZE_THIRD = 1_500_000;
    private static final long PRIZE_FOURTH = 50_000;
    private static final long PRIZE_FIFTH = 5_000;
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
        System.out.println("당첨 통계");
        System.out.println("---");
        Map<Integer, Integer> prizeCount = new HashMap<>();
        prizeCount.put(3, 0);
        prizeCount.put(4, 0);
        prizeCount.put(5, 0);
        prizeCount.put(6, 0);
        prizeCount.put(7, 0);

        long totalPrize = 0;
        for (Lotto lotto : lottos){
            int matchCount = 0;
            boolean bonusMatch = false;
            for (int number : lotto.getNumbers()){
                if (winningNumberSet.contains(number)){
                    matchCount++;
                } else if (number == bonusNumber){
                    bonusMatch = true;
                }
            }
            if (matchCount == 5 && bonusMatch) {
                totalPrize += PRIZE_SECOND;
                prizeCount.put(7, prizeCount.get(7) + 1);
            } else {
                switch (matchCount) {
                    case 6 -> {
                        totalPrize += PRIZE_FIRST;
                        prizeCount.put(6, prizeCount.get(6) + 1);
                    }
                    case 5 -> {
                        totalPrize += PRIZE_THIRD;
                        prizeCount.put(5, prizeCount.get(5) + 1);
                    }
                    case 4 -> {
                        totalPrize += PRIZE_FOURTH;
                        prizeCount.put(4, prizeCount.get(4) + 1);
                    }
                    case 3 -> {
                        totalPrize += PRIZE_FIFTH;
                        prizeCount.put(3, prizeCount.get(3) + 1);
                    }
                }
            }
        }
        System.out.println("3개 일치 (5,000원) - " + prizeCount.get(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + prizeCount.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizeCount.get(5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeCount.get(7) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeCount.get(6) + "개");

        double profitRate = ((double) totalPrize / buyMoney) * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }
}
