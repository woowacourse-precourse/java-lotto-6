package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.util.NumbersGenerator;
import lotto.util.TestRandomNumbersGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerLottoTest {

  private NumbersGenerator numbersGenerator;

  @BeforeEach
  void setup() {
    numbersGenerator = new TestRandomNumbersGenerator();
  }

  @Test
  @DisplayName("컴퓨터가 생성한 로또는 6개로 구성되어 있다.")
  void testCreateComputerLotto() {
    List<Integer> createdNumbers = numbersGenerator.generate();
    Lotto lotto = new Lotto(createdNumbers);
    ComputerLotto computerLotto = new ComputerLotto(lotto);

    assertThat(computerLotto.getLottoNumbers())
        .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
  }
}