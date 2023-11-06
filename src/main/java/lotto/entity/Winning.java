package lotto.entity;

import lotto.entity.mapper.FiledMapper;
import lotto.property.MethodProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lotto.property.LottoProperty.*;
import static lotto.property.ValidationProperty.*;
import static lotto.validation.ValidationForm.*;

public class Winning{
    private final List<Integer> winningNumbers;

    public Winning (String inputWinningNumbers){
        this.winningNumbers = winningNumbersConvertToList(inputWinningNumbers);
    }

    private List<Integer> winningNumbersConvertToList(String inputWinningNumbers){
        List<String> winningNumberList = Arrays.asList(inputWinningNumbers.split(DELIMITER));
        validate(inputWinningNumbers, winningNumberList);
        List<Integer> winningNumbers = new ArrayList<>(winningNumberList.stream().map(Integer::parseInt).toList());
        return winningNumbers;
    }
    static void validate(String winningNumbers, List<String> winningNumberList){
        verifyFormatForInputValue(WINNINGS,winningNumbers);
        winningNumberList.forEach(number->verifyFormatForInputValue(WINNING,number));
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(
                (List<Integer>)FiledMapper.getFieldValue(this, MethodProperty.WINNING_NUMBERS)
        );
    }
}
