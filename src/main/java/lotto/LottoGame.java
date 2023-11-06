package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    // 로또 발행
    public int buyLotto() {
        System.out.println("구입금액을 입력해주세요.");
        int amount = Integer.parseInt(Console.readLine().strip());
        int buy = amount/1000;
        System.out.println("\n"+buy+"개를 구매했습니다.");
        return buy;
    }

    // 당첨 번호 추첨
    public Lotto drawLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        System.out.println(numbers);

        return new Lotto(numbers);
    }

    // 당첨 번호
    public Lotto inputWinningNumbers() {
        while(true){
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                List<Integer> numbers = Arrays.stream((input.split(",")))
                        .map(this::parseInteger)
                        .toList();
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    // 보너스 번호 입력
    public int inputBonusNumber(){
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                return parseInteger(Console.readLine().strip());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private Integer parseInteger(String s) {
        try {
            return Integer.valueOf(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    // 당첨 번호 비교
    public int numberComparison(Lotto draw, Lotto win) {
        int count = 0;
        for(Integer number : win.getNumbers()){
            if (draw.contains(number)) {
                count++;
            }
        }
        return count;
    }

    // 보너스 비교
    public boolean bonusComparison(Lotto draw, int bonus) {
        return draw.contains(bonus);
    }

    // 당첨 현황
    public int[] winningResult(List<Lotto> draws, Lotto win, int bonus) {
        int[] winningList = new int[5];
        for (Lotto draw : draws){
            int count = numberComparison(draw, win);
            if (count > 2) {
                winningList[count-3]++;
            }
            if (count == 5 && bonusComparison(draw, bonus)) {
                winningList[2]--;
                winningList[3]++;
            }
        }
        return winningList;
    }

    public enum Prize {
        THIRD("3개 일치 (5,000원)", 5000),
        FOURTH("4개 일치 (50,000원)", 50000),
        FIFTH("5개 일치 (1,500,000원)", 1500000),
        BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
        SIXTH("6개 일치 (2,000,000,000원)", 2000000000);

        private final String description;
        private final int prizeAmount;

        Prize(String description, int prizeAmount) {
            this.description = description;
            this.prizeAmount = prizeAmount;
        }

        public String getDescription() {
            return description;
        }

        public int getPrizeAmount() {
            return prizeAmount;
        }
    }

    // 당첨 통계
    public static void winningStats(int[] winningList) {
        System.out.println("\n당첨 통계\n---");
        for (Prize prize : Prize.values()) {
            int count = winningList[prize.ordinal()];
            System.out.printf("%s - %d\n", prize.getDescription(), count);
        }
    }

    // 수익률 출력
    public static void rateOfReturn(int[] winningList, int buy) {
        double total = 0;
        for (Prize prize : Prize.values()) {
            int count = winningList[prize.ordinal()];
            total += prize.getPrizeAmount() * count;
        }
        double rate = (total / (buy * 1000));
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedRate = decimalFormat.format(rate);

        System.out.printf("총 수익률은 %s%%입니다.\n", formattedRate);
    }

    // 예외 상황 출력
}
