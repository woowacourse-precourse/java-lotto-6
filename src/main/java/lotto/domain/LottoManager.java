package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.LottoConstants;

public class LottoManager {
    private static List<Lotto> lottos;
    private static Generator generator = new LottoGenerator();
    private static int lottoCount;

    private LottoManager(int money) {
        buyLottos(money);
    }

    public static LottoManager from(int money) {
        return new LottoManager(money);
    }

    public void buyLottos(int money) {
        validateMoney(money);
        lottos = new ArrayList<>();
        lottoCount = calculateMoney(money);
        while (checkMoneyRemain(lottoCount)) {
            lottos.add(getNewLotto());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private void validateMoney(int money) {
        if (isDividedByPrice(money)) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 구입 금액은 %d원 단위입니다.", LottoConstants.PRICE));
        }
        if (isInMinMoney(money)) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 최소 구입 금액은 %d원 입니다.", LottoConstants.PRICE));
        }
    }

    private Lotto getNewLotto() {
        lottoCount -= 1;
        return Lotto.createAutoLottoNumbers(generator);
    }

    private boolean checkMoneyRemain(int lottoCount) {
        return lottoCount != 0;
    }

    private int calculateMoney(int money) {
        return money / LottoConstants.PRICE.getConstants();
    }

    private boolean isDividedByPrice(int money) {
        return money % LottoConstants.PRICE.getConstants() != 0;
    }

    private boolean isInMinMoney(int money) {
        return money < LottoConstants.PRICE.getConstants();
    }
}
