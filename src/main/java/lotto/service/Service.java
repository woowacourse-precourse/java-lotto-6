package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.domain.Buyer;
import lotto.domain.GameNumbers;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.util.Util;

public class Service {
    private static final int LOTTO_FIRST_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int EXCEPT_NO_RANK = 3;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int PURCHASE_AMOUNT_UNIT = 1000;

    private Service() {
    }

    public static void buyLotteries(Buyer buyer) {
        int count = buyer.getPurchaseAmount() / PURCHASE_AMOUNT_UNIT;
        for (int i = ZERO; i < count; i++) {
            buyOneLotto(buyer);
        }
    }

    private static void buyOneLotto(Buyer buyer) {
        Lotto lotto = createLottoNumber();
        buyer.buyLotto(lotto);
    }

    private static Lotto createLottoNumber() {
        List<Integer> numbers = Util.sortListAscending(Util.createRandomNumberList(Service.LOTTO_FIRST_NUMBER,
                Service.LOTTO_LAST_NUMBER, Service.LOTTO_SIZE));
        return new Lotto(numbers);
    }

    public static void resultLotteries(Buyer buyer, GameNumbers gameNumbers) {
        Map<Rank, Integer> result = buyer.getResultRank();
        for (Lotto lotto : buyer.getPurchasedLotto()) {
            Rank rank = decideRank(gameNumbers, lotto);
            result.put(rank, result.getOrDefault(rank, ZERO) + ONE);
        }
    }

    private static Rank decideRank(GameNumbers gameNumbers, Lotto lotto) {
        int countWinningNumbers = countWinningNumbersInLotto(gameNumbers, lotto);
        boolean containBonusNumber = containBonusNumberInLotto(gameNumbers, lotto);

        if (countWinningNumbers < EXCEPT_NO_RANK) {
            return null;
        }

        Rank rank = Rank.values()[countWinningNumbers - EXCEPT_NO_RANK];

        if (rank == Rank.THIRD && containBonusNumber) {
            return Rank.SECOND;
        }

        return rank;
    }

    private static int countWinningNumbersInLotto(GameNumbers gamenumbers, Lotto lotto) {
        return Util.countContainNumbers(gamenumbers.getWinningNumbers(), lotto.getNumbers());
    }

    private static boolean containBonusNumberInLotto(GameNumbers gameNumbers, Lotto lotto) {
        return Util.checkContainNumber(lotto.getNumbers(), gameNumbers.getBonusNumber());
    }
}