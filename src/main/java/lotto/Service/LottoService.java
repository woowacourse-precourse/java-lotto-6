package lotto.Service;

import static lotto.Util.Constants.LOTTO_PRICE_UNIT;

import java.util.ArrayList;
import java.util.List;
import lotto.Domain.BonusNumber;
import lotto.Domain.Lotto;
import lotto.Domain.User;
import lotto.Domain.WinningLotto;
import lotto.Util.LottoNumGenerator;

public class LottoService {
    private User user;
    private WinningLotto winningLotto;
    public List<Lotto> purchaseLotto(int money) {
        int count = countNumberOfPurchase(money);
        List<Lotto> lottos = publishLotto(count);
        user = new User(money,lottos);
        return lottos;
    }

    public void createWinningLotto(List<Integer> winningNumbers, int bonusNum) {
        Lotto winningLotto = new Lotto(winningNumbers);
        BonusNumber bonusNumber = new BonusNumber(bonusNum);
        this.winningLotto = new WinningLotto(winningLotto,bonusNumber);
    }

    private int countNumberOfPurchase(int money) {
        return money / LOTTO_PRICE_UNIT;
    }

    private List<Lotto> publishLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(LottoNumGenerator.generate()));
        }
        return lottos;
    }
}
