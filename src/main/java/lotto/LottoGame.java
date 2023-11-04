package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos = new ArrayList<>();

    public void start() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        int purchaseAmount = Integer.parseInt(Console.readLine());

        int purchasedLottosNumber = purchaseAmount / LOTTO_PRICE;
        makeLottos(purchasedLottosNumber);
    }

    private void makeLottos(int lottosNumber) {
        for (int i = 0; i < lottosNumber; i++) {
            addLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        }
    }

    private void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }
}
