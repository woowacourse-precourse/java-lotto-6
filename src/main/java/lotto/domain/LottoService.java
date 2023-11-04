package lotto.domain;

import lotto.domain.constant.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public void buyLottos(int price) {
        validate(price);
        int count = price / PRICE;
        for (int i = 0; i < count; i++) {
            buyOneLotto();
        }
    }

    public void generateWinning(Lotto winningNumber, Bonus bonusNumber) {
        winning = new Winning(winningNumber, bonusNumber);
    }

    public void rank() {
        for (Lotto lotto : lottoStorage) {
            CorrectResult correctResult = winning.countSameNumber(lotto);
            updateSameRank(correctResult);
        }
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
    private static void validate(int price) {
        validateMoreThanThousand(price);
        validateMultipleOfThousand(price);
    }

    private static void validateMultipleOfThousand(int price) {
        if (price % PRICE != 0) {
            throw new IllegalArgumentException(PRICE_NOT_DIVIDED_BY_THOUSAND);
        }
    }

    private static void validateMoreThanThousand(int price) {
        if (price < PRICE) {
            throw new IllegalArgumentException(PRICE_LESS_THAN_THOUSAND);
        }
    }

}
