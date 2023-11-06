package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.util.Constant;
import lotto.util.RandomValues;

public class LottoService {
    public static LottoService getInstance() {
        return LottoService.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final LottoService INSTANCE = new LottoService();
    }

    public Lotto getLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Lotto> createLottos(int numberOfLottoPapers) {
        return IntStream.range(0, numberOfLottoPapers)
                .mapToObj(i -> getLotto(RandomValues.getRandomValues()))
                .toList();
    }

    public int getNumberOfLottoPapers(int input) {
        return input / Constant.AMOUNT_ONE_LOTTO;
    }

    public List<Integer> numbersToList(String input) {
        String[] numbers = input.split(Constant.SPLIT_UNIT);
        return Arrays.stream(numbers)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
