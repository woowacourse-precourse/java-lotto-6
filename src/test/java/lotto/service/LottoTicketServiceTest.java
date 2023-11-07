package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoPurchaseAmount;
import lotto.model.LottoTicketCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.constant.LottoConfig.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketServiceTest {
    private LottoTicketService lottoTicketService;
    private int startInclusive;
    private int endInclusive;
    private int count;

    @BeforeEach
    void setUp() {
        lottoTicketService = new LottoTicketService();
        startInclusive = LOTTO_START_NUMBER.getValue();
        endInclusive = LOTTO_END_NUMBER.getValue();
        count = LOTTO_COUNT_NUMBER.getValue();
    }

    @Test
    @DisplayName("구입 금액에 따라 구매한 로또 계수를 계산 한다.")
    void convertMoneyToTickets() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(9000);
        LottoTicketCount lottoTicketCount = lottoTicketService.calculateTicketCount(lottoPurchaseAmount);
        assertThat(lottoTicketCount.getCount()).isEqualTo(9);
    }

    @RepeatedTest(1000)
    @DisplayName("각 로또 번호는 1부터 45 사이의 숫자 중 중복되지 않는 6개로 구성 한다.")
    void generateNoDuplicationLottoNumbers() {
        Lotto lotto = lottoTicketService.createLotto();
        List<Integer> lottoNumbers = lotto.getNumbers();

        // 로또 번호는 정확히 6개여야 한다.
        assertEquals(count, lottoNumbers.size());

        // 모든 로또 번호는 1과 45 사이의 값이어야 한다.
        assertTrue(lottoNumbers.stream()
                .allMatch(n -> n >= startInclusive && n <= endInclusive));

        // 로또 번호에 중복된 값이 없어야 한다.
        assertTrue(lottoNumbers.stream()
                .filter(n -> Collections.frequency(lottoNumbers, n) > 1)
                .collect(Collectors.toSet())
                .isEmpty());
    }

    @Test
    @DisplayName("발행된 번호는 오름차순으로 정렬하여 저장한다.")
    void generateAscendingLottoNumbers(){
        Lotto lotto = lottoTicketService.createLotto();
        List<Integer> lottoNumbers = lotto.getNumbers();

        assertTrue(IntStream.range(0,lottoNumbers.size()-1)
                .allMatch(i->lottoNumbers.get(i)<lottoNumbers.get(i+1)));
    }
}