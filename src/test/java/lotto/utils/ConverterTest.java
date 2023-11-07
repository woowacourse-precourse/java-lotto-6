package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

class ConverterTest {

    @Test
    void stringToLotto() {
        //given
        String inputValue = "1,2,3,4,5,6";
        int[] compareValue = {1, 2, 3, 4, 5, 6};
        //when
        Lotto lotto = Converter.stringToLotto(inputValue);
        List<Integer> numbers = lotto.getNumbers();
        int order = 0;
        //then
        for (int number : numbers) {
            assertThat(number).isEqualTo(compareValue[order++]);
        }
    }

    @Test
    void stringToList() {
        //given
        String testInput = "1,2,3,4,5,6";
        //when
        List<String> result = Converter.stringToList(testInput);
        //then
        int compareValue = 1;
        for (String value : result) {
            assertThat(Integer.parseInt(value)).isEqualTo(compareValue++);
        }
    }

    @Test
    void stringListToIntegerList() {
        //given
        String testInput = "1,2,3,4,5,6";
        List<String> inputValue = Converter.stringToList(testInput);
        //when
        List<Integer> result = Converter.stringListToIntegerList(inputValue);
        //then
        int compareValue = 1;
        for (int number : result) {
            assertThat(number).isEqualTo(compareValue++);
        }
    }

    @Test
    void lottoToString() {
        //given
        String testInput = "1,2,3,4,5,6";
        Lotto testValue = Converter.stringToLotto(testInput);
        //when
        List<String> result = Converter.lottoToString(testValue);
        List<String> compareValue = Converter.stringToList(testInput);
        //then
        assertThat(result).isEqualTo(compareValue);
    }

    @Test
    void deleteSpace() {
        //given
        String testInput = "1     ,2         ,3,4,5,        6";
        //when
        String expectValue = "1,2,3,4,5,6";
        String result = Converter.deleteSpace(testInput);
        //then
        assertThat(result).isEqualTo(expectValue);
    }
}