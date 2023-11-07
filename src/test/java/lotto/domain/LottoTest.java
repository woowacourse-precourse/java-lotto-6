package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
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


}
