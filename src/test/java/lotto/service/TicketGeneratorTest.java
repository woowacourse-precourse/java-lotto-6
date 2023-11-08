package lotto.service;

import lotto.model.Lotto;
import lotto.service.lotto.generator.AutoTicketGenerator;
import org.junit.jupiter.api.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.constant.LottoConfig.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Nested
@DisplayName("자동 번호로 생성된 로또 테스트")
public class TicketGeneratorTest {
    private int startInclusive;
    private int endInclusive;
    private int count;
    private final AutoTicketGenerator autoTicketGenerator = new AutoTicketGenerator();

    @BeforeEach
    void setUp() {
        startInclusive = LOTTO_START_NUMBER.getValue();
        endInclusive = LOTTO_END_NUMBER.getValue();
        count = LOTTO_COUNT_NUMBER.getValue();
    }

    @Test
    @DisplayName("로또 번호는 정확히 6개여야 한다.")
    void test2() {
        Lotto lotto = autoTicketGenerator.createLotto();
        List<Integer> lottoNumbers = lotto.numbers();
        assertEquals(count, lottoNumbers.size());
    }

    @Test
    @DisplayName("모든 로또 번호는 1과 45 사이의 값이어야 한다.")
    void test3() {
        Lotto lotto = autoTicketGenerator.createLotto();
        List<Integer> lottoNumbers = lotto.numbers();
        assertTrue(lottoNumbers.stream()
                .allMatch(n -> n >= startInclusive && n <= endInclusive));
    }

    @RepeatedTest(100)
    @DisplayName("로또 번호에 중복된 값이 없어야 한다.")
    void test4() {
        Lotto lotto = autoTicketGenerator.createLotto();
        List<Integer> lottoNumbers = lotto.numbers();
        assertTrue(lottoNumbers.stream()
                .filter(n -> Collections.frequency(lottoNumbers, n) > 1)
                .collect(Collectors.toSet())
                .isEmpty());
    }

    @Test
    @DisplayName("발행된 번호는 오름차순으로 정렬하여 저장한다.")
    void test5() {
        Lotto lotto = autoTicketGenerator.createLotto();
        List<Integer> lottoNumbers = lotto.numbers();
        assertTrue(IntStream.range(0, lottoNumbers.size() - 1)
                .allMatch(i -> lottoNumbers.get(i) < lottoNumbers.get(i + 1)));
    }
}
