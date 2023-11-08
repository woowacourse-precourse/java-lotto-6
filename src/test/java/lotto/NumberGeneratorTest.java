package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {
    NumberGenerator numberGenerator = new NumberGenerator();

    @Test
    @DisplayName("로또 번호 6개가 정상적으로 생성된다.")
    void generateSixLottoNumbers() {
        numberGenerator.generateLottoNumbers();
        assertEquals(6, numberGenerator.getLottoNumbers().size());
        assertFalse(numberGenerator.getLottoNumbers().isEmpty());
    }

    @Test
    @DisplayName("로또 객체가 정상적으로 구매금액만큼 생성된다.")
    void generateLottos() {
        int randomNumber = Randoms.pickNumberInRange(1, 20);
        NumberGenerator[] purchaseNumbers = new NumberGenerator[randomNumber];
        NumberGenerator.generateLottos(randomNumber, purchaseNumbers);
        for(NumberGenerator purchaseNumber : purchaseNumbers){
            assertEquals(randomNumber, purchaseNumbers.length);
        }
    }
}