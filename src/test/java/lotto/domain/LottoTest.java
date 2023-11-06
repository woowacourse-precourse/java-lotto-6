package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @DisplayName("로또를 생성할때 값이 유효한지 검증한다. 유효하지 않으면 exception을 발생시킨다")
    @Test
    void generateLotto() {
        Assertions.assertAll(
                () -> Assertions.assertDoesNotThrow(
                        () -> new Lotto(List.of(8, 21, 23, 41, 42, 43))),
                () -> Assertions.assertThrows(IllegalArgumentException.class,
                        () -> new Lotto(List.of(8, 21, 23, 41, 42, 46))),
                () -> Assertions.assertThrows(IllegalArgumentException.class,
                        () -> new Lotto(List.of(8, 21, 23, 41, 42, 43, 41))),
                () -> Assertions.assertThrows(IllegalArgumentException.class,
                        () -> new Lotto(List.of(8, 21, 23, 41, 42, 42))),
                () -> Assertions.assertThrows(IllegalArgumentException.class,
                        () -> new Lotto(List.of(8, 21, 23, 41, 42)))
        );
    }

    @DisplayName("불변 Collection을 반환한다.")
    @Test
    void getLotto(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        List<Integer> copyLotto = lotto.getNumbers();

        Assertions.assertThrows(UnsupportedOperationException.class, ()-> copyLotto.add(1));
    }
}
