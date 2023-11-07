package lotto.controller;

import lotto.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WinningCountMachineTest {
    private WinningCountMachine winningCountMachine = new WinningCountMachine();


    @Test
    void testMakeWinningDetail() {
        // given
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),

                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),

                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),

                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),

                new Lotto(List.of(1, 2, 3, 9, 8, 7)),
                new Lotto(List.of(1, 2, 3, 9, 8, 7)),

                new Lotto(List.of(1, 2, 10, 9, 8, 7))
        );
        MyLotto myLotto = new MyLotto(lottos);
        // when
        WinningDetail winningDetail = winningCountMachine.maketWinningDetail(winningLotto, myLotto);
        // then
        List<Integer> counts = winningDetail.getCountOfCorrectLottos().stream()
                .map(CountOfCorrectLotto::getCount).collect(Collectors.toList());
        assertEquals(List.of(2, 3, 4, 5, 6), counts);
    }
}
