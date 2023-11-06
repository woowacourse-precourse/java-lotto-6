package controller;

import camp.nextstep.edu.missionutils.Randoms;
import constants.NumberType;
import lotto.Lotto;
import lotto.Lottos;
import lotto.Money;
import utils.RandomUtils;
import view.InputView;

public class LottoController {


    public void run() {
        int lottoCount = getLottoCount(generateMoney());
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = generateLotto();
            System.out.println(lotto.toString());
        }
    }

    private Lotto generateLotto() {
        return new Lotto(RandomUtils.generateRandomLottoNumber());
    }

    private Money generateMoney() {
        return new Money(Integer.parseInt(InputView.readLine()));
    }

    private int getLottoCount(Money money) {
        return money.getLottoCount();
    }
}
