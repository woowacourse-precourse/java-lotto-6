package lotto.domain;

import static lotto.constant.NumberConstant.LOTTO_PRICE;
import static lotto.exception.ExceptionMessage.INDIVISIBLE;
import static lotto.exception.ExceptionMessage.OUT_OF_MEMORY;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import lotto.util.Parser;
import lotto.util.LottoValidator;
import lotto.exception.LottoException;

public class Lottos {
    private List<Lotto> lottos;

    private Lottos(long money) {
        long quantity = moneyToQuantity(money);
        this.lottos = generateLotto(quantity);
    };

    public static Lottos purchase(String inputMoney) {
        LottoValidator.validateNotNull(inputMoney);
        return new Lottos(Parser.parseMoney(inputMoney));
    }

    public long getLottoQuantity() {
        return lottos.size();
    }

    public List<String> getLottoNumbers() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.toList());
    }

    public LottoResults getLottoResults(Lotto winningNumber, int bonusNumber) {
        List<LottoResult> lottoResults = lottos.stream()
                .map(lotto -> calculateMatchResult(lotto, winningNumber, bonusNumber))
                .collect(Collectors.toList());
        return new LottoResults(lottoResults);
    }

    private LottoResult calculateMatchResult(Lotto lotto, Lotto winningNumber, int bonusNumber) {
        int matchCount = lotto.countMatchNumbers(winningNumber);
        boolean matchBonusNumber = false;

        if (matchCount == 5) {
            matchBonusNumber = lotto.hasSameNumber(bonusNumber);
        }
        return LottoResult.create(matchCount, matchBonusNumber);
    }

    private long moneyToQuantity(long money) throws LottoException {
        if (money % LOTTO_PRICE.getValue() > 0) {
            throw new LottoException(INDIVISIBLE);
        }
        return money / LOTTO_PRICE.getValue();
    }

    private List<Lotto> generateLotto(long ticketQuantity) throws LottoException {
        try {
            return LongStream.range(0, ticketQuantity)
                    .mapToObj(lotto -> new Lotto(LottoNumberGenerator.generateLottoNumbers()))
                    .collect(Collectors.toList());
        } catch (OutOfMemoryError e) {
            throw new LottoException(OUT_OF_MEMORY);
        }
    }
}
