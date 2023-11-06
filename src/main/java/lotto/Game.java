package lotto;

import lotto.constant.Constant;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Game {

    private void printListLotto(List<Lotto> listLotto){
        System.out.printf("\n%d개를 구매했습니다.\n", listLotto.size());
        for (Lotto lotto : listLotto){
            lotto.printNumbers();
        }
    }

    private List<Lotto> getListLotto(int money){
        List<Lotto> list = new ArrayList<>();
        int cntLotto = money / 1000;

        for(int i = 0; i < cntLotto; i++) {
            List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            list.add(lotto);
        }
        return list;
    }

    public void run(){
        Money money = new Money();
        List<Lotto> listLotto = getListLotto(money.val);

        printListLotto(listLotto);
    }
}
