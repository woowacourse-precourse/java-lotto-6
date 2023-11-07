package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoPaperTest {
    private List<Integer> lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또 용지 생성 확인 - 6개 번호로 구성된 용지")
    @ParameterizedTest(name = "로또 번호 '{11, 12, 13, 14, 15, 16}'로 구성된 용지")
    @CsvSource(value = {"6"})
    public void 로또_용지_생성(int expectedLottoSize) {
        // given
        lottoNumbers = Arrays.asList(11, 12, 13, 14, 15, 16);
        LottoPaper lottoPaper = new LottoPaper(lottoNumbers);

        // when
        List<Integer> lottoPaperNumbers = lottoPaper.getLottoNumbers();

        // then
        assertAll(
                "로또 용지 크기와 번호 확인",
                () -> assertThat(lottoPaperNumbers.size()).isEqualTo(expectedLottoSize),
                () -> assertEquals(lottoPaperNumbers ,lottoNumbers),
                () -> assertThat(lottoPaperNumbers).containsExactly(11, 12, 13, 14, 15, 16)
        );
    }


    @DisplayName("로또 번호 '{1, 2, 3, 4, 5, 6}'에 대한 매칭값 설정 확인")
    @ParameterizedTest(name = "초기 설정 값: {0}, 매칭 값: {1}")
    @CsvSource(value = {"0:3", "0:4", "0:5", "0:6"}, delimiter = ':')
    public void 로또_용지_매칭_값_설정(int initialMatchingCount, int testMatchingCount) {
        // given
        LottoPaper lottoPaper = new LottoPaper(lottoNumbers);

        // when
        int beforeMatchingCount = lottoPaper.getMatchingCount();
        lottoPaper.setMatchingCount(testMatchingCount);
        int afterMatchingCount = lottoPaper.getMatchingCount();

        // then
        assertAll(
                "로또 용지 초기 매칭 값과 매칭 값 설정 이후 값 확인",
                () -> assertThat(beforeMatchingCount).isEqualTo(initialMatchingCount),
                () -> assertThat(afterMatchingCount).isEqualTo(testMatchingCount),
                () -> assertThat(afterMatchingCount).isGreaterThan(beforeMatchingCount)
        );
    }

    @DisplayName("로또 용지 번호 '{1,2,3,4,5,6}'에 대해 보너스 번호가 존재하는지 확인")
    @ParameterizedTest(name = "보너스 번호가 {0} 일 때 {1}")
    @CsvSource(value = {"5:true", "6:true", "7:false", "8:false"}, delimiter = ':')
    public void 로또_용지_보너스_번호_확인(int bonusNumber, boolean expectedResult) {
        // given
        LottoPaper lottoPaper = new LottoPaper(lottoNumbers);

        // when
        boolean actualResult = lottoPaper.hasBonusNumber(bonusNumber);

        // then
        assertEquals(expectedResult, actualResult);
    }
}