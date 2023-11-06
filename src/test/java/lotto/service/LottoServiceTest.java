package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void beforeEach() {
        this.lottoService = new LottoService();
    }

    @Test
    @DisplayName("기능10 테스트 : generateLottoCombination는 1~45까지의 숫자 중 6개의 숫자를 생성한다.")
    void generatedLottoCombinationContainsSixNumberAndEachNumberIsInRangeBetweenOneAndFortyFive() {
        // when
        List<Integer> result = lottoService.generateLottoCombination();

        // then
        assertThat(result)
                .hasSize(6)
                .allMatch(number -> number >= 1 && number <= 45);
    }

    @Test
    @DisplayName("기능10 테스트 : generateLottoCombination로 생성된 숫자 리스트에는 중복된 값이 없다.")
    void generatedLottoCombinationDoNotHaveDuplicates() {
        // when
        List<Integer> result = lottoService.generateLottoCombination();

        // then
        assertThat(result)
                .doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("기능10 테스트 : generateLottoCombination로 생성된 숫자 리스트는 오름차순으로 정리되어 있다.")
    void generatedLottoCombinationShouldSortedByAscending() {
        // when
        List<Integer> result = lottoService.generateLottoCombination();

        // then
        assertThat(result)
                .isSorted();
    }

    @Test
    @DisplayName("기능9 테스트 : generateLotto 메서드가 Lotto 객체를 예외를 발생시키지 않고 Lotto 객체를 생성한다.")
    void generateLottoShouldReturnLottoInstanceWithOutException() {
        // when, then
        assertThatCode(() -> lottoService.generateLotto())
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("기능8 테스트 : generateLottoList 메서드가 지정된 개수만큼 Lotto 객체를 담은 리스트를 반환한다.")
    void generateLottoListMakeLottoAsManyAsCount() {
        // given
        int count = 5;

        // when
        List<Lotto> lottoList = lottoService.generateLottoList(5);

        // then
        assertThat(lottoList).hasSize(count);
    }
}