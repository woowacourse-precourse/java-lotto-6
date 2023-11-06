package lotto.controller.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.utils.GameConstants;

public class WinningNumberConverter implements Converter<Map<Integer, Integer>> {
    @Override
    public Map<Integer, Integer> convert(String WinningNumbers) {
        String[] splitWinningNumbers = WinningNumbers.split(GameConstants.SEPARATOR);

        List<Integer> numericWinningNumbers = getNumericWinningNumbers(splitWinningNumbers);

        return getSequencedWinningNumbers(numericWinningNumbers);
    }

    private List<Integer> getNumericWinningNumbers(String[] splitWinningNumbers) {
        List<Integer> numericWinningNumbers = new ArrayList<>();

        for (String splitWinningNumber : splitWinningNumbers) {
            numericWinningNumbers.add(Integer.parseInt(splitWinningNumber));
        }

        return numericWinningNumbers;
    }

    private Map<Integer, Integer> getSequencedWinningNumbers(List<Integer> orderedSplitWinningNumbers) {
        int sequenceNumber = 0;
        Map<Integer, Integer> sequencedWinningNumbers = new HashMap<>();

        for (int numericWinningNumber : orderedSplitWinningNumbers) {
            sequencedWinningNumbers.put(numericWinningNumber, sequenceNumber++);
        }

        return sequencedWinningNumbers;
    }
}
