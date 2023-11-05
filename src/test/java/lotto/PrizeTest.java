package lotto;

import lotto.Logic.Prize;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.Logic.Prize.first;
import static lotto.Logic.Prize.sixth;

public class PrizeTest {
    List<Integer> checkFirst;

    @BeforeEach
    public void setUp(){
        checkFirst=List.of(6,0); // first 상수의 속성
    }

    @Test
    public void 생성자_동작_정상(){
        Assertions.assertEquals(first.getJudge(), checkFirst);

        Assertions.assertEquals(first.ordinal(),0);
    }

    @Test
    public void 속성에_따른_상수_반환_정상(){
        Prize prize=sixth.prizeDetermine(checkFirst);

        Assertions.assertEquals(prize, first);
    }

}
