package lotto.domain;

import static lotto.constants.Message.INPUT_BONUS_NUMBER;
import static lotto.constants.Message.INPUT_WINNING_NUMBER;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import lotto.dto.BonusNumber;
import lotto.dto.LottoCompareResult;
import lotto.dto.WinningNumber;
import lotto.view.InputReader;

public class WinningCondition {
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;
    private final InputReader inputReader;

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

    public void inputBonusNumbers() {
        String readLine = inputReader.readInput(INPUT_BONUS_NUMBER);
        Integer parsingNumber = parseToInteger(readLine);
        if (isWinningNumberContains(parsingNumber)) {
            throw new IllegalArgumentException();
        }
        BonusNumber bonusNumber = new BonusNumber(parsingNumber);
        System.out.println();
        this.bonusNumber = bonusNumber;
    }

    private boolean isWinningNumberContains(Integer parsingNumber) {
        return winningNumber.getNumbers().contains(parsingNumber);
    }

    private Integer parseToInteger(String readLine) {
        Integer number;
        try {
            number = Integer.parseInt(readLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("");
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("");
        }
        return number;
    }

    public void inputWinningNumbers() {
        String readLine = inputReader.readInput(INPUT_WINNING_NUMBER);
        List<Integer> parsingNumbers = parseToIntegerList(readLine);
        WinningNumber winningNumber = new WinningNumber(parsingNumbers);
        System.out.println();
        this.winningNumber = winningNumber;
    }

    private List<Integer> parseToIntegerList(String readLine) {
        List<String> parsedString = List.of(readLine.split(","));
        List<Integer> parsingNumbers = getIntegerList(parsedString);
        return parsingNumbers;
    }

    private List<Integer> getIntegerList(List<String> parsedString) {
        List<Integer> parsingNumbers = new ArrayList<>();
        for (String str : parsedString) {
            try {
                parsingNumbers.add(Integer.parseInt(str));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("");
            } catch (NoSuchElementException e) {
                throw new IllegalArgumentException("");
            }
        }
        return parsingNumbers;
    }
    public WinningCondition(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    public WinningNumber getWinningNumber() {
        return winningNumber;
    }
}
