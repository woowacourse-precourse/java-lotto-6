package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveTest {


    @ParameterizedTest
    @ValueSource(ints = {-1,0})
    @DisplayName("0이나 음수인 경우 에러를 발생한다")
    void validatePositive(int givenNumber){
        assertThatThrownBy( ()-> {
            Positive positive = new Positive(givenNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("숫자를 꺼낸다")
    void getNumber(){
        //given
        int number=3;
        Positive positive = new Positive(number);
        //when
        int getNumber = positive.getNumber();
        //then
        Assertions.assertThat(getNumber).isEqualTo(number);
    }

    @Test
    @DisplayName("숫자를 더한다.")
    void add(){
        //given
        Positive positive = new Positive(3);

        //when
        Positive added = positive.add(new Positive(10));

        //then
        Assertions.assertThat(added.getNumber()).isEqualTo(13);
    }
    @Test
    @DisplayName("숫자들을 정렬한다.")
    void sort(){
        //given
        List<Positive> positives = new ArrayList<>();
        positives.add(new Positive(40));
        positives.add(new Positive(80));
        positives.add(new Positive(30));
        positives.add(new Positive(50));
        //when
        Collections.sort(positives);
        //then
       for(Positive i : positives){
           System.out.println(i.getNumber());
       }
    }
    @Test
    @DisplayName("큰값에서 작은 값을 나눈다.")
    void divideV1(){
        //given
        Positive positive1 = new Positive(8000);
        Positive positive2 = new Positive(1000);
        //when
        Positive goodDivide = positive1.divide(positive2);
        int getNumber = goodDivide.getNumber();
        //then
        Assertions.assertThat(getNumber).isEqualTo(8);
    }
    @Test
    @DisplayName("작은 값을 큰 값으로 나눈다.")
    void divide2(){
        //given
        Positive positive1 = new Positive(8000);
        Positive positive2 = new Positive(1000);
        //when -> then
        assertThatThrownBy(()-> {
            Positive badDivide = positive2.divide(positive1);
        }).isInstanceOf(IllegalArgumentException.class);

    }
}