package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        numbers.add(1); // Set은 중복값 add 하지 않음
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set의 사이즈 구하는 테스트")
    void getSetSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

//    @Test  ---> Test 추가하면 오류 발생
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void 특정_숫자가_Set에_포함_되어_있는지_테스트(int input) {
        assertTrue(numbers.contains(input));
    }

    @ParameterizedTest
    @DisplayName("특정 숫자 Set에 포함 여부 다양한 케이스 테스트")
    @CsvSource(value = {"1?true", "4?false"}, delimiter = '?')
    void specificNumberContainInSetTest(int input, boolean expect) {
        assertEquals(numbers.contains(input), expect);
    }
}
