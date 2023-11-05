package lotto.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_STAT_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;

    private LottoMachine lottoMachine;

    @BeforeEach
    void init() {
        lottoMachine = new LottoMachine(LOTTO_STAT_NUMBER, LOTTO_END_NUMBER, LOTTO_COUNT);
    }

    @DisplayName("구입 금액과 로또 금액에 맞는 로또 개수가 출력 되어야 한다.")
    @Test
    void 로또_생성_테스트() {
        int amount = 10000;
        List<Lotto> lottoList = lottoMachine.getLottoList(LOTTO_PRICE, amount);
        assertThat(lottoList.size()).isEqualTo(10);
    }

    @DisplayName("로또 번호는 중복 되지 않아야 한다.")
    @Test
    void 로또_생성_중복_검증_테스트() {
        int amount = 10000;
        List<Lotto> lottoList = lottoMachine.getLottoList(LOTTO_PRICE, amount);
        lottoList.forEach(l -> {
            List<Integer> numbers = l.getNumbers();
            List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
            assertThat(numbers.size()).isEqualTo(distinctNumbers.size());
        });
    }

    @DisplayName("로또 번호는 입력된 범위 내에 있어야 한다.")
    @Test
    void 로또_생성_범위_검증_테스트() {
        int amount = 10000;
        List<Lotto> lottoList = lottoMachine.getLottoList(LOTTO_PRICE, amount);
        lottoList.forEach(l -> {
            boolean allMatch = l.getNumbers().stream()
                    .allMatch(num -> num >= LOTTO_STAT_NUMBER && num <= LOTTO_END_NUMBER);
            assertThat(allMatch).isTrue();
        });
    }

    @DisplayName("로또 번호는 오름차순으로 정렬 되어야 한다.")
    @Test
    void 로또_생성_오름차순_검증_테스트() {
        int amount = 10000;
        List<Lotto> lottoList = lottoMachine.getLottoList(LOTTO_PRICE, amount);
        lottoList.forEach(l -> {
            List<Integer> numbers = l.getNumbers();
            assertThat(isLottoSorted(numbers)).isTrue();
        });
    }


    private boolean isLottoSorted(List<Integer> numbers) {
        int intValue = 0;
        for (int number : numbers) {
            if (number < intValue) {
                return false;
            }
            intValue = number;
        }
        return true;
    }

}