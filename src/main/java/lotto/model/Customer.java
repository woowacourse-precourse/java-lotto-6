package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<Lotto> lottos;
    private Money budget;
    public Customer(Money budget) {
        lottos = new ArrayList<>();
        this.budget = budget;
    }
    public int getLottoCount() {
        return budget.getMoney() / 1000;
    }
    public void purchaseLotto() {
        for (int i = 0; i < getLottoCount(); i++) {
            LottoNumber numbers = new LottoNumber();
            lottos.add(new Lotto(numbers.getLottoNumbers()));
        }
    }
    public List<Lotto> getLottos() {
        return lottos;
    }
}
