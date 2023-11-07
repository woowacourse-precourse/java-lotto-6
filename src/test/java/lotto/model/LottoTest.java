package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    private Lotto lotto;

    @BeforeEach
    public void setUp() {

    }

    boolean isSame(List<Integer> list1, List<Integer> list2) {
        for (int i = 0; i < list1.size(); i++) {
            
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    @DisplayName("로또 번호 오름차순으로 정렬")
    @Test
    void sort() {
        lotto = new Lotto(Arrays.asList(11, 22, 1, 4, 13, 30));
        List<Integer> list1 = lotto.getNumbers();
        List<Integer> list2 = Arrays.asList(1, 4, 11, 13, 22, 30);
        boolean isSameOrder;

        isSameOrder = isSame(list1, list2);
        assertThat(isSameOrder).isEqualTo(true);
    }
}