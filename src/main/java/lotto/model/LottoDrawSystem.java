package lotto.model;

import lotto.utils.Validations;
import static lotto.utils.Constants.*;

import java.util.Arrays;


public class LottoDrawSystem {
    private WinningNumber winningNumber;
    private Prize prize;
    public LottoDrawSystem() {
        this.prize = new Prize();
        prize.setGradeBoard();
        prize.setMoneyBoard();
        prize.setMatchCountBoard();
        prize.setMessageBoard();
    }

    public void validateNumbers(String givenNumbers) {
        Validations.checkWinningNumbersCount(givenNumbers);

        String[] _numbers = givenNumbers.split(SEPERATOR);

        int[] numbers = Arrays.stream(_numbers)
                .mapToInt(Integer::parseInt)
                .toArray();

        Validations.checkDuplicateWinningNumbers(numbers);
        Arrays.stream(numbers)
                .forEach(Validations::checkWinningNumberRange);
    }

    public void setNumbers(String givenNumbers) {
        winningNumber = new WinningNumber(givenNumbers);
    }


    public int getSameNumbersCount(int[] numbers) {
        boolean[] winningNumbersExist = this.winningNumber.getNumbersExist();
        return Arrays.stream(numbers).filter(n -> winningNumbersExist[n]).toArray().length;
    }

    public boolean isBonusSame(int number) {
        return this.winningNumber.getBonus() == number;
    }

    public int draw(int[] numbers) {
        int sameNumbersCount = this.getSameNumbersCount(numbers);
        boolean bonusSame = false;

        for(int number: numbers) {
            bonusSame = this.isBonusSame(number);
        }

        return this.prize.getGrade(sameNumbersCount, bonusSame);
    }

    public int getMoney(int grade) {
        return this.prize.getMoney(grade);
    }

    public String getMessage(int grade) {
        return this.prize.getMessage(grade);
    }


}
