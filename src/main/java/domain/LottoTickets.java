package domain;

import constant.ConstantNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoes;

    public LottoTickets() {
         lottoes = new ArrayList<>();
    }

    LottoTickets(List<Lotto> lottoes) {
        this.lottoes = lottoes;
    }

    public void add(int count) {
        for (int i = 0; i < count; i++) {
            lottoes.add(new Lotto());
        }
    }

    int size() {
        return lottoes.size();
    }

    public List<Integer> getRanks(WinningLotto winningLotto) {
        List<Integer> ranks = createList(ConstantNumber.COUNT_OF_WINNING_PRIZE.get());
        lottoes.stream()
                .mapToInt(lotto -> lotto.rank(winningLotto))
                .filter(rank -> rank != -1)
                .forEach(rank -> ranks.set(rank - 1, ranks.get(rank - 1) + 1));
        return ranks;
    }

    private static List<Integer> createList(int count) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(0);
        }
        return list;
    }

    public List<Lotto> getTickets() {
        return new ArrayList<>(lottoes);
    }
}
