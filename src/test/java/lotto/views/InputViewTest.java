package lotto.views;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import lotto.global.ErrorMessage;
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

        // (1) getPurchaseAmount_정상_케이스
        inputBuilder.append("50000");
        inputBuilder.append("\n");

        // (2) getWinningNumbers_정상_케이스
        inputBuilder.append("1,2,3,4,5,6");
        inputBuilder.append("\n");
        inputBuilder.append("7");
        inputBuilder.append("\n");

        // (3) getBonusNumber_정상_케이스
        inputBuilder.append("1,2,3,4,5,6");
        inputBuilder.append("\n");
        inputBuilder.append("7");
        inputBuilder.append("\n");

        // (4) getBonusNumber_보너스_번호_입력이_숫자가_아닌_경우
        inputBuilder.append("1,2,3,4,5,6");
        inputBuilder.append("\n");
        inputBuilder.append("a");
        inputBuilder.append("\n");

        // (5) getBonusNumber_보너스_번호가_당첨_번호_중_있는_경우
        inputBuilder.append("1,2,3,4,5,6");
        inputBuilder.append("\n");
        inputBuilder.append("5");
        inputBuilder.append("\n");

        // (6) getBonusNumber_보너스_번호가_1_미만인_경우
        inputBuilder.append("1,2,3,4,5,6");
        inputBuilder.append("\n");
        inputBuilder.append("0");
        inputBuilder.append("\n");

        // (7) getBonusNumber_보너스_번호가_45_초과인_경우
        inputBuilder.append("1,2,3,4,5,6");
        inputBuilder.append("\n");
        inputBuilder.append("46");
        inputBuilder.append("\n");

        // (8) getBonusNumber_보너스_번호가_45_초과인_경우
        inputBuilder.append("1,2,3,4,5,6,7");
        inputBuilder.append("\n");

        // (9) getBonusNumber_보너스_번호가_45_초과인_경우
        inputBuilder.append("1,2,3,4,5");
        inputBuilder.append("\n");

        // (10) getBonusNumber_보너스_번호가_45_초과인_경우
        inputBuilder.append("1,2,3,4,5,6,6");
        inputBuilder.append("\n");

        // (11) getBonusNumber_보너스_번호가_45_초과인_경우
        inputBuilder.append("1,2,3,4,5,5");
        inputBuilder.append("\n");

        // (12) getBonusNumber_보너스_번호가_45_초과인_경우
        inputBuilder.append("1,2,3,0,5,6");
        inputBuilder.append("\n");

        // (13) getBonusNumber_보너스_번호가_45_초과인_경우
        inputBuilder.append("1,2,3,46,6,7");
        inputBuilder.append("\n");

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

    @Test
    @Order(3)
    void getBonusNumber_정상_케이스() {
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
        assertThat(bonusNumber).isEqualTo(Integer.parseInt(inputBonusNumber));
    }

    @Test
    @Order(4)
    void getBonusNumber_보너스_번호_입력이_숫자가_아닌_경우() {
        //given
        String inputNumbers = "1,2,3,4,5,6";
        String inputBonusNumber = "a";
        String[] input = inputNumbers.split(",");
        Set<Integer> numbers = new HashSet<>();
        for (String s : input) {
            int number = Integer.parseInt(s);
            numbers.add(number);
        }
        Set<Integer> originalWinningNumbers = inputView.getOriginalWinningNumbers();

        //when
        //then
        assertThatThrownBy(() -> inputView.getBonusNumber(originalWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_MET_INPUT_NUMBER.getMessage());
    }

    @Test
    @Order(5)
    void getBonusNumber_보너스_번호가_당첨_번호_중_있는_경우() {
        //given
        String inputNumbers = "1,2,3,4,5,6";
        String inputBonusNumber = "5";
        String[] input = inputNumbers.split(",");
        Set<Integer> numbers = new HashSet<>();
        for (String s : input) {
            int number = Integer.parseInt(s);
            numbers.add(number);
        }
        Set<Integer> originalWinningNumbers = inputView.getOriginalWinningNumbers();

        //when
        //then
        assertThatThrownBy(() -> inputView.getBonusNumber(originalWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_CONTAINS_BONUS_NUMBER_IN_WINNING_NUMBERS.getMessage());
    }

    @Test
    @Order(6)
    void getBonusNumber_보너스_번호가_1_미만인_경우() {
        //given
        String inputNumbers = "1,2,3,4,5,6";
        String inputBonusNumber = "0";
        String[] input = inputNumbers.split(",");
        Set<Integer> numbers = new HashSet<>();
        for (String s : input) {
            int number = Integer.parseInt(s);
            numbers.add(number);
        }

        Set<Integer> originalWinningNumbers = inputView.getOriginalWinningNumbers();

        //when
        //then
        assertThatThrownBy(() -> inputView.getBonusNumber(originalWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_MET_LOTTO_NUMBERS_RANGE.getMessage());
    }

    @Test
    @Order(7)
    void getBonusNumber_보너스_번호가_45_초과인_경우() {
        //given
        String inputNumbers = "1,2,3,4,5,6";
        String inputBonusNumber = "45";
        String[] input = inputNumbers.split(",");
        Set<Integer> numbers = new HashSet<>();
        for (String s : input) {
            int number = Integer.parseInt(s);
            numbers.add(number);
        }
        Set<Integer> originalWinningNumbers = inputView.getOriginalWinningNumbers();

        //when
        //then
        assertThatThrownBy(() -> inputView.getBonusNumber(originalWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_MET_LOTTO_NUMBERS_RANGE.getMessage());
    }

    @Test
    @Order(8)
    void getOriginalWinningNumbers_입력_당첨_번호가_6개_초과_인_경우() {
        //given
        String inputNumbers = "1,2,3,4,5,6,7";
        //when
        //then
        assertThatThrownBy(() -> inputView.getOriginalWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_MET_LOTTO_NUMBERS_LENGTH.getMessage());
    }

    @Test
    @Order(9)
    void getOriginalWinningNumbers_입력_당첨_번호가_6개_미만_인_경우() {
        //given
        String inputNumbers = "1,2,3,4,5";
        //when
        //then
        assertThatThrownBy(() -> inputView.getOriginalWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_MET_LOTTO_NUMBERS_LENGTH.getMessage());
    }

    @Test
    @Order(10)
    void getOriginalWinningNumbers_입력_당첨_번호가_7개_인데_중복_제거_시_6개_인_경우() {
        //given
        String inputNumbers = "1,2,3,4,5,6,6";
        //when
        //then
        assertThatThrownBy(() -> inputView.getOriginalWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_MET_LOTTO_NUMBERS_LENGTH.getMessage());
    }

    @Test
    @Order(11)
    void getOriginalWinningNumbers_입력_당첨_번호가_6개_인데_중복_제거_시_6개가_아닌_경우() {
        //given
        String inputNumbers = "1,2,3,4,5,5";
        //when
        //then
        assertThatThrownBy(() -> inputView.getOriginalWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_MET_LOTTO_NUMBERS_LENGTH.getMessage());
    }

    @Test
    @Order(12)
    void getOriginalWinningNumbers_입력_당첨_번호_중_하나_라도_1_미만_인_경우() {
        //given
        String inputNumbers = "1,2,3,0,5,6";
        //when
        //then
        assertThatThrownBy(() -> inputView.getOriginalWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_MET_LOTTO_NUMBERS_RANGE.getMessage());
    }

    @Test
    @Order(13)
    void getOriginalWinningNumbers_입력_당첨_번호_중_하나_라도_45_초과_인_경우() {
        //given
        String inputNumbers = "1,2,3,46,6,7";
        //when
        //then
        assertThatThrownBy(() -> inputView.getOriginalWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_MET_LOTTO_NUMBERS_RANGE.getMessage());
    }
}
