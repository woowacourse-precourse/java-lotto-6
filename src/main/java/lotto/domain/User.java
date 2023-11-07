package lotto.domain;

import static lotto.constant.GeneralConstant.MAX_NUMBER;
import static lotto.constant.GeneralConstant.MIN_NUMBER;
import static lotto.constant.GeneralConstant.LOTTO_PRICE;
import static lotto.constant.GeneralConstant.NUMBERS_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.util.MoneyValidator;

public class User {
    private final LottoWallet lottoWallet;
    private final UserPrize userPrize;

    public User(LottoWallet lottoWallet, UserPrize userPrize) {
        this.lottoWallet = lottoWallet;
        this.userPrize = userPrize;
    }

    public void purchaseLotto(int money) {
        MoneyValidator.validateMoney(money);
        userPrize.setCost(money);
        lottoWallet.clearWallet();
        addLottos(money / LOTTO_PRICE);
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

    public void winningTheLotto(int rank) {
        userPrize.plusPrizeCount(rank);
    }

    public double getRateOfReturn() {
        return userPrize.getRateOfReturn();
    }

    public List<Lotto> getMyLotto() {
        return lottoWallet.getLottos();
    }

    public List<Integer> getPrizeCounts() {
        return userPrize.getPrizeCounts();
    }
}
