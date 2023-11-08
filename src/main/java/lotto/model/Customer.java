package lotto.model;

import static lotto.view.View.printMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constant.LottoConstant;

public class Customer {
    private List<Lotto> lottos;
    private Money budget;

    public Customer(Money budget) {
        lottos = new ArrayList<>();
        this.budget = budget;
    }

    public int getLottoCount() {
        return budget.getMoney() / LottoConstant.LOTTO_PRICE.getValue();
    }

    public List<Lotto> purchaseLotto() {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = getLottoCount();

        for (int i = 0; i < lottoCount; i++) {
            LottoNumber numbers = new LottoNumber();
            lottos.add(new Lotto(numbers.getLottoNumbers()));
        }

        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public void showLottos() {
        this.getLottos()
                .forEach(lotto ->
                        printMessage(lotto.getNumbers().toString()));
    }

}
