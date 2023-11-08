package lotto.service;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoMachineTest {
    private LottoMachine machine = new LottoMachine();
    @Test
    @DisplayName("정상적인 번호 리스트를 주는지 테스트")
    void 정상적인번호리스트를주는지테스트() throws Exception {
        //given
        int money = 5000;
        //when
        List<Lotto> lottos = machine.roulette(money);

        //then
        for (Lotto lotto : lottos) {
            assertTrue(isNotDuplicate(lotto.getNumbers()));
        }
    }
    @Test
    @DisplayName("번호 리스트 정렬 테스트")
    void 번호리스트정렬_테스트() throws Exception {
        //given
        int money = 5000;
        //when
        List<Lotto> lottos = machine.roulette(money);

        //then
        for (Lotto lotto : lottos) {
            assertTrue(isSorted(lotto.getNumbers()));
        }
    }

    private static boolean isNotDuplicate(List<Integer> numbers) {
        HashSet<Integer> check = new HashSet<>(numbers);
        return check.size() == numbers.size();
    }
    private boolean isSorted(List<Integer> numbers) {
        return IntStream.range(0, numbers.size() - 1)
                .allMatch(i -> numbers.get(i) <= numbers.get(i + 1));
    }
}