package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PrintTest extends Print{

    @Test
    void 오름차순_정렬() {

        //given
        Lotto lotto = new Lotto(List.of(42, 23, 8, 21, 43, 30));

        //when
        List<Integer> result = sort(lotto);

        //then
        System.out.println();
        Assertions.assertThat(result).containsExactly(8, 21, 23, 30, 42, 43);
    }
}
