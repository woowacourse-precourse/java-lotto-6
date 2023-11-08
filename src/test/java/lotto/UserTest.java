package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    void createLottoByOverSize() throws NoSuchFieldException, IllegalAccessException {
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
}
