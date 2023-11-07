package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.util.NumbersGenerator;
import lotto.util.TestFixNumbersGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonLottoTest {

  private NumbersGenerator numbersGenerator;

  @BeforeEach
  void setup() {
    numbersGenerator = new TestFixNumbersGenerator();
  }

  @Test
  @DisplayName("사용자는 로또를 한장 구매한다.")
  void testPurchaseLotto() {
    int purchaseMoney = 1000;

    PersonLotto personLotto = new PersonLotto(numbersGenerator, new PurchaseMoney(purchaseMoney));
    assertThat(personLotto.getPurchaseLotto().size()).isEqualTo(1);
  }
}