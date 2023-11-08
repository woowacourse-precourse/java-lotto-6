package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.system.Constant;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ClientLotto {
    private final LottoSequence lottoSequence = new LottoSequence();

    public ClientLotto() {
        addLotto();
        printLotto();
    }

    public int size() {
        return lottoSequence.size();
    }

    public Lotto getLottoAt(int index) {
        return lottoSequence.get(index);
    }

    private int getClientMoney() {
        return InputView.readAmount();
    }

    public void addLotto() {
        long count = getClientMoney() / Constant.MONEY_UNIT;
        while (count-- > 0) {
            lottoSequence.add(makeLotto());
        }
    }

    private Lotto makeLotto() {
        return new Lotto(makeUniqueRandomList());
    }

    private void printLotto() {
        OutputView.printReceipt(lottoSequence.size());
        lottoSequence.printAllLotto();
    }

    public static List<Integer> makeUniqueRandomList() {
        return Randoms.pickUniqueNumbersInRange(
                Constant.START_INCLUSIVE,
                Constant.END_INCLUSIVE,
                Constant.LOTTO_SIZE
        );
    }
}
