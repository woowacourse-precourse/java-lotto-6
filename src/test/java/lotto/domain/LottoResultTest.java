package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    private LottoBundle lottoBundle;
    private WinningNumber winningNumber;

    @BeforeEach
    void setUp() {
        List<Lotto> lottos = IntStream.rangeClosed(1, 3)
                .mapToObj(i -> new Lotto(IntStream
                        .rangeClosed(i, i + 5)
                        .boxed()
                        .toList()))
                .toList();
        lottoBundle = LottoBundle.from(lottos);
        winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), BonusNumber.of(7));
    }

    @DisplayName("구매한 로또 목록과 당첨번호를 가진 로또결과 객체를 생성한다.")
    @Test
    void createLottoResult() {
        LottoResult lottoResult = LottoResult.of(lottoBundle, winningNumber);

        assertThat(lottoResult.countRank(Rank.FIRST_PRIZE)).isEqualTo(1);
        assertThat(lottoResult.countRank(Rank.SECOND_PRIZE)).isEqualTo(1);
        assertThat(lottoResult.countRank(Rank.FOURTH_PRIZE)).isEqualTo(1);
    }

    @DisplayName("당첨된 상금의 총합을 계산한다.")
    @Test
    void calculatePriceTest() {
        LottoResult lottoResult = LottoResult.of(lottoBundle, winningNumber);
        long prize = lottoResult.calculatePrize();

        assertThat(prize).isEqualTo(2030050000);
    }

    @DisplayName("등수 별로 당첨 갯수를 출력한다.")
    @Test
    void countRankTest() {
        LottoResult lottoResult = LottoResult.of(lottoBundle, winningNumber);

        assertThat(lottoResult.countRank(Rank.FIRST_PRIZE)).isEqualTo(1);
        assertThat(lottoResult.countRank(Rank.SECOND_PRIZE)).isEqualTo(1);
        assertThat(lottoResult.countRank(Rank.FOURTH_PRIZE)).isEqualTo(1);
    }
}