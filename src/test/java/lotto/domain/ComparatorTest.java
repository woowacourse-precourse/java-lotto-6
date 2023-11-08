package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorTest {
    @ParameterizedTest
    @MethodSource("generateData")
    void compare(List<Lotto> playerLottos, Lotto winningLotto, Bonus bonus) {
        List<LottoResult> lottoResults = Comparator.compare(playerLottos, winningLotto, bonus);
        for (LottoResult lottoResult : lottoResults) {
            System.out.println();
            System.out.println(lottoResult.getReturnCash());
            System.out.println(lottoResult.getLottoCount());
            System.out.println(lottoResult.getIsBonus());
        }
    }

    static Stream<Arguments> generateData() {
        List<Lotto> playerLottos = new ArrayList<>();
        playerLottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        playerLottos.add(new Lotto(List.of(1, 7, 8, 9, 10, 11)));
        playerLottos.add(new Lotto(List.of(1, 2, 7, 8, 9, 10)));
        playerLottos.add(new Lotto(List.of(1, 2, 3, 7, 8, 9)));
        playerLottos.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        playerLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 9)));
        playerLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(45, winningLotto);

        return Stream.of(
                Arguments.of(playerLottos, winningLotto, bonus)
        );
    }
}