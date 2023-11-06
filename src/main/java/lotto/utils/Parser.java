package lotto.utils;

import lotto.exception.LottoException;
import lotto.exception.Message;

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
}
