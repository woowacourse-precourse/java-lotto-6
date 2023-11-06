package lotto;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        BuyPrice buyPrice = new BuyPrice();
        int buy = buyPrice.buylotto();
        System.out.printf("%d개를 구매했습니다.\n", buy / 1000);
        List<List<Integer>> usernumber = new ArrayList<>();
        UserNumber userNumber = new UserNumber();
        for (int i = 0; i < buy / 1000; i++) {
            usernumber.add(userNumber.lottonumber());
        }
        System.out.println("\n당첨 번호를 입력해 주세요.");
        WinNumber winNumber = new WinNumber();
        List<Integer> win = winNumber.win();
        System.out.println("\n보너스 번호를 입력해 주세요.");
        BonusNumber bonusNumber = new BonusNumber();
        int bonus = bonusNumber.bonus(win);
        CompareNumber compareNumber = new CompareNumber();
        List<List<Integer>> compare = new ArrayList<>();
        for (int i = 0; i < usernumber.size(); i++) {
            compare.add(compareNumber.compare(usernumber.get(i), win, bonus));
        }
        Rank rank = new Rank();
        List<Integer> ranklist = rank.rank(compare);
        PrintLotto printLotto = new PrintLotto();
        printLotto.print(ranklist, buy);
    }
}