package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static camp.nextstep.edu.missionutils.Console.*;
import static constant.LottoValue.*;
import static exception.ExceptionMessage.*;

public class WinningNumbersFactory {
    private List<Integer> winningNumbers;
    Lotto winningLotto;
    private int bonus;

    public Lotto setWinning(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
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
        StringTokenizer st = new StringTokenizer(input, ",");
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
        validateSize(winning);
        validateRange(winning);
        validateDuplicate(winning);
    }

    private static void validateSize(List<Integer> winning) {
        if(winning.size() != LOTTO_SIZE.value()){
            throw new IllegalArgumentException(WINNING_NUMBERS_SIZE.message());
        }
    }

    private static void validateRange(List<Integer> winning) {
        for (int i = 0; i < LOTTO_SIZE.value(); i++) {
            Integer num = winning.get(i);
            if (num < LOTTO_MINIMUM_NUMBER.value() || num > LOTTO_MAXIMUM_NUMBER.value()){
                throw new IllegalArgumentException(WINNING_NUMBERS_RANGE.message());
            }
        }
    }

    private void validateDuplicate(List<Integer> winning) {
        if(winning.size() != winning.stream().distinct().count()){
            throw new IllegalArgumentException(WINNING_NUMBERS_DUPLICATE.message());
        }
    }

    public void setBonus(List<Integer> winning){
        System.out.println("\n보너스 번호를 입력해 주세요.");
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
