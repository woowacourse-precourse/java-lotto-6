package lotto.service;

import static lotto.view.OutputView.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Amount;
import lotto.model.Bonus;
import lotto.model.Lotto;

public class LottoService {

    private static final int[] PRIZE_MONEY = {0, 0, 0, 5000, 50000, 1500000, 2000000000, 30000000};
    private Amount amount;
    private Lotto lotto;
    private Bonus bonus;
    private List<List<Integer>> myLottos;
    private List<Integer> correctLotto;
    private int myPrizeMoney;

    public void setAmount(String amount) {
        this.amount = new Amount(amount);
    }

    public void setLotto(String lotto) {
        this.lotto = new Lotto(lotto);
    }

    public void setBonus(String Bonus) {
        this.bonus = new Bonus(lotto.getNumbers(), Bonus);
    }

    // 구매한 로또의 수만큼 로또번호를 셋팅한다
    public void setMyLotto() {

        myLottos = new ArrayList<>();

        int buyLotto = numberOfPurchase();

        for (int price = 0; price < buyLotto; price++) {
            myLottos.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        printMyLottos(myLottos);
    }

    // 구매한 로또들을 전부 비교해서 몇개씩 맞았는지 구한다
    public List<Integer> resultLotto() {

        correctLotto = new ArrayList<>();

        for (List<Integer> myLotto : myLottos) {
            correctLotto.add(compareLotto(myLotto));
        }

        return correctLotto;

    }

    // 구매하는 로또의 개수
    public int numberOfPurchase() {
        return amount.getAmount() / 1000;
    }

    // 로또를 구매하는데 사용한 금액만으로 수익률을 계산한다
    public float rateReturn() {
        return (float) myPrizeMoney / (numberOfPurchase() * 10);
    }

    // 로또 하나를 비교하는 함수
    private int compareLotto(List<Integer> myLotto) {

        int matchCount = 0;
        for (int lottoNumber : myLotto) {
            matchCount += compareOnce(lotto.getNumbers(), lottoNumber);
        }

        if (matchCount == 5 && compareOnce(myLotto, bonus.getBonus()) == 1) {
            myPrizeMoney += PRIZE_MONEY[7];
            return 10;
        }

        myPrizeMoney += PRIZE_MONEY[matchCount];
        return matchCount;

    }

    // 로또에서 번호 하나를 비교하는 함수
    private int compareOnce(List<Integer> lotto, int number) {
        if (lotto.contains(number)) {
            return 1;
        }
        return 0;
    }

}
