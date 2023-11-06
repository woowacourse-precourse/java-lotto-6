package lotto.util;

import lotto.domain.constant.ParserConstant;
import lotto.exception.ParserException;
import lotto.exception.ParserExceptionMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser implements ParserConstant {
    public static Integer parseInfoToNumber(String info){
        try{
            return Integer.parseInt(info);
        }catch (NumberFormatException exception){
            throw new ParserException(ParserExceptionMessage.NOT_NUMBER);
        }
    }
    public static List<Integer> parseInfoToNumbers(String info){
        try{
            List<String> parsedInfo = parseInfo(info);
            return convertParsedInfoToNumber(parsedInfo);
        }catch (NumberFormatException exception){
            throw new ParserException(ParserExceptionMessage.NOT_DELIMITER);
        }

    }
    private static List<String> parseInfo(String info){
        return Arrays.asList((info.split(DELIMITER)));
    }
    private static List<Integer> convertParsedInfoToNumber(List<String> parsedInfo){
        List<Integer> convertedInfo = new ArrayList<>();
        for (String info : parsedInfo){
            convertedInfo.add(Integer.parseInt(info));
        }
        return convertedInfo;
    }
}
