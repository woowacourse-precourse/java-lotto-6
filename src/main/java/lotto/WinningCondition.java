package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import lotto.ui.reader.InputReader;

public class WinningCondition {
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;
    private final InputReader inputReader;

    public void inputBonusNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String readLine = inputReader.readInput();
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
        System.out.println("당첨 번호를 입력해 주세요.");
        String readLine = inputReader.readInput();
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
