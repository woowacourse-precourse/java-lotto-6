package lotto;

import lotto.validation.LottoValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static camp.nextstep.edu.missionutils.Console.*;
import static constant.LottoValue.*;
import static exception.ExceptionMessage.*;
import static output.OutputMessage.COMMA;
import static output.OutputMessage.GIVE_THE_WINNING_NUMBERS;

public class WinningNumbersFactory {
    private List<Integer> winningNumbers;
    Lotto winningLotto;
    private int bonus;

    public Lotto setWinning(){
        System.out.println(GIVE_THE_WINNING_NUMBERS.message());
        String input = readLine();
        try{
            winningNumbers = validateString(input);
            validateIntegers(winningNumbers);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            setWinning();
        }
        setBonus(winningNumbers);
        winningLotto = new Lotto(winningNumbers);
        return winningLotto;
    }

    private List<Integer> validateString(String input) {
        List<Integer> inputNumbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input, COMMA.message());
        try {
            while(st.hasMoreTokens()) {
                inputNumbers.add(Integer.parseInt(st.nextToken()));
            }
        } catch (NullPointerException e){
            throw new IllegalArgumentException(WINNING_NUMBERS_IS_NULL.message());
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NUMBER_IS_STRING.message());
        }
        return inputNumbers;
    }

    private void validateIntegers(List<Integer> winning) {
        LottoValidation lottoValidation = new LottoValidation();
        lottoValidation.lottoValidate(winning);
    }


    public void setBonus(List<Integer> winning){
        System.out.println(GIVE_THE_WINNING_NUMBERS.message());
        String input = readLine();
        try{
            bonus = Integer.parseInt(input);
            if(winning.contains(bonus)){
                throw new IllegalArgumentException(BONUS_DUPLICATE_WINNING_NUMBERS.message());
            }
            if (bonus < LOTTO_MINIMUM_NUMBER.value() || bonus > LOTTO_MAXIMUM_NUMBER.value()){
                throw new IllegalArgumentException(BONUS_NUMBER_RANGE.message());
            }
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NUMBER_IS_STRING.message());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            setBonus(winning);
        }
    }

    public int getBonus(){
        return bonus;
    }

}
