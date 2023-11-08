package lotto.model.data;

import static lotto.util.AmountOfLotto.LOTTO_PRICE;

import lotto.model.record.Money;
import lotto.model.record.NumberOfLotto;

/**
 * 구입한 로또 번호에 대한 영수증을 제공한다.
 * 투자금으로 구입할 수 있는 로또의 개수를 계산한다.
 */
public class LottoRecipe {
    private final Money money;
    private NumberOfLotto numberOfLotto;

    /**
     * 특정 금액을 가진 LottoRecipe를 생성한다.
     *
     * @param money 투자금
     */
    private LottoRecipe(Money money) {
        this.money = money;
    }

    /**
     * 새 LottoRecipe를 생성하는 정적 팩토리 메소드이다.
     *
     * @param money 투자금
     * @return 새 LottoRecipe 인스턴스
     */
    public static LottoRecipe from(Money money) {
        return new LottoRecipe(money);
    }

    /**
     * LottoRecipe에 저장되어 있는 투자금을 반환한다.
     *
     * @return 투자금
     */
    public Money getMoney() {
        return money;
    }

    /**
     * 투자금으로 구입할 수 있는 로또의 개수를 계산하고 반환한다.
     *
     * @return 투자금으로 구입할 수 있는 로또의 개수
     */
    public NumberOfLotto purchaseLotto() {
        numberOfLotto = new NumberOfLotto(money.money() / LOTTO_PRICE.getPrice());

        return numberOfLotto;
    }
}
