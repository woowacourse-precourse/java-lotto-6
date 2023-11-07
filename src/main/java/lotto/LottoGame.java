package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;

    private static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine().trim());
        if (purchaseAmount < LOTTO_PRICE || purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
        return purchaseAmount;
    }

    private static List<Lotto> purchaseLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(generateRandomLottoNumbers()));
        }
        return lottos;
    }

    private static List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBERS_COUNT)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
