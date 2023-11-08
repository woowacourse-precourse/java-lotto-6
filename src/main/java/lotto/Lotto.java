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

    public int run(List<Integer> players){
        // 로또 번호 비교하기
        int computerIndex = 0;
        int playerIndex = 0;

        int count = 0;
        while (computerIndex < 6 & playerIndex < 6) {
            Integer computerNumber = this.numbers.get(computerIndex);
            Integer playerNumber = players.get(playerIndex);

            if (computerNumber == playerNumber){
                count ++;
                computerIndex ++;
                playerIndex ++;
            }
            
            if (computerNumber > playerNumber) {
                playerIndex ++;
            }
            
            if (computerNumber < playerNumber) {
                computerIndex ++;
            }
        }

        return count;
    }

    public int runBonus(Integer bonus){
        for (Integer number : this.numbers) {
            if (bonus == number) {
                return 1;
            }
        }
        return 0;
    }
}
