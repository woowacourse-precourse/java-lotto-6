package lotto.domain;

import static lotto.constant.GeneralConstant.MAX_NUMBER;
import static lotto.constant.GeneralConstant.MIN_NUMBER;
import static lotto.constant.GeneralConstant.NUMBERS_SIZE;
import static lotto.constant.GeneralConstant.ZERO;
import static lotto.constant.GeneralConstant.LOTTO_PRICE;
import static lotto.constant.GeneralConstant.PRIZE_RANK_MAX;
import static lotto.constant.GeneralConstant.PRIZE_RANK_MONEY;
import static lotto.constant.GeneralConstant.PRIZE_RANK_INDEXES;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.MoneyValidator;
import lotto.util.RateOfReturnUtil;

public enum User {
    INSTANCE;
    private final LottoWallet lottoWallet = new LottoWallet();
    private List<Integer> prizeCounts = new ArrayList<Integer>();
    private int cost;
    private double rateOfReturn;

    public void purchaseLotto(int money) {
        MoneyValidator.validateMoney(money);
        cost = money;
        clearPrizeCounts();
        lottoWallet.clearWallet();
        addLottos(cost / LOTTO_PRICE);
    }

    private void addLottos(int amount) {
        for(int i = 0; i < amount; i++) {
            addLotto();
        }
    }

    private void addLotto() {
        lottoWallet.addLotto(pickNumbers());
    }

    private List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_SIZE);
    }

    private void clearPrizeCounts() {
        prizeCounts = new ArrayList<>(Collections.nCopies(PRIZE_RANK_MAX, ZERO));
    }

    public void plusPrizeCount(int prizeRank) {
        int count = prizeCounts.get(prizeRank);
        prizeCounts.set(prizeRank, count + 1);
    }

    public void calcRateOfReturn() {
        rateOfReturn = RateOfReturnUtil.calcRateOfReturn(cost, prizeCounts);
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public List<Lotto> getMyLotto() {
        return lottoWallet.getLottos();
    }

    public List<Integer> getPrizeCounts() {
        return prizeCounts;
    }
}
