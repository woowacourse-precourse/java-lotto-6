package lotto;

import controller.LottoGenerator;
import model.Lotto;
import model.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CreateLottoTest {

    private Lottos lottos = new Lottos();
    @BeforeEach
    void setUp(){
        lottos.initLottos(LottoGenerator.createLottos(6));
    }
    @Test
    void 로또생성(){
        int result = lottos.getLottos().size();
        System.out.println(result);
        assertThat(result).isEqualTo(6);
    }
}
