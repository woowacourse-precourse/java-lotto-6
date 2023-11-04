package lotto;

import java.util.List;

public class Lotto {
    static final int THE_SECOND_TO_THE_LAST = 5;
    static final int LAST_LOTTERY_INDEX = 5;
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

    public void printLotteryNumber(int totalLotterySize){
        System.out.println();
        System.out.println(totalLotterySize + "개를 구매했습니다.");
        System.out.print("[");
        for(int number : numbers){
            if(numbers.indexOf(number) == THE_SECOND_TO_THE_LAST){
                break;
            }

            System.out.print(number + ", ");
        }
        System.out.print(numbers.get(LAST_LOTTERY_INDEX));
        System.out.print("]");
        System.out.println();
    }
}

