package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottiesTest {
    @DisplayName("Lotto List 를 반환할 땐 unmodifiedList 를 반환")
    @Test
    public void returnLottoListAsUnmodifiable(){
        Lotties lotties = new Lotties(List.of(new Lotto(List.of(1,2,3,4,5,6))));
        List<Lotto> valueLotto = lotties.getLotties();
        assertThatThrownBy(
                ()-> valueLotto.add(new Lotto(List.of(1,2,3,4,5,6)))
        ).isInstanceOf(UnsupportedOperationException.class);
    }
}