package domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.Validation;

import java.util.ArrayList;
import java.util.List;

public class Purchase {
    static final int LOTTO_START_NUMBER = 1;
    static final int LOTTO_END_NUMBER = 45;
    static final int LOTTO_LENGTH = 6;
    static final int LOTTO_BUY_UNIT = 1000;

    public int payMoney(String userInput) {
        Validation validation = new Validation();
        int paidMoney = validation.parsePurchaseAmount(userInput);
        validation.validateUnderZero(paidMoney);
        validation.validateDivideThousand(paidMoney);
        return paidMoney;
    }

    public List<Lotto> buyLotto(int payMoney) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < payMoney / LOTTO_BUY_UNIT; i++) {
            lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_LENGTH)));
        }
        return lottoList;
    }

    public List<Lotto> printPurchasedList(String userInput) {
        int payMoney = payMoney(userInput);
        int buyCount = payMoney / LOTTO_BUY_UNIT;
        System.out.println(buyCount + "개를 구매했습니다.");
        List<Lotto> buyLotto = buyLotto(payMoney);
        for (Lotto lotto : buyLotto) {
            System.out.println(lotto.toString());
        }
        return buyLotto;
    }

}
