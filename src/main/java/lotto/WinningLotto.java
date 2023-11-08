package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private final static String WINNING_NUMBERS_REGEX = "([0-9]+,){5}[0-9]+";
    private final static String BONUS_NUMBER_REGEX = "[0-9]+";
    private static final int CORRECT_LOTTO_SIZE = 6;
    private Lotto winningNumbers;
    private int bonusNumber;


    public void getWinningNumbers(){
        while (true){
            try{
                List<Integer> parsedWinningNumbers = parseWinningNumbers(Input.getWinningNumbers());
                validate(parsedWinningNumbers);
                this.winningNumbers = new Lotto(parsedWinningNumbers);
                return;
            } catch (IllegalArgumentException e){
                System.out.println(Output.ERROR_MESSAGE_PREFIX + Output.LOTTO_WINNING_NUMBERS_ERROR_MESSAGE);
            }
        }
    }

    public void validate(List<Integer> winningNumbers){
        if(winningNumbers.size() != CORRECT_LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }

        Long count = winningNumbers.stream()
                .distinct()
                .filter(winningNumber -> 1 <= winningNumber && winningNumber <= 45)
                .count();

        if(count != CORRECT_LOTTO_SIZE)
            throw new IllegalArgumentException();
    }

    public List<Integer> parseWinningNumbers(String winningNumbers){
        if(!winningNumbers.matches(WINNING_NUMBERS_REGEX)){
            throw new IllegalArgumentException();
        }

        return Arrays.asList(winningNumbers.split(","))
                .stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public void setWinningNumbers(Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void getBonusNumber(){
        while(true) {
            try {
                int bonusNumber = parseBonusNumber(Input.getBonusNumber());
                validate(bonusNumber);
                this.bonusNumber = bonusNumber;
                return;
            } catch (IllegalArgumentException e){
                System.out.println(Output.ERROR_MESSAGE_PREFIX + Output.LOTTO_BONUS_NUMBER_ERROR_MESSAGE);
            }
        }
    }

    public int parseBonusNumber(String bonusNumber){
        if(!bonusNumber.matches(BONUS_NUMBER_REGEX))
            throw new IllegalArgumentException();

        return Integer.parseInt(bonusNumber);
    }

    public void validate(int bonusNumber){
        if(this.winningNumbers.getNumbers().contains(bonusNumber))
            throw new IllegalArgumentException();

        if(!(1 <= bonusNumber && bonusNumber <= 45))
            throw new IllegalArgumentException();
    }

    public Lotto getterWinningNumbers(){
        return this.winningNumbers;
    }

    public int getterBonusNumber(){
        return this.bonusNumber;
    }

}
