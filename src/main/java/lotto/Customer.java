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

        this.wallet = Integer.parseInt(wallet);
        buyLottos();
    }

    private void buyLottos() {

        Input.buyLottosInput(wallet);
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

    public void compareWinLotto(WinLotto winLotto) {
    }
}
