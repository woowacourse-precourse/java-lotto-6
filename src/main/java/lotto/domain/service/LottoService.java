package lotto.domain.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import lotto.domain.constant.Rank;
import lotto.domain.model.Bonus;
import lotto.domain.model.CorrectResult;
import lotto.domain.model.Lotto;
import lotto.domain.model.Winning;
import lotto.domain.util.NumberGenerator;

import static lotto.domain.constant.ErrorConst.PRICE_LESS_THAN_THOUSAND;
import static lotto.domain.constant.ErrorConst.PRICE_NOT_DIVIDED_BY_THOUSAND;
import static lotto.domain.constant.LottoConst.PRICE;
import static lotto.domain.constant.Rank.FIFTH;
import static lotto.domain.constant.Rank.FIRST;
import static lotto.domain.constant.Rank.FORTH;
import static lotto.domain.constant.Rank.SECOND;
import static lotto.domain.constant.Rank.THIRD;
import static lotto.domain.validation.Validator.checkCondition;

public class LottoService {

    private final List<Lotto> lottoStorage = new ArrayList<>();
    private Winning winning;

    private final Map<Rank, Integer> winningDetails = new LinkedHashMap<>();

    {
        winningDetails.put(FIRST, 0);
        winningDetails.put(SECOND, 0);
        winningDetails.put(THIRD, 0);
        winningDetails.put(FORTH, 0);
        winningDetails.put(FIFTH, 0);
    }

    public void buyLotteries(int price) {
        validate(price);
        int count = price / PRICE;
        for (int i = 0; i < count; i++) {
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

    public Map<Rank, Integer> getWinningDetails() {
        return winningDetails;
    }

    private void buyOneLotto() {
        Lotto lotto = new Lotto(NumberGenerator.generateLottoNumber());
        lottoStorage.add(lotto);
    }

    private void updateSameRank(CorrectResult correctResult) {
        Rank rank = getCorrectRank(correctResult);
        if (rank != null) {
            int current = winningDetails.get(rank);
            winningDetails.put(rank, ++current);
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

    private static void validate(int price) {
        checkCondition(price < PRICE,
                PRICE_LESS_THAN_THOUSAND);
        checkCondition(price % PRICE != 0,
                PRICE_NOT_DIVIDED_BY_THOUSAND);
    }

}
