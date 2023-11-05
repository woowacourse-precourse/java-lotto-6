package lotto.domain;

import static lotto.exception.ExceptionMessage.INDIVISIBLE;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import lotto.util.Parser;
import lotto.util.LottoValidator;
import lotto.exception.LottoException;

public class Lottos {
    private List<Lotto> lottos;

    private Lottos(int money) {
        int quantity = moneyToQuantity(money);
        this.lottos = generateLotto(quantity);
    };

    public static Lottos purchase(String inputMoney) {
        LottoValidator.validateNotNull(inputMoney);
        return new Lottos(Parser.parseMoney(inputMoney));
    }

    public int getLottoQuantity() {
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

    private int moneyToQuantity(int money) throws LottoException {
        // TODO: 매직넘버 상수화하기
        if (money % 1_000 > 0) {
            throw new LottoException(INDIVISIBLE);
        }
        return money / 1_000;
    }

    private List<Lotto> generateLotto(int ticketQuantity) {
        return IntStream.range(0, ticketQuantity)
                .mapToObj(lotto -> new Lotto(LottoNumberGenerator.generateLottoNumbers()))
                .collect(Collectors.toList());
    }
}
