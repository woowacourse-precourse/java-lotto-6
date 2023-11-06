package lotto;

import lotto.model.Draw;

import java.util.List;

public class Perform {
    public void checknumbers(List<Draw> tickets, List<Integer> lotto, int bonus) {
        for (Draw t : tickets) {
            System.out.println(t.returnprint(lotto, bonus)+"개당첨 ~");
        }
    }
    public int isMatch(int bonus, int number) {
        if (bonus == number) return 1;
        return 0;
    }
}
