package lotto;


import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class StringCalculatorTest {
    private List<String> testNumbers;

    @BeforeEach
    void setup() {
        testNumbers = new ArrayList<>();
        testNumbers.add("1");
        testNumbers.add("2");
        testNumbers.add("3");
        testNumbers.add("4");
        testNumbers.add("5");
        testNumbers.add("6");
    }
    @DisplayName("문자를 ','를 기준으로  나눈다.")
    @ParameterizedTest
    @ValueSource(strings = {"1","2","3","4","5","6"})
    void split(String givenStringNumber){
        //given
        String input="1,2,3,4,5,6";
        //when
        List<String> split = StringCalculator.split(input);
        //then
        Assertions.assertThat(split).isEqualTo(testNumbers);
        Assertions.assertThat(split).contains(givenStringNumber);
    }

    @DisplayName("문자를 양수 숫자로 바꾼다.")
    @Test
    void toPositives(){
        //given
        List<String> split = StringCalculator.split("1,2,3,4,5,6");
        //when
        List<Positive> positives = StringCalculator.toPositives(split);
        //then
        for(int i=1; i<=positives.size();i++) {
            Assertions.assertThat(positives.get(i-1).getNumber()).isEqualTo(i);
        }
    }
    @DisplayName("문자를 ','기준으로 나누고 양수화 하고 리스트를 반환한다.")
    @Test
    void withOutSpaceBarAndSplitAndPositives(){
        //given
        String text = " 1,2, 3, 4,5  ,6";
        //when
        List<Positive> positives = StringCalculator.withOutSpaceBarAndSplitAndPositives(text);
        //then
        Assertions.assertThat(positives.size()).isEqualTo(6);
        for(int i=0; i<positives.size(); i++){
            Assertions.assertThat(positives.get(i).getNumber()).isEqualTo(i+1);
        }
    }
    @DisplayName("문자 공백을 제거한다.")
    @Test
    void trim(){
        String text = "  10, 20   ,  30,   40 ,50,  60  ";
        String withoutSpaceBar = StringCalculator.withoutSpaceBar(text);
        Assertions.assertThat(withoutSpaceBar).doesNotHaveToString(" ");
        Assertions.assertThat(withoutSpaceBar).isEqualTo("10,20,30,40,50,60");
    }

}