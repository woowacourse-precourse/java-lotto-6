package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static camp.nextstep.edu.missionutils.Console.*;
import static exception.ExceptionMessage.*;
import static lotto.Lotto.LOTTO_SIZE;
import static lotto.LottoFactory.*;

public class WinningNumbersSetter {
    private List<Integer> winning;
    private int bonus;

    public List<Integer> setWinning(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = readLine();
        try{
            winning = validateString(input);
            validateIntegers(winning);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            setWinning();
        }
        setBonus(winning);
        return winning;
    }

    private void validateDuplicate(List<Integer> winning) {
        if(winning.size() != winning.stream().distinct().count()){
            throw new IllegalArgumentException(WINNING_NUMBERS_DUPLICATE.message());
        }
    }

    private void validateIntegers(List<Integer> winning) {
        validateSize(winning);
        validateRange(winning);
        validateDuplicate(winning);
    }

    private static void validateRange(List<Integer> winning) {
        for (int i = 0; i < LOTTO_SIZE; i++) {
            Integer num = winning.get(i);
            if (num < LOTTO_MINIMUM_NUMBER || num > LOTTO_MAXIMUM_NUMBER){
                throw new IllegalArgumentException(WINNING_NUMBERS_RANGE.message());
            }
        }
    }

    private static void validateSize(List<Integer> winning) {
        if(winning.size() != LOTTO_SIZE){
            throw new IllegalArgumentException(WINNING_NUMBERS_SIZE.message());
        }
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

    public void setBonus(List<Integer> winning){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = readLine();
        try{
            bonus = Integer.parseInt(input);
            if(winning.contains(bonus)){
                throw new IllegalArgumentException(BONUS_DUPLICATE_WINNING_NUMBERS.message());
            }
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NUMBER_IS_STRING.message());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            setBonus(winning);
        }
    }
}
