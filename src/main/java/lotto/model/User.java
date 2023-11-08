package lotto.model;

import lotto.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    private List<List<Integer>> lottoCount = new ArrayList<>();

    public User(int ticketCount) {
        createLottoCounts(ticketCount);
        sortLottoCounts();
    }

    private void createLottoCounts(int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            lottoCount.add(RandomUtils.makeRandomNumber());
        }
    }

    private void sortLottoCounts() {
        lottoCount = lottoCount.stream()
                .map(lotto -> lotto.stream()
                        .sorted()
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    public List<List<Integer>> getLottoCount() {
        return lottoCount;
    }
}
