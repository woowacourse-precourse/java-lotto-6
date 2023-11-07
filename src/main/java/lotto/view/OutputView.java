package lotto.view;

import lotto.model.Lotto;
import lotto.model.User;
import lotto.utils.Prizes;

import java.util.HashMap;

public class OutputView {

    public void printLotto(User user){
        System.out.println((user.getPayed() / 1000) + "개를 구매했습니다.");
        for (Lotto lotto : user.getLottos()){
            System.out.println(lotto.printLotto());
        }
    }

    public void printPrizes(HashMap<Prizes, Integer> matches, double earnedPerPayed) {
        System.out.println("3개 일치 (5,000원) - " + matches.getOrDefault(Prizes.Fifth, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + matches.getOrDefault(Prizes.Fourth, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matches.getOrDefault(Prizes.Third, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matches.getOrDefault(Prizes.Second, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matches.getOrDefault(Prizes.First, 0) + "개");
        printPercentage(earnedPerPayed);
    }

    public void printPercentage(double earnedPerPayed){
        System.out.println("총 수익률은" + String.format("%.1f", earnedPerPayed) + "% 입니다.");
    }
}
