package lotto.domain;

import static lotto.constant.Constant.LOTTO_PRICE;
import static lotto.constant.Constant.MAX_NUMBER;
import static lotto.constant.Constant.MIN_NUMBER;
import static lotto.constant.Constant.NUMBERS_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.util.MoneyValidate;

public class User {
    private final LottoWallet lottoWallet;
    private final UserPrize userPrize;

    public User(LottoWallet lottoWallet, UserPrize userPrize) {
        this.lottoWallet = lottoWallet;
        this.userPrize = userPrize;
    }

    public void purchaseLotto(int money) {
        MoneyValidate.validateMoney(money);
        userPrize.setCost(money);
        lottoWallet.clearWallet();
        addLotto(money / LOTTO_PRICE);
    }

    private void addLotto(int amount) {
        for (int i = 0; i < amount; i++) {
            addLotto();
        }
    }

    private void addLotto() {
        lottoWallet.addLotto(pickNumbers());
    }

    private List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_SIZE);
    }

    public void winningTheLotto(int rank) {
        userPrize.plusPrizeCount(rank);
    }

    public double getRateOfReturn() {
        return userPrize.getRateOfReturn();
    }

    public List<Lotto> getMyLotto() {
        return lottoWallet.getLotto();
    }

    public List<Integer> getPrizeCount() {
        return userPrize.getPrizeCounts();
    }
}
