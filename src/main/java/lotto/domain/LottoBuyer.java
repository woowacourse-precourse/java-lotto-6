package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoBuyer {

    private final List<Lotto> lottos;
    private final int purchaseNumber;

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getPurchaseNumber() {
        return purchaseNumber;
    }

    public LottoBuyer(String money) {
        this.lottos = new ArrayList<>();
        int validedMoney = Validator.validateMoney(money);
        this.purchaseNumber = validedMoney / 1000;
        buyLotto();
    }

    public void buyLotto() {
        for (int i = 0; i < purchaseNumber; i++) {
            lottos.add(new Lotto(generateLottoNumber()));
        }
    }

    public List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
