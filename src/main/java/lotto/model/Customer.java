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
        validationMoney(money);
        this.money = new Money(parseInt(money));
        this.lottos = new ArrayList<Lotto>();
    }

    private void validationMoney(String money) {
        try {
            parseInt(money);
        } catch (NumberFormatException error) {
            OutputView.printError(ErrorMessage.IS_NOT_NUMBER.getMessage());
            throw new IllegalArgumentException(ErrorMessage.ERROR.getMessage()+ErrorMessage.INPUT.getMessage());
        }
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
    public Lotto getLastLotto() {
        return lottos.get(lottos.size()-1);
    }

    public void throwLastLotto() {
        lottos.remove(lottos.size() -1);
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
