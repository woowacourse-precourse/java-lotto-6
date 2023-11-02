package lotto;

import static lotto.OutputView.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private Amount amount;
    private Lotto lotto;
    private Bonus bonus;
    private List<List<Integer>> myLottos = new ArrayList<>();

    public void setAmount(String amount) {
        this.amount = new Amount(amount);
    }

    public void setLotto(String lotto) {
        this.lotto = new Lotto(lotto);
    }

    public void setBonus(String Bonus) {
        this.bonus = new Bonus(lotto.getNumbers(), Bonus);
    }

    public void setMyLotto() {
        int buyLotto = amount.getAmount() / 1000;
        printBuy(buyLotto);
        for (int price = 0; price <= buyLotto; price++) {
            myLottos.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        printMyLottos(myLottos);
    }

    private List<Integer> resultLotto() {

        List<Integer> correctLotto = new ArrayList<>();

        for (List<Integer> myLotto : myLottos) {
            correctLotto.add(compareLotto(myLotto));
        }

        return correctLotto;

    }

    private int compareLotto(List<Integer> myLotto) {
        int matchCount = 0;
        for (int lottoNumber : myLotto) {
            matchCount = compareOnce(matchCount, lotto.getNumbers(), lottoNumber);
        }

        if (matchCount == 4) {
            matchCount = compareOnce(matchCount, myLotto, bonus.getBonus());
        }

        return matchCount;

    }

    private int compareOnce(int count, List<Integer> lotto, int number) {
        if (lotto.contains(number)) {
            count++;
        }
        return count;
    }

}
