package lotto.controller.converter;

import java.util.HashSet;
import java.util.Set;
import lotto.utils.GameConstants;

public class WinningNumberConverter implements Converter<Set<Integer>> {
    @Override
    public Set<Integer> convert(String WinningNumbers) {
        String[] splitWinningNumbers = WinningNumbers.split(GameConstants.SEPARATOR);
        
        return getNumericWinningNumbers(splitWinningNumbers);
    }

    private Set<Integer> getNumericWinningNumbers(String[] splitWinningNumbers) {
        Set<Integer> numericWinningNumbers = new HashSet<>();

        for (String splitWinningNumber : splitWinningNumbers) {
            numericWinningNumbers.add(Integer.parseInt(splitWinningNumber));
        }

        return numericWinningNumbers;
    }

}
