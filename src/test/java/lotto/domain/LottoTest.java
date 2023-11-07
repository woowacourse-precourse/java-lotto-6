package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.util.IntegerListUtil;
import lotto.util.StringUtil;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    public void 정수리스트_입력받아_정상_로또생성() {
        // Given
        List<Integer> numbers = List.of(1,2,3,4,5,6);

        // When
        Lotto lotto = new Lotto(numbers);

        // Then
        numbers.stream()
                .forEach(number -> assertTrue(lotto.doesContain(number)));
    }


    @Test
    public void 문자를_콤마를_기준으로_분리하여_정상_로또생성() {
        // Given
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        String unrefinedNumbers = "1,2,3,4,5,6";

        // When
        Lotto lotto = Lotto.create(unrefinedNumbers);

        // Then
        numbers.stream()
                .forEach(number -> assertTrue(lotto.doesContain(number)));
    }

    @Test
    public void 문자로_로또생성시_불필요한_콤마제거() {
        // Given
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        String unrefinedNumbers = ",1,2,3,,,4,5,,6,,";

        // When
        Lotto lotto = Lotto.create(unrefinedNumbers);

        // Then
        numbers.stream()
                .forEach(number -> assertTrue(lotto.doesContain(number)));
    }

    @Test
    public void 문자로_로또생성시_불필요한_공백제거() {
        // Given
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        String unrefinedNumbers = " 1, 2, 3  , 4, 5, 6 ";

        // When
        Lotto lotto = Lotto.create(unrefinedNumbers);

        // Then
        numbers.stream()
                .forEach(number -> assertTrue(lotto.doesContain(number)));
    }

    @Test
    public void 로또에_값이_들어있는지() {
        // Given
        Lotto lotto = Lotto.create("1,2,3,4,5,6");

        // When
        boolean resultTrue = lotto.doesContain(1);
        boolean resultFalse = lotto.doesContain(7);

        // Then
        assertTrue(resultTrue);
        assertFalse(resultFalse);
    }

    @Test
    public void 중복되는_숫자가있으면_예외처리() {
        // Given
        String unrefinedNumbers = "1,2,3,4,5,5";

        // When && Then
        assertThatThrownBy(() -> Lotto.create(unrefinedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 값은 입력할 수 없습니다.");
    }

    @Test
    public void 로또의_숫자개수가_6보다작으면_예외처리() {
        // Given
        String unrefinedNumbers = "1,2,3,4,5";

        // When && Then
        assertThatThrownBy(() -> Lotto.create(unrefinedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정해진 개수의 숫자를 입력하세요.");
    }

    @Test
    public void 로또의_숫자개수가_6보다많으면_예외처리() {
        // Given
        String unrefinedNumbers = "1,2,3,4,5,6,7";

        // When && Then
        assertThatThrownBy(() -> Lotto.create(unrefinedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정해진 개수의 숫자를 입력하세요.");
    }

    @Test
    public void 로또에_1이상_45이하가아닌_숫자가있다면_예외처리() {
        // Given
        String unrefinedNumbers = "1,2,3,4,5,46";

        // When && Then
        assertThatThrownBy(() -> Lotto.create(unrefinedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정해진 범위의 숫자를 입력하세요.");
    }

    @Test
    public void 리스트형식으로_로또_출력() {
        // Given
        Lotto lotto = Lotto.create("1,2,3,4,5,6");

        // When
        String result = lotto.toString();

        // Then
        assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
