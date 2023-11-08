package lotto.domain;

import java.util.List;
import lotto.constants.Config;
import lotto.constants.Message;
import lotto.dto.BonusNumber;
import lotto.dto.LottoCompareResult;
import lotto.dto.WinningNumber;
import lotto.utils.Converter;

public class WinningCondition {
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;

    public LottoCompareResult compare(Lotto lotto) {
        int matchCount = calculateMatchCount(lotto.getNumbers());
        boolean matchBonus = calculateMatchBonus(lotto.getNumbers());
        return new LottoCompareResult(matchCount, matchBonus);
    }

    private int calculateMatchCount(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumber::contains)
                .count();
    }

    private boolean calculateMatchBonus(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber.getNumber());
    }

    public void inputBonusNumbers(String readLine) {
        Integer parsingNumber = Converter.convertToInteger(readLine);
        if (isWinningNumberContains(parsingNumber)) {
            throw new IllegalArgumentException(Message.DUPLICATED_BONUS_NUMBER);
        }
        this.bonusNumber = new BonusNumber(parsingNumber);
    }

    private boolean isWinningNumberContains(Integer parsingNumber) {
        return winningNumber.getNumbers().contains(parsingNumber);
    }

    public void inputWinningNumbers(String readLine) {
        List<Integer> parsingNumbers = parseToIntegerList(readLine);
        WinningNumber winningNumber = new WinningNumber(parsingNumbers);
        System.out.println();
        this.winningNumber = winningNumber;
    }

    private List<Integer> parseToIntegerList(String readLine) {
        List<String> parsedString = List.of(readLine.split(Config.NUMBER_REGEX));
        return getIntegerList(parsedString);
    }

    private List<Integer> getIntegerList(List<String> parsedString) {
        return parsedString.stream().map(Converter::convertToInteger)
                .toList();
    }

    public WinningCondition() {
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    public WinningNumber getWinningNumber() {
        return winningNumber;
    }
}
