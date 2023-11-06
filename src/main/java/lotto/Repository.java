package lotto;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    List<List<Integer>> repository = new ArrayList<>();
    public void add(List<Integer> numbers) {
        repository.add(numbers);
    }

    public List<List<Integer>> getLottoNum() {
        return repository;
    }
}
