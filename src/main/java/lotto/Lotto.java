package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public void printLotto(){
        Print.printLotto(numbers);
    }

    public int calcMatchNumber(List<Integer> winningNumber, Integer bonumNumber){
        int[] lottoMap = new int[46];
        int matchNumber = 0;
        for (int i = 0; i < 6; i++){
            lottoMap[numbers.get(i)] = 1;
        }
        for (int i = 0; i < 6; i++){
            if (lottoMap[winningNumber.get(i)] == 1){
                matchNumber++;
            }
        }
        if (matchNumber == 5 || lottoMap[bonumNumber] == 1){
            return 7;
        }
        return matchNumber;
    }
}
