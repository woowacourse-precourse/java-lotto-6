package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoRandomNumberTest {

    private static List<Integer> lottoRandomNumber;

    @DisplayName("랜덤 로또 번호가 6자리가 아닐경우 예외가 발생한다.")
    @Test
    void checkLottoRandomNumberSize() {
        lottoRandomNumber = LottoRandomNumber.getRandomNumbers();
        assertThat(lottoRandomNumber.size()).isEqualTo(6);
    }
}
