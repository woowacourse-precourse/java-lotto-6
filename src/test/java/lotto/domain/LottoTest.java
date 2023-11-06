package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Lotto 테스트")
class LottoTest {

    @DisplayName("생성자 테스트")
    @Nested
    class constructor {

        @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
        @Test
        void createLottoByOverSize() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        @Test
        void createLottoByDuplicatedNumber() {
            // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
    
    @DisplayName("toString 테스트")
    @Nested
    class toString {

        @DisplayName("입력한 로또 번호가 정렬되어서 출력되어야 한다.")
        @Test
        void printLottoWithUnsortedIntegers() {

            List<Integer> numbers = new ArrayList<>(List.of(6,5,4,3,2,1));
            Lotto lotto = new Lotto(numbers);

            String string = lotto.toString();
            String expect = List.of(1,2,3,4,5,6).toString();

            assertEquals(string, expect);

        }

    }

}