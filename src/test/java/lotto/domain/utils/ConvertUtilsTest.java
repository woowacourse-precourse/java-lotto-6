package lotto.domain.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConvertUtilsTest {

    @Test
    @DisplayName("구분자를 기준으로 숫자들을 나누어 List<Integer>를 반환한다.")
    void convertStringToListTest() throws Exception{
        //given
        List<Integer> expect = List.of(1,2,3,4,5,6);
        String inputString ="1,2,3,4,5,6";
        String inputString2 = "1.2.3.4.5.6";
        //when
        List<Integer> list1 = ConvertUtils.convertStringToList(inputString, ",");
        List<Integer> list2 = ConvertUtils.convertStringToList(inputString2, "\\.");
        //then
        assertThat(list1).isEqualTo(expect);
        assertThat(list2).isEqualTo(expect);
     }

     @Test
     @DisplayName("구매 금액에 1000원당 1장의 티켓으로 반환된다.")
     void calculateNumberOfTicketsTest() throws Exception{
         //given
         Long number1 = 1000000000L;
         Long number2 = 999999000L;
         //when
         Integer numberOfTickets1 = ConvertUtils.calculateNumberOfTickets(number1);
         Integer numberOfTickets2 = ConvertUtils.calculateNumberOfTickets(number2);
         //then
         assertThat(numberOfTickets1).isEqualTo(1000000);
         assertThat(numberOfTickets2).isEqualTo(999999);
      }
}