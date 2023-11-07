package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constant.NumberConstants.*;

public class LottoMachine {
    private final List<Lotto> lottoPapers = new ArrayList<>();

    public LottoMachine(int amount) {
        createLotto(amount);
    }

    public void createLotto(int amount) {
        for (int i = ZERO; i < amount; i++) {
            List<Integer> randomSixNumbers = new ArrayList<>(pickLottoNumber());
            Collections.sort(randomSixNumbers);
            lottoPapers.add(new Lotto(randomSixNumbers));
        }
    }

    private static List<Integer> pickLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(NUMBER_RANGE_MIN,
                NUMBER_RANGE_MAX,
                WINNING_NUMBER);
    }

    public static LottoMachine buyLotto(PurchaseLotto purchaseLottoAmount) {
        int lottoPaperAmount = purchaseLottoAmount.calculateLottoCount();
        OutputView.purchaseCount(lottoPaperAmount);
        return new LottoMachine(lottoPaperAmount);
    }


    public List<Lotto> getLottoPapers() {
        return Collections.unmodifiableList(lottoPapers);
    }
}
