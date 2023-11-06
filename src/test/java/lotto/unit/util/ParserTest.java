package lotto.unit.util;

import lotto.exception.ParserException;
import lotto.exception.ParserExceptionMessage;
import lotto.util.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ParserTest {
    @Test
    @DisplayName("숫자로 이루어진 문자열을 입력하면 숫자를 반환한다.")
    void returnNumberWithInfo(){
        int expectedResult = 1000;

        var result = Parser.parseInfoToNumber("1000");

        Assertions.assertEquals(expectedResult,result);
    }
    @Test
    @DisplayName("숫자가 아닌 값을 포함한 문자열을 입력하면 예외를 발생한다.")
    void throwExceptionWhenInfoIncludeNonNumber(){
        var exceptionMessage = Assertions.assertThrows(ParserException.class,()->{
            Parser.parseInfoToNumber("123a");
        }).getMessage();
        Assertions.assertTrue(
                exceptionMessage.contains(ParserExceptionMessage.NOT_NUMBER.getMessage())
        );
    }

    @Test
    @DisplayName("쉼표로 구분한 숫자들로 이루어진 문자열을 입력하면 숫자 리스트를 반환한다.")
    void returnNumberListWithSeperatedInfo(){
        List<Integer> expectedResult = List.of(5,3,15,23,44,7);

        var result = Parser.parseInfoToNumbers("5,3,15,23,44,7");

        Assertions.assertEquals(expectedResult,result);
    }
    @Test
    @DisplayName("쉼표로 구분되지 않은 숫자들로 이루어진 문자열을 입력하면 예외를 발생한다.")
    void throwExceptionWhenInputNonSeperatedNumbers(){
        var exceptionMessage = Assertions.assertThrows(ParserException.class,()->{
            Parser.parseInfoToNumbers("5.3.15.23.44.7");
        }).getMessage();
        System.out.println(exceptionMessage);
        Assertions.assertTrue(
                exceptionMessage.contains(ParserExceptionMessage.NOT_DELIMITER.getMessage())
        );
    }
}
