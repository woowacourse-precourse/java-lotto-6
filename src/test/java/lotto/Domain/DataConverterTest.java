package lotto.Domain;

import lotto.Domain.Constants.PrizePot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataConverterTest {

    @DisplayName("문자열을_정수형으로_변환.")
    @Test
    void gameMoney() {
        String test1 = "15000";

        long expected = 15000;

        assertEquals(expected, DataConverter.gameMoney(test1) , () -> "[ERROR] 입력한 문자열이 정수형으로 바뀌어야 합니다.");
    }

    @DisplayName("1000_으로_나누기.")
    @Test
    void gameQuantity() {
        int test = 15000;

        int expected = 15;

        assertEquals(expected, DataConverter.gameQuantity(test), () -> "[ERROR] 입력한 숫자가 1000으로 나누어 떨어져야 합니다.");
    }

    @DisplayName("문자열을_문자열_리스트로_변환")
    @Test
    void winningInput() {
        String test = "1,2,3,4,5,6";

        List<String> actual = DataConverter.winningInput(test);
        List<String> expected = new ArrayList<>(List.of("1","2","3","4","5","6"));

        assertEquals(expected, actual);
    }

    @DisplayName("문자열_리스트가_정수형_리스트로_변환")
    @Test
    void winningBalls() {
        List<String> test = new ArrayList<>(List.of("1","2","3","4","5","6"));

        List<Integer> actual = DataConverter.winningBalls(test);
        List<Integer> expected = new ArrayList<>(List.of(1,2,3,4,5,6));

        assertEquals(expected, actual);
    }

    @DisplayName("입력된_문자열_형태의_숫자를_정수형으로_변환")
    @Test
    void bonusBall() {
        String bonusInput = "10";
        List<Integer> winningBalls = new ArrayList<>(List.of(1,2,3,4,5,6));

        int actual = DataConverter.bonusBall(bonusInput,winningBalls);
        int expected = 10;

        assertEquals(expected,actual);
    }

    @DisplayName("PrizePot에 입력된_값에_맞게_합_구하기")
    @Test
    void profitSum() {

        List<Integer> correctType = new ArrayList<>(List.of(1,1,0,0,0));

        long actual = DataConverter.profitSum(correctType);
        long expected = 55_000;

        assertEquals(expected,actual);
    }

    @DisplayName("수익률_변환")
    @Test
    void profitPercent() {
        double profitSum = 5000;
        double price = 10000;

        double actual = DataConverter.profitPercent(profitSum,price);
        double expected = 50.0;

        assertEquals(expected,actual);
    }
}