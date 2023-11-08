package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Constant;
import lotto.Util;

import java.util.ArrayList;
import java.util.List;

public class LottoBuyer {

    private final List<Lotto> lottos;
    private final int purchaseNumber;

    private static final String INVALID_MONEY_UNIT = "1,000원 단위로만 입력 가능합니다.";


    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getPurchaseNumber() {
        return purchaseNumber;
    }

    public LottoBuyer(String money) {
        this.lottos = new ArrayList<>();
        int validedMoney = validMoney(money);
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

    public static int validMoney(String number) {
        int money = Util.toInteger(number);

        if (money % 1000 != 0) {
            throw new IllegalArgumentException(Constant.ERROR_PREFIX + INVALID_MONEY_UNIT);
        }

        return money;
    }
}
