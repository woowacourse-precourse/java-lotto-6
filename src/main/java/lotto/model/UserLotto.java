package lotto.model;

import java.util.List;

public class UserLotto extends Lotto{
    Integer rank;
    Long reward;
    public UserLotto(List<Integer> numbers) {
        super(numbers);
    }
}
