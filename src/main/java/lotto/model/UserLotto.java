package lotto.model;

import java.util.List;

public class UserLotto {
    private List<Integer> numbers;
    public UserLotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
