package lotto.domain;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class WinningLottoTest {
    private Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private Lotto userLotto = new Lotto(List.of(1, 2, 6, 10, 23, 34));
    private WinningLotto winningLotto = new WinningLotto(winLotto);

    @ParameterizedTest
    @MethodSource("lottoAndSameNumberCountProvider")
    void checkMatchingSameNumberCount(Lotto userLotto, int answer) {
        int sameNumberCount = winningLotto.matchSameNumberCount(userLotto);

        assertThat(answer).isEqualTo(sameNumberCount);
    }

    private static Stream<Arguments> lottoAndSameNumberCountProvider() {
        return Stream.of(
                arguments(new Lotto(new ArrayList<>(List.of(1, 3, 6, 7, 44, 45))), 3),
                arguments(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 45))), 5),
                arguments(new Lotto(new ArrayList<>(List.of(11, 22, 33, 44, 15, 16))), 0));
    }

    @DisplayName("사용자의 로또에 보너스 번호가 포함되어 있는지 확인")
    @Test
    void isBonusNumContain() {
        int bonusNum = 34;
        winningLotto.setBonusLottoNum(bonusNum);
        assertThat(winningLotto.isBonusNumContain(userLotto)).isTrue();
    }

}
