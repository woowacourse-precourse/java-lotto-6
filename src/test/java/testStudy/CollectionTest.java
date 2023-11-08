package testStudy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set 크기 확인 테스트")
    public void setSizeTest() {
        //given
        int resultSize = 3;
        //when
        int result = numbers.size();
        //then
        assertThat(result).isEqualTo(resultSize);
    }

    @ParameterizedTest
    @DisplayName("Set Parameterized 확인 테스트")
    @ValueSource(ints = {1, 2, 3})
    public void setParamterzedTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Set CsvSource 확인 테스트")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void setCsvSourceTest(int num, boolean result) {
        assertThat(numbers.contains(num)).isEqualTo(result);
    }
}
