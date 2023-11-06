package lotto.domain.service;

import lotto.domain.model.CorrectResult;
import lotto.domain.constant.Rank;
import lotto.domain.model.Bonus;
import lotto.domain.model.Lotto;
import lotto.domain.model.Winning;
import lotto.domain.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import static lotto.domain.constant.ErrorConst.PRICE_LESS_THAN_THOUSAND;
import static lotto.domain.constant.ErrorConst.PRICE_NOT_DIVIDED_BY_THOUSAND;
import static lotto.domain.constant.LottoConst.PRICE;
import static lotto.domain.constant.Rank.FIFTH;
import static lotto.domain.constant.Rank.FIRST;
import static lotto.domain.constant.Rank.FORTH;
import static lotto.domain.constant.Rank.SECOND;
import static lotto.domain.constant.Rank.THIRD;

public class LottoService {

    private final List<Lotto> lottoStorage = new ArrayList<>();
    private Winning winning;

    private final Map<Rank, Integer> winningDetails
            = Map.of(
            FIRST, 0,
            SECOND, 0,
            THIRD, 0,
            FORTH, 0,
            FIFTH, 0);

    public void buyLotteries(long price) {
        validate(price);
        long count = price / PRICE;
        for (long i = 0; i < count; i++) {
            buyOneLotto();
        }
    }

    public void generateWinning(Lotto main, Bonus bonus) {
        winning = new Winning(main, bonus);
    }

    public void rank() {
        for (Lotto lotto : lottoStorage) {
            CorrectResult correctResult = winning.countSameNumber(lotto);
            updateSameRank(correctResult);
        }
    }

    public double calculateReturn() {
        AtomicLong profit = new AtomicLong(0l);
        long consumption = (long) lottoStorage.size() * PRICE;

        winningDetails.forEach(((rank, count) -> {
            profit.addAndGet((long) rank.getReward() * count);
        }));

        return (profit.doubleValue() / consumption) * 100;
    }

    public List<Lotto> getLottoStorage() {
        return lottoStorage;
    }

    private void buyOneLotto() {
        Lotto lotto = new Lotto(NumberGenerator.generateLottoNumber());
        lottoStorage.add(lotto);
    }

    private void updateSameRank(CorrectResult correctResult) {
        Rank rank = getCorrectRank(correctResult);
        if (rank != null) {
            int current = winningDetails.get(rank);
            winningDetails.put(rank, current++);
        }
    }

    private Rank getCorrectRank(CorrectResult correctResult) {
        for (Rank rank : Rank.values()) {
            if (correctResult.compare(rank)) {
                return rank;
            }
        }
        return null;
    }

    //TODO: validateMoreThanThousand 등을 인터페이스, 람다식 등을 이용해 변경
    //      그러면 하위 메서드를 계속 정의할 필요가 없을듯
    private static void validate(long price) {
        validateMoreThanThousand(price);
        validateMultipleOfThousand(price);
    }

    private static void validateMultipleOfThousand(long price) {
        if (price % PRICE != 0) {
            throw new IllegalArgumentException(PRICE_NOT_DIVIDED_BY_THOUSAND);
        }
    }

    private static void validateMoreThanThousand(long price) {
        if (price < PRICE) {
            throw new IllegalArgumentException(PRICE_LESS_THAN_THOUSAND);
        }
    }

}
