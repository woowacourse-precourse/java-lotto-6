package lotto;

import java.util.List;
import lotto.Messages.ErrorMessage;

public class Lotto {
    public static final int RANK_5 = 3;
    public static final int RANK_4 = 4;
    public static final int RANK_3 = 5;
    public static final int RANK_2 = 7;
    public static final int RANK_1 = 6;
    public static final int LOTTO_PRICE = 1000;

    public static final int LOTTO_MIN_VALUE = 1;
    public static final int LOTTO_MAX_VALUE = 45;
    public static final int MAX_LOTTO_SIZE = 6;
    public static final int MAX_LOTTO_MAP_SIZE = 45;
    public static final int EXIST = 1;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            Print.printMessage(ErrorMessage.SIZE_OVER.getMessage());
            throw new IllegalArgumentException();
        }
        if (numbers.stream().distinct().count() != numbers.size()){
            Print.printMessage(ErrorMessage.DUPLICATED_NUMBER.getMessage());
            throw new IllegalArgumentException();
        }
        for (Integer number : numbers){
            if (number < LOTTO_MIN_VALUE || LOTTO_MAX_VALUE < number){
                Print.printMessage(ErrorMessage.NOT_IN_1_TO_45.getMessage());
                throw new IllegalArgumentException();
            }
        }
    }
    public void printLotto(){
        Print.printLotto(numbers);
    }

    public int calcMatchNumber(List<Integer> winningNumber, Integer bonumNumber){
        int[] lottoMap = new int[MAX_LOTTO_MAP_SIZE + 1]; // 배열의 index를 1부터 사용하므로 +1
        int matchNumber = 0;

        for (int i = 0; i < MAX_LOTTO_SIZE; i++){
            lottoMap[numbers.get(i)] = EXIST;
        }
        for (int i = 0; i < MAX_LOTTO_SIZE; i++){
            if (lottoMap[winningNumber.get(i)] == EXIST){
                matchNumber++;
            }
        }
        if (matchNumber == RANK_3 && lottoMap[bonumNumber] == EXIST){
            return RANK_2;
        }
        return matchNumber;
    }
}
