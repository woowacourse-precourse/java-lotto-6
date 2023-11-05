package lotto.domain;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class WinningLottoTest {
    private Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private WinningLotto winningLotto = new WinningLotto(winLotto);

    @ParameterizedTest
    @MethodSource("lottoAndSameNumberNumProvider")
    void checkMatchingSameNumberNum(Lotto userLotto, int answer) {
        int sameNumberNum = winLotto.matchSameNumberNum(userLotto);

        assertThat(answer).isEqualTo(sameNumberNum);
    }

    private static Stream<Arguments> lottoAndSameNumberNumProvider() {
        return Stream.of(
                arguments(new Lotto(new ArrayList<>(List.of(1, 3, 6, 7, 44, 45))), 3),
                arguments(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 45))), 5),
                arguments(new Lotto(new ArrayList<>(List.of(11, 22, 33, 44, 15, 16))), 0));
    }

}
