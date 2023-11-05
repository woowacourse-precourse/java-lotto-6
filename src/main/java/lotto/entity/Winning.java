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

public class Winning extends FiledMapper {
    private final List<Integer> winningNumbers;

    public Winning (String inputWinningNumbers,String winningBonusNumber){
        this.winningNumbers = winningNumbersConvertToList(inputWinningNumbers, winningBonusNumber);
    }

    private List<Integer> winningNumbersConvertToList(String inputWinningNumbers,String winningBonusNumber){
        List<String> winningNumberList = Arrays.asList(inputWinningNumbers.split(DELIMITER));
        validate(inputWinningNumbers,winningBonusNumber,winningNumberList);
        List<Integer> winningNumbers = new ArrayList<>(winningNumberList.stream().map(Integer::parseInt).toList());
        winningNumbers.add(Integer.parseInt(winningBonusNumber));
        return winningNumbers;
    }
    static void validate(String winningNumbers,String winningBonusNumber,List<String> winningNumberList){
        verifyFormatForInputValue(WINNINGS,winningNumbers);
        winningNumberList.forEach(number->verifyFormatForInputValue(WINNING,number));
        verifyFormatForInputValue(WINNING,winningBonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList((List<Integer>)FiledMapper.getFieldValue(
                        this, MethodProperty.WINNING_NUMBERS)
        );
    }
}
