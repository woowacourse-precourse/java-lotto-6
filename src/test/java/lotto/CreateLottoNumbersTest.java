package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.model.CreateLottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreateLottoNumbersTest {

    @DisplayName("로또 번호 랜덤 생성 테스트")
    @Test
    void createRandomNumbersTest() {
        List<Integer> randomNumbers = new ArrayList<>();
        CreateLottoNumbers createLottoNumbers = new CreateLottoNumbers();
        randomNumbers = createLottoNumbers.createRandomNumbers();
        System.out.println(randomNumbers);
        assertThat(randomNumbers).isNotNull();
    }
}
