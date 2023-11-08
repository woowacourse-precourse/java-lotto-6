package lotto.domain;


import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GeneratorTest {

    @DisplayName("구입한 로또 개수만큼 로또가 생성되는지 확인")
    @Test
    void generateLotto() {
        //given, when
        List<Integer> lottoCount = new ArrayList<>();
        for (int i = 1; i < 50; i++) {
            lottoCount.add(i);
        }

        //then
        for (Integer count : lottoCount) {
            assertSimpleTest(() ->
                    assertEquals(count, Generator.generateLotto(count).size())
            );
        }
    }
}
