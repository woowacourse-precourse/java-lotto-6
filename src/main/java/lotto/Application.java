package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int number = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                number = Integer.parseInt(Console.readLine());
                if (number % 1000 != 0) throw new IllegalArgumentException();
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력하실 수 있습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1,000원 단위로 입력하세요.");
            }
        }

        System.out.println();

        System.out.println(number/1000+"개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i<number/1000 ; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lotto.sortNumbers();
            System.out.println(lotto.getNumbers());
            lottos.add(lotto);
        }
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningNumbers = Console.readLine().split(",");
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonus = Integer.parseInt(Console.readLine());
        System.out.println();

        System.out.println("당첨 통계");
        System.out.println("---");

        for(Lotto lotto : lottos) {
            int lottoMatches = 0;
            for (String select : winningNumbers) {
                if (lotto.getNumbers().contains(Integer.parseInt(select))) {
                    lottoMatches++;
                }
            }
            boolean hasBonusNumber = lotto.getNumbers().contains(bonus);

            LottoRank.getByCountAndBonus(lottoMatches,hasBonusNumber);
        }

        double totalWinnings = 0;
        for(LottoRank rank : LottoRank.values()) {
            System.out.println(rank.getPrizeInfo()+rank.getAdditionalMatches()+"개");
            totalWinnings += rank.getAdditionalMatches()*rank.getPrize();
        }

        double profitRate = (totalWinnings/number)*100 ;
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }
}