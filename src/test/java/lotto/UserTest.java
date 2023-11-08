package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Randoms;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.stubbing.OngoingStubbing;

public class UserTest {
     User user;
     List<Lotto> lottoes;

    @BeforeEach
    public void getConstantValue() throws NoSuchFieldException, IllegalAccessException {
        user = new User();

        Field privateLottoes = User.class.getDeclaredField("lottoes");
        privateLottoes.setAccessible(true);

        lottoes = (List<Lotto>) privateLottoes.get(user);
    }

    @DisplayName("로또 번호를 범위안의 숫자로 잘 고르는지 테스트")
    @Test
    void selectLottoNumbersWithinValidRange() throws NoSuchFieldException, IllegalAccessException {
        for (int testNumber = 0; testNumber < 100; testNumber++) {
            user.pickLottoNumber();

            Field privateNumbers = Lotto.class.getDeclaredField("numbers");
            privateNumbers.setAccessible(true);
            List<Integer> numbers = (List<Integer>) privateNumbers.get(lottoes.get(testNumber));

            for (Integer currentNumber : numbers) {
                assertThat(currentNumber).isBetween(1, 45);
            }
        }
    }

    @DisplayName("자신이 가지고 있는 로또 등수를 잘 확인하는지 테스트")
    @Test
    void checkLottoWinningRanking() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", "7");
        HashMap<Integer, Integer> answer = new HashMap<>() {{
            put(1, 1);
            put(2, 1);
            put(3, 1);
            put(4, 1);
            put(5, 1);
        }};
        List<Integer> lotto1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lotto2 = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> lotto3 = List.of(1, 2, 3, 4, 5, 8);
        List<Integer> lotto4 = List.of(1, 2, 3, 4, 7, 8);
        List<Integer> lotto5 = List.of(1, 2, 3, 7, 8, 9);
        List<Integer> lotto6 = List.of(1, 2, 7, 8, 9, 10);
        List<Integer> lotto7 = List.of(1, 7, 8, 9, 10, 11);
        List<Integer> lotto8 = List.of(12, 44, 45, 32, 23, 26);

        final MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        when(Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt()))
                .thenReturn(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6, lotto7, lotto8);
        for (int i = 0; i < 8; i++) {
            user.pickLottoNumber();
        }
        assertThat(answer).isEqualTo(user.checkLottoesRanking(winningLotto));
    }
}
