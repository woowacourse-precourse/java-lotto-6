package lotto.domain;

import static lotto.global.common.GameMessage.NEW_LINE_MESSAGE;
import static lotto.global.common.GameMessage.PURCHASE_MESSAGE;
import static lotto.global.common.LottoConstant.END_INCLUSIVE;
import static lotto.global.common.LottoConstant.PICK_NUMBERS_COUNT;
import static lotto.global.common.LottoConstant.START_INCLUSIVE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoDraw {

    private final int lottoTicketsNumber;

    private final List<Lotto> lottos = new ArrayList<>();

    public LottoDraw(int lottoTicketsNumber) {
        this.lottoTicketsNumber = lottoTicketsNumber;
    }

    public void configureNumbers() {
        for (int i = 0; i < this.lottoTicketsNumber; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE,
                    PICK_NUMBERS_COUNT);
            List<Integer> mutableNumbers = new ArrayList<>(numbers);
            mutableNumbers.sort(Comparator.naturalOrder());
            this.lottos.add(new Lotto(mutableNumbers));
        }
    }

    public void printPurchaseHistory() {
        System.out.print(NEW_LINE_MESSAGE.message + this.lottoTicketsNumber + PURCHASE_MESSAGE.message);
        this.lottos.forEach(Lotto::printNumbers);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
