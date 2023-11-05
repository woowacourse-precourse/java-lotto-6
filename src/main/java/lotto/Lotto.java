package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private Rank rank = Rank.FAIL;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer>  getNumbers() {
        return numbers;
    }

    public void setRank(ArrayList<Integer> winningNumbers, int bonusNumber) {
        int count = 0;
        boolean checkBonus = false;
        StringBuilder sb = new StringBuilder();
        for(Integer number : numbers) {
            if(winningNumbers.contains(number)) ++count;
            if(number == bonusNumber) checkBonus = true;
        }
        sb.append(count);
        if(checkBonus) sb.append("B");
        this.rank = rank.calcurateRank(sb.toString());
    }

    public Rank getRank() {
        return this.rank;
    }


}
