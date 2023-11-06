package lotto.utils;

import lotto.exception.LottoException;
import lotto.exception.Message;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Parser {

    private static void validateWhiteSpace(String text){
        if (text.chars().anyMatch(Character::isWhitespace)){
            throw LottoException.of(Message.NUMBER_EMPTY);
        }
    }

    public static int parseStringToInt(String text){
        try{
            validateWhiteSpace(text);
            return Integer.parseInt(text);
        }catch (NumberFormatException e){
            throw LottoException.of(Message.NUMBER_TYPE);
        }
    }

    public static List<Integer> parseStringToIntList(String text){
        return Arrays.stream(text.split(",")).map(Parser::parseStringToInt).toList();
    }

    public static boolean isUnique(List<Integer> integerList){
        return new HashSet<>(integerList).size() == integerList.size();
    }
}
