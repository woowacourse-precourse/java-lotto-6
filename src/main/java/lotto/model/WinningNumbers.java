package lotto.model;

import lotto.view.Input;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int WINNING_NUMBERS_LIMIT = 6;
    private static final Input input = new Input();
    private List<Integer> winningNumbers;
    WinningNumbers(List<Integer> winningNumbers){
        this.winningNumbers = winningNumbers;   
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public static WinningNumbers from(){
        while(true){
            try {
                String numbers = input.readNumbers();
                List<Integer> number = Arrays.stream(numbers.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                if(check(number)){
                    return new WinningNumbers(number);
                }
            }   catch (IllegalArgumentException e){
                System.out.println("[ERROR] 잘못된 당첨 번호 입니다.");
            }
        }
    }

    private static boolean check(List<Integer> number) {
        if (checkSize(number) && checkValid(number) && checkDuplicate(number)) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    private static boolean checkDuplicate(List<Integer> number) {
        HashSet<Integer> set = new HashSet<>(number);
        return set.size() == WINNING_NUMBERS_LIMIT;
    }

    private static boolean checkValid(List<Integer> number) {
        for (Integer integer : number) {
            if (integer < MIN || integer > MAX) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSize(List<Integer> number) {
        return number.size() == WINNING_NUMBERS_LIMIT;
    }

    public boolean add(int number){
        return this.winningNumbers.add(number);
    }
}
