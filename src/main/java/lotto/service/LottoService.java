package lotto.service;

import java.util.List;
import java.util.stream.Stream;
import lotto.common.CommonUtil;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.Profit;
import lotto.domain.WinLotto;
import lotto.common.NumberGenerator;

public class LottoService {
    private final NumberGenerator generator;

    public LottoService(NumberGenerator generator) {
        this.generator = generator;
    }

    public List<Lotto> createLottos(Money money) {
        return Stream.generate(() -> Lotto.from(generator.generate()))
                .limit(money.getLottoCount())
                .toList();
    }

    public WinLotto createWinLotto(String numberInput, String bonusInput) {
        List<Integer> winLottoNumbers = CommonUtil.convertToNumbers(numberInput);
        int bonusBall = CommonUtil.convertToNumber(bonusInput);

        return WinLotto.of(Lotto.from(winLottoNumbers), LottoNumber.getInstance(bonusBall));
    }

    public LottoResult calculateResult(List<Lotto> lottos, WinLotto winLotto) {
        return LottoResult.of(lottos, winLotto);
    }

    public Profit calculateProfit(LottoResult lottoResult, Money money) {
        return Profit.of(money.getValue(), lottoResult.getTotalPrize());
    }

    public Money createMoney(String input) {
        long money = CommonUtil.convertToLong(input);
        return Money.from(money);
    }
}
