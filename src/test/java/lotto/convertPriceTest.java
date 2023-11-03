package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.controller.InputConverter.*;

public class convertPriceTest {
    @DisplayName("입력받은 가격 정수형으로 후처리")
    @Test
    void convertPriceTest() {
        String inputPrice = "1000";
        int price = convertPrice(inputPrice);
        Assertions.assertThat(price).isEqualTo(1000);
    }

    @DisplayName("입력받은 당첨 숫자 정수형 리스트로")
    @Test
    void convertWinningNumberTest() {
        String inputWinningNumber = "1,2,3,4,5,6";
        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);

        List<Integer> returnWinningNumbers = convertWinningNumber(inputWinningNumber);

        Assertions.assertThat(winningNumbers).isEqualTo(returnWinningNumbers);
    }

    @DisplayName("입력받은 보너스 숫자 정수형으로")
    @Test
    void convertBonusNumberTest() {
        String inputBonusNumber = "1";

        int bonusNumber = convertBonusNumber(inputBonusNumber);

        Assertions.assertThat(bonusNumber).isEqualTo(1);
    }
}
