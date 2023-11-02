package lotto;

import static lotto.OutputView.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private static final int[] PRIZE_MONEY = {0, 0, 0, 5000, 50000, 1500000, 2000000000, 30000000};
    private Amount amount;
    private Lotto lotto;
    private Bonus bonus;
    private List<List<Integer>> myLottos;
    private List<Integer> correctLotto;
    private int prizeMoney;

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

        myLottos = new ArrayList<>();

        int buyLotto = numberOfPurchase();

        for (int price = 0; price < buyLotto; price++) {
            myLottos.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        printMyLottos(myLottos);
    }


    public List<Integer> resultLotto() {

        correctLotto = new ArrayList<>();

        for (List<Integer> myLotto : myLottos) {
            correctLotto.add(compareLotto(myLotto));
        }

        return correctLotto;

    }

    public int numberOfPurchase() {
        return amount.getAmount() / 1000;
    }

    public float rateReturn() {
        return prizeMoney / (float) amount.getAmount();
    }

    private int compareLotto(List<Integer> myLotto) {

        int matchCount = 0;
        for (int lottoNumber : myLotto) {
            matchCount += compareOnce(lotto.getNumbers(), lottoNumber);
        }

        if (matchCount == 4 && compareOnce(myLotto, bonus.getBonus()) == 1) {
            prizeMoney += PRIZE_MONEY[7];
            return 7;
        }

        prizeMoney += PRIZE_MONEY[matchCount];
        return matchCount;

    }

    private int compareOnce(List<Integer> lotto, int number) {
        if (lotto.contains(number)) {
            return 1;
        }
        return 0;
    }

}
