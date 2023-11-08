package lotto.service.impl;

import static lotto.utils.LottoConstants.END_NUMBER;
import static lotto.utils.LottoConstants.LOTTO_NUMBERS;
import static lotto.utils.LottoConstants.START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.adapter.IoAdapter;
import lotto.domain.Lotto;
import lotto.vo.Wallet;
import lotto.service.LottoProduceService;
import lotto.service.SortService;
import lotto.utils.CalculationConstants;
import lotto.vo.Money;

public class LottoProduceServiceImpl implements LottoProduceService {

    private final SortService sortService;
    private final IoAdapter ioAdapter;

    public LottoProduceServiceImpl(SortService sortService, IoAdapter ioAdapter) {
        this.sortService = sortService;
        this.ioAdapter = ioAdapter;
    }

    @Override
    public Wallet produceLotto(Money money) {
        CalculationConstants startCount = CalculationConstants.START_COUNT;
        int count = startCount.getValue();
        List<Lotto> lottoBundle = new ArrayList<>();
        while (!money.isLottoCountSameAsMoney(count)) {
            List<Integer> sortedLotto = makeLotto();
            Lotto lotto = new Lotto(sortedLotto);
            lottoBundle.add(lotto);
            count++;
        }
        return new Wallet(lottoBundle);
    }

    private List<Integer> makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER.getValue(), END_NUMBER.getValue(),
                LOTTO_NUMBERS.getValue());
        List<Integer> sortedLotto = sortService.sortLottoAsc(numbers);
        ioAdapter.printMessage(sortedLotto.toString());
        return sortedLotto;
    }
}
