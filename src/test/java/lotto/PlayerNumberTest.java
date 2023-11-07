package lotto;

import lotto.Domain.PlayerNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerNumberTest {

    @DisplayName("플레이어가 입력한 로또 번호를 정상적으로 가져오는지 테스트한다.")
    @Test
    public void getPlayerNumbersTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        PlayerNumber playerNumber = new PlayerNumber(numbers);

        List<Integer> result = playerNumber.getNumbers();

        assertThat(result).isEqualTo(numbers);
    }
}

