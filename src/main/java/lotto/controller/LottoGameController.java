package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGameController {
    private static final int LOTTO_PRICE = 1000;

    private List<Lotto> purchaseLottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / LOTTO_PRICE;
        OutputView.printPurchaseMsg(lottoCount);
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)))
                .collect(Collectors.toList());
    }

}
