package lotto.util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Application;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultModuleTest extends NsTest {
    private final List<Integer> LOTTO_NUM = List.of(1, 2, 3, 4, 5, 6);
    private final Integer BONUS_NUM = 7;

    private final Integer FIFTH_PLACE = 0;
    private final Integer FOURTH_PLACE = 1;
    private final Integer THIRD_PLACE = 2;
    private final Integer SECOND_PLACE = 3;
    private final Integer FIRST_PLACE = 4;

    private List<Integer> result;

    @BeforeEach
    void setUp() {
        result = new ArrayList<>(
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        );
    }

    @DisplayName("로또 번호가 3개 당첨되었을 때")
    @Test
    void getThirdPlace() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));

        //when
        ResultModule.checkResult(result, lotto, LOTTO_NUM, BONUS_NUM);
        ResultModule.formattingResult(result);
        System.out.println(result);

        //then
        assertSimpleTest(() ->
                assertEquals(1, result.get(FIFTH_PLACE))
        );
    }

    @DisplayName("[5등] 로또 번호가 3개 당첨되었을 때")
    @Test
    void getFifthPlace() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));

        //when
        ResultModule.checkResult(result, lotto, LOTTO_NUM, BONUS_NUM);
        ResultModule.formattingResult(result);

        //then
        assertSimpleTest(() ->
                assertEquals(1, result.get(FIFTH_PLACE))
        );
    }

    @DisplayName("[4등] 로또 번호가 4개 당첨되었을 때")
    @Test
    void getFourthPlace() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 9, 10));

        //when
        ResultModule.checkResult(result, lotto, LOTTO_NUM, BONUS_NUM);
        ResultModule.formattingResult(result);

        //then
        assertSimpleTest(() ->
                assertEquals(1, result.get(FOURTH_PLACE))
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
