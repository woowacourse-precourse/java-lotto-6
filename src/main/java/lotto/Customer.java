package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private int wallet;
    private List<Lotto> lottos = new ArrayList<>();
    private final int LOTTOPRICE = 1000;
    private final int LOTTOCOUNT = 6;
    private final int MINRANGE = 1;
    private final int MAXRANGE = 45;

    public Customer(String wallet) {

        this.wallet = validateWallet(wallet);
        buyLottos();
    }

    private int validateWallet(String wallet) {

        try {

            int money = Integer.parseInt(wallet);
            validateWalletIsDivisible(money);
            return money;
        } catch (NumberFormatException e) {

            throw new IllegalArgumentException();
        }
    }

    private void validateWalletIsDivisible(int wallet) {

        if (wallet % 1000 != 0) {

            throw new IllegalArgumentException();
        }
    }

    private void buyLottos() {

        Output.printbuyLottos(wallet);
        createLottos();
    }

    private void createLottos() {

        int lottosCount = wallet / LOTTOPRICE;
        for (int i = 0; i < lottosCount; i++) {

            createLotto();
        }
    }

    private void createLotto() {

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MINRANGE, MAXRANGE, LOTTOCOUNT);
        lottos.add(new Lotto(numbers));
    }

    public List<Lotto> getLottos() {

        return lottos;
    }

    public void checkWinLotto(WinLotto winLotto) {

        for (int i = 0; i < lottos.size(); i++) {

            int correctCount = winLotto.compareLotto(lottos.get(i));
            int correctBonus = winLotto.compareBonusLotto(lottos.get(i));
            Output.countRank(correctCount, correctBonus);
        }
    }

    public double calculateRateOfReturn(double reward) {

        return reward / wallet * 100;
    }
}
