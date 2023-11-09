package lotto.engine.domain;

import java.util.Arrays;
import java.util.List;
import lotto.engine.LottoSystemConstant.TextMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CustomerTest {

    @ParameterizedTest(name = "[{index}차]시도: list: {0}, bonusNumber: {1}")
    @DisplayName("유효한 당첨번호와 보너스 숫자라면 Customer 객체를 생성할 수 있다.")
    @CsvSource({"'1,2,3,4,5,6', 10","'10,14,16,20,22,29',45"})
    void testConstructCustomer(String list,int bonusNumber){
        //given
        List<Integer> numbers = Arrays.stream(list.split(","))
                .map(Integer::parseInt).toList();
        //when
        //then
        new Customer(numbers,bonusNumber);
    }

    @ParameterizedTest(name = "[{index}차]시도: list: {0}, bonusNumber: {1}")
    @DisplayName("길이가 유효하지 않는 당첨번호를 넣으면 IllegalArgumentException 이 발생한다.")
    @CsvSource({"'1,2,3,4,5', 10","'10,14,16',45"})
    void failConstructCustomerForNotSatisfyLength(String list,int bonusNumber){
        //given
        List<Integer> numbers = Arrays.stream(list.split(","))
                .map(Integer::parseInt).toList();
        //when
        //then
        Assertions.assertThatThrownBy(()->new Customer(numbers,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TextMessage.ERROR_PREFIX.getMessage());
    }

    @ParameterizedTest(name = "[{index}차]시도: list: {0}, bonusNumber: {1}")
    @DisplayName("당첨번호들 중 보너스 숫자와 중복된다면IllegalArgumentException 이 발생한다.")
    @CsvSource({"'1,2,3,4,5,6', 5","'1,2,3,4,5,6',1","'1,2,3,4,5,6',2","'1,2,3,4,5,6',6"})
    void failConstructCustomerForDuplicateNumber(String list,int bonusNumber){
        //given
        List<Integer> numbers = Arrays.stream(list.split(","))
                .map(Integer::parseInt).toList();
        //when
        //then
        Assertions.assertThatThrownBy(()->new Customer(numbers,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TextMessage.ERROR_PREFIX.getMessage());
    }

    @ParameterizedTest(name = "[{index}차]시도: list: {0}, bonusNumber: {1}")
    @DisplayName("당첨번호가 유효한 숫자 범위에 포함되지 않는다면 IllegalArgumentException 이 발생한다.")
    @CsvSource({"'0,2,3,4,5,6', 5","'46,2,3,4,5,6',1","'99,2,3,4,5,6',2","'100,2,3,4,5,6',6"})
    void failConstructCustomerForNotInRangeWiningNumber(String list,int bonusNumber){
        //given
        List<Integer> numbers = Arrays.stream(list.split(","))
                .map(Integer::parseInt).toList();
        //when
        //then
        Assertions.assertThatThrownBy(()->new Customer(numbers,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TextMessage.ERROR_PREFIX.getMessage());
    }

    @ParameterizedTest(name = "[{index}차]시도: list: {0}, bonusNumber: {1}")
    @DisplayName("보너스가 유효한 숫자 범위에 포함되지 않는다면 IllegalArgumentException 이 발생한다.")
    @CsvSource({"'1,2,3,4,5,6', 0","'1,2,3,4,5,6',46","'2,3,4,5,6,9',100","'2,3,11,22,33,44',99"})
    void failConstructCustomerForNotInRangeBonusNumber(String list,int bonusNumber){
        //given
        List<Integer> numbers = Arrays.stream(list.split(","))
                .map(Integer::parseInt).toList();
        //when
        //then
        Assertions.assertThatThrownBy(()->new Customer(numbers,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TextMessage.ERROR_PREFIX.getMessage());
    }



}