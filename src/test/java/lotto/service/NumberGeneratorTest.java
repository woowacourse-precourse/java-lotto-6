package lotto.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class NumberGeneratorTest {

    private static final String ERROR_INPUT = "1000j";
    private static final String NORMAL_INPUT = "1000";

    NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @DisplayName("숫자입력으로 들어오면 숫자 변환 성공")
    @Test
    void createNumberByNumberString() {
        // given
        int expected = 1000;

        // when
        int actual = numberGenerator.createOne(NORMAL_INPUT);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("숫자가 아닌 string이 입력으로 들어오면 숫자 변환 시 에러가 발생한다")
    @Test
    void createNumberByNotNumberString() {
        // when & then
        assertThatThrownBy(() -> numberGenerator.createOne(ERROR_INPUT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("lottoCount 만큼 랜덤 리스트 생성")
    @Test
    void createRandomNumberLists() {
        // given
        int lottoCount = 8;

        // when
        List<List<Integer>> randomNumberLists = numberGenerator.createRandomNumberLists(8);
        int actual = randomNumberLists.size();

        // then
        assertThat(actual).isEqualTo(lottoCount);
    }

    @DisplayName("숫자입력 리스트가 들어오면 숫자 변환 성공")
    @Test
    void createNumbersByNormalInput() {
        // given
        String input = "1,2,3,4,5,6";
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        // when
        List<Integer> actual = numberGenerator.createNumbers(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("숫자가 아닌 string이 하나라도 섞여있으면 숫자 변환 시 에러가 발생한다")
    @Test
    void createNumbersByByNotNumberInput() {
        // given
        String errorInput = "1,2,3,4,5,6j";

        // when & then
        assertThatThrownBy(() -> numberGenerator.createNumbers(errorInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

}

