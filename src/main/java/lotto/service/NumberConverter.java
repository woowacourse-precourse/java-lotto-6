package lotto.service;

import lotto.consts.ExceptionMessage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.consts.ConstsString.DELIMETER;

public class NumberConverter {
    public int convertNumber(String inputNum){
        try{
            int convert = Integer.parseInt(inputNum);
            return convert;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_NUMBER.getMessage());
        }

    }

    public List<Integer> convertNumberList(String inputNum){
        try{
            return Stream.of(inputNum.split(DELIMETER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_NUMBER.getMessage());
        }

    }
}
