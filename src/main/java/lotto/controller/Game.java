package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.LottoPaper;
import lotto.view.GamePrint;

public class Game {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;

    public void start() {
        GamePrint.inputPrice();
        String totalAmountPrice = Console.readLine();

        int buyLottoNumber = buyLotto(totalAmountPrice);
        GamePrint.numberOfPurchases(buyLottoNumber);

        List<Lotto> lottos = pickRandomLottos(buyLottoNumber);
        GamePrint.lottoNumbers(lottos);
    }

    private int buyLotto(String totalAmountPrice) {
        LottoPaper lottoPaper = new LottoPaper();
        return lottoPaper.buy(totalAmountPrice);
    }

    private List<Lotto> pickRandomLottos(int buyLottos) {
        return IntStream.range(0, buyLottos)
                .mapToObj(lottos -> new Lotto(
                        Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_COUNT)))
                .toList();
    }
}
