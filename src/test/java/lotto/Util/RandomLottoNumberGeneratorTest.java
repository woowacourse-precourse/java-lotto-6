package lotto.Util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("RandomLottoNumberGenerator 클래스 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RandomLottoNumberGeneratorTest {
    private List<Integer> list;

    @BeforeEach
    void setUp() {
        list = RandomLottoNumberGenerator.makeNumber();
    }

    @Test
    void 번호_6개가_반환된다() {
        assertEquals(6, list.size());
    }

    @Test
    void 중복되는_번호가_없어야한다() {
        List<Integer> distinctNumbers = list.stream().distinct().toList();

        assertEquals(list.size(), distinctNumbers.size());
    }

    @Test
    void 오름차순으로_정렬되어있다() {
        List<Integer> sortedNumbers = list.stream().sorted().toList();
        assertEquals(sortedNumbers, list);
    }
}
