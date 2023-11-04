package lotto.model;

import java.util.List;
import java.util.ArrayList;

public class UserLotto {
    private final List<ArrayList<Integer>> userNumbers;

    public UserLotto(List<ArrayList<Integer>> userNumbers) {
        validate(userNumbers);
        this.userNumbers = userNumbers;
    }

    private void validate(List<ArrayList<Integer>> userNumbers) {
        if (userNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}