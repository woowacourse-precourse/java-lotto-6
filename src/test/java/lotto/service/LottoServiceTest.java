package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

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

}