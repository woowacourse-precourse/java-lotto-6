package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import lotto.constant.WinPriceMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CompareNumberTest {

    private int testSum = 0;


    @DisplayName("6개의 숫자가 전부 같은 경우")
    @Test
    void 일등_당첨() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> randomNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 3;

        ComPareNumber comPareNumber = new ComPareNumber(numbers, randomNumbers, bonusNumber);

        assertEquals(WinPriceMessage.First.getPrize(), comPareNumber.getMoneySum());
        assertEquals(1, (int) comPareNumber.getWinCount().get(0));
    }

    @DisplayName("5개의 숫자가 같고, 보너스 번호까지 같은 경우")
    @Test
    void 이등_당첨() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> randomNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        ComPareNumber comPareNumber = new ComPareNumber(numbers, randomNumbers, bonusNumber);
        assertEquals(WinPriceMessage.Second.getPrize(), comPareNumber.getMoneySum());
        assertEquals(1, (int) comPareNumber.getWinCount().get(1));

    }

    @DisplayName("5개의 숫자가 같고, 보너스 번호가 다른 경우")
    @Test
    void 삼등_당첨() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> randomNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 8;

        ComPareNumber comPareNumber = new ComPareNumber(numbers, randomNumbers, bonusNumber);
        assertEquals(WinPriceMessage.Third.getPrize(), comPareNumber.getMoneySum());
        assertEquals(1, (int) comPareNumber.getWinCount().get(2));

    }

    @DisplayName("4개의 숫자가 같은 경우")
    @Test
    void 사등_당첨() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 10, 11);
        List<Integer> randomNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 5;

        ComPareNumber comPareNumber = new ComPareNumber(numbers, randomNumbers, bonusNumber);
        assertEquals(WinPriceMessage.Fourth.getPrize(), comPareNumber.getMoneySum());
        assertEquals(1, (int) comPareNumber.getWinCount().get(3));

    }

    @DisplayName("3개의 숫자가 같은 경우")
    @Test
    void 오등_당첨() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 9, 10, 11);
        List<Integer> randomNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 5;

        ComPareNumber comPareNumber = new ComPareNumber(numbers, randomNumbers, bonusNumber);
        assertEquals(WinPriceMessage.Fifth.getPrize(), comPareNumber.getMoneySum());
        assertEquals(1, (int) comPareNumber.getWinCount().get(4));

    }





}

