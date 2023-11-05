package domain;

import constant.WinningPrize;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    public static final int TICKET_COST = 1000;

    private final List<Lotto> lottoList;

    public LottoTickets() {
         lottoList = new ArrayList<>();
    }

    LottoTickets(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public void add(int count) {
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto());
        }
    }

    int size() {
        return lottoList.size();
    }

    public List<Integer> getRanks(WinningLotto winningLotto) {
        List<Integer> ranks = createList(WinningPrize.COUNT_OF_WINNING_PRIZE.get());
        lottoList.stream()
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
}
