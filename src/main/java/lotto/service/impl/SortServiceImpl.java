package lotto.service.impl;

import java.util.List;
import lotto.service.SortService;

public class SortServiceImpl implements SortService {
    @Override
    public List<Integer> sortLottoAsc(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }
}
