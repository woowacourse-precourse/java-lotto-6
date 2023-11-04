package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_OF_NUMBERS = 6;

    private final List<Lotto> lottos = new ArrayList<>();

    public void start() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        int purchaseAmount = Integer.parseInt(Console.readLine());

        int purchasedLottosNumber = purchaseAmount / LOTTO_PRICE;
        makeLottos(purchasedLottosNumber);
    }

    private void makeLottos(int lottosNumber) {
        for (int i = 0; i < lottosNumber; i++) {
            addLotto(new Lotto(makeRandomLottoNumbers()));
        }
    }

    private List<Integer> makeRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_OF_NUMBERS);
    }

    private void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }
}
