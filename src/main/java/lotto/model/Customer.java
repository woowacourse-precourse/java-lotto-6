package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.OutputView;
import lotto.view.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static lotto.constant.LottoConstant.*;

public class Customer {
    private final Money money;
    private List<Lotto> lottos;
    public Customer(String money) {
        this.money = new Money(money);
        this.lottos = new ArrayList<Lotto>();
    }
    public int getMoney() {
        return money.getValue();
    }

    public void buyLotto() {
        try {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(RANGE_START.getNumber(), RANGE_END.getNumber(), LOTTO_SIZE.getNumber());
            lottos.add(new Lotto(lotto));
        } catch (IllegalArgumentException error) {
            buyLotto();
        }

    }

    public int getLottosSize() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
