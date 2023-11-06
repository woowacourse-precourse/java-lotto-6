package lotto.views;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lotto.domain.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InputViewTest {
    InputView inputView = new InputView();

    @BeforeAll
    static void inputInitialize() {
        StringBuilder inputBuilder = new StringBuilder();

        // getPurchaseAmount_정상_케이스
        inputBuilder.append("50000");
        inputBuilder.append("\n");
        // getWinningNumbers_정상_케이스
        inputBuilder.append("1,2,3,4,5,6");
        inputBuilder.append("\n");
        inputBuilder.append("7");

        InputStream testInput = new ByteArrayInputStream(inputBuilder.toString().getBytes());
        System.setIn(testInput);
    }
    @Test
    @Order(1)
    void getPurchaseAmount_정상_케이스() {
        //given
        String input = "50000";
        //when
        long purchaseAmount = inputView.getPurchaseAmount();

        //then
        assertThat(Long.parseLong(input)).isEqualTo(purchaseAmount);
    }

    @Test
    @Order(2)
    void getWinningNumbersTest_정상_케이스() {
        //given
        String inputNumbers = "1,2,3,4,5,6";
        String inputBonusNumber = "7";
        String[] input = inputNumbers.split(",");
        Set<Integer> numbers = new HashSet<>();
        for (String s : input) {
            int number = Integer.parseInt(s);
            numbers.add(number);
        }
        //when
        Set<Integer> originalWinningNumbers = inputView.getOriginalWinningNumbers();
        int bonusNumber = inputView.getBonusNumber(originalWinningNumbers);
        //then
        assertThat(originalWinningNumbers).isEqualTo(numbers);
        assertThat(bonusNumber).isEqualTo(Integer.parseInt(inputBonusNumber));

    }
}