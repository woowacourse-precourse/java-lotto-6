package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetCollectionTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 크기를 확인 테스트")
    @Test
    void setSeize_Test() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set에 특정 값이 존재하는지 확인 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void setContains_Test(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @DisplayName("Set에 특정 값의 존재 유무에 따라 boolean값 반환 확인 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void setContains_boolean_Test(int value, boolean result) {
        assertThat(numbers.contains(value)).isEqualTo(result);
    }
}
