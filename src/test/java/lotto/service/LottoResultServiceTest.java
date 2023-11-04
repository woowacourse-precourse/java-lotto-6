package lotto.service;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LottoResultServiceTest {

    private LottoService lottoService;
    private LottoResultService lottoResultService;

    @BeforeEach
    void setUp() {
        this.lottoService = new LottoService();
        this.lottoResultService = new LottoResultService();
    }

    @DisplayName("생성된 로또 번호와 당첨 로또 번호를 비교하는지")
    @ParameterizedTest
    @CsvSource({"1, 7", "2, 8", "3, 9"})
    void countMatchingNumbersTest(Integer lottoCount, Integer bonusNumber) {
        // given
        List<Integer> randomNumbers = lottoService.createRandomNumbers();
        PurchasedLotto purchasedLotto = new PurchasedLotto();

        IntStream.range(0, lottoCount)
                .forEach(i -> purchasedLotto.addLotto(new Lotto(randomNumbers)));

        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6), new BonusNumber(bonusNumber));

        // when
        List<LottoResult> lottoResult = lottoResultService.countMatchingNumbers(purchasedLotto, winningLotto);

        // then

    }
}