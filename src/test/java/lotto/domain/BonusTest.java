package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class BonusTest {

    @RepeatedTest(value = 10)
    public void 보너스_번호_중복검사() throws Exception {
        //given (주어진 값)
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(numbers);
        Bonus bonus = new Bonus(lotto);

        //when (기능 작동)
        Method method = bonus.getClass().getDeclaredMethod("drawBonusNumber", Lotto.class);
        method.setAccessible(true);
        int number = (int) method.invoke(bonus, lotto);

        //then (기능 작동 후 결과)
        Assertions.assertThat(numbers.contains(number)).isFalse();
    }
}