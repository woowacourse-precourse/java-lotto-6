package lotto.domain;

import lotto.domain.constant.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lotto.domain.constant.ErrorConst.PRICE_LESS_THAN_THOUSAND;
import static lotto.domain.constant.ErrorConst.PRICE_NOT_DIVIDED_BY_THOUSAND;
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
        int count = price / 1000;
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

    //TODO: 이것도 15줄 넘는데 어떻게 줄이면 좋을지 생각.
    private Rank getCorrectRank(CorrectResult correctResult) {
        if (correctResult.sameThree()) {
            return FIFTH;
        }
        if (correctResult.sameFour()) {
            return FORTH;
        }
        if (correctResult.sameFiveNotBonus()) {
            return THIRD;
        }
        if (correctResult.sameFiveBonus()) {
            return SECOND;
        }
        if (correctResult.sameSix()) {
            return FIRST;
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
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(PRICE_NOT_DIVIDED_BY_THOUSAND);
        }
    }

    private static void validateMoreThanThousand(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException(PRICE_LESS_THAN_THOUSAND);
        }
    }

}
