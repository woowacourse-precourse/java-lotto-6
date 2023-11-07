package lotto.service;

import lotto.model.Lottos;

public class LotteryKiosk {

    private static final int UNIT_MONEY = 1000;
    private final LottoGenerator lottoGenerator;

    public LotteryKiosk(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lottos publish(int money) {
        int issueCount = issueCount(money);
        Lottos lottoBundle = lottoGenerator.createLottoBundle(issueCount);
        validateNormalCreate(lottoBundle, issueCount);
        return lottoBundle;
    }


    public int issueCount(int money) {
        if (money % UNIT_MONEY != 0 || money <= 0) {
            throw new IllegalArgumentException("[ERROR] 사용자는 1000원 단위로 구입할 수 있습니다.");
        }
        return money / UNIT_MONEY;
    }


    private void validateNormalCreate(Lottos lottos, int issueCount) {
        if (issueCount != lottos.getSize()) {
            throw new IllegalArgumentException(
                    "[ERROR] 로또 발급을 실패했습니다." + "Actual : [" + lottos.getSize() + "] Expected: [" + issueCount + "]");
        }
    }

}
