package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class WinningLottoTest {

    WinningLotto winningLotto;
    @BeforeEach
    void init(){
        winningLotto = WinningLotto.of(List.of(1,2,3,4,5,6), 7);
    }

    @Test
    @DisplayName("번호_확인_테스트")
    void contains() {
        List<Integer> testList = List.of(1,2,3,4,5,6,7);
        Assertions.assertTrue(
                testList.stream()
                        .allMatch(winningLotto::contains)
        );
    }

    @Test
    @DisplayName("보너스_번호_테스트")
    void isBonusNumber() {
        Assertions.assertTrue(winningLotto.isBonusNumber(7));
    }
}