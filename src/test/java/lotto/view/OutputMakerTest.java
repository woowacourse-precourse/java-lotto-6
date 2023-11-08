package lotto.view;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


class OutputMakerTest {

    @DisplayName("로또 출력 서식")
    @Test
    void 로또결과출력_TEST() {
        OutputMaker om = new OutputMaker();
        Lotto newLotto = new Lotto(List.of(3,2,1,6,5,4));
        String result = om.printLotto(newLotto);
        String expect = "[1, 2, 3, 4, 5, 6]";
        assertThat(result).isEqualTo(expect);
    }
}