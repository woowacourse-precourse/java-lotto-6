package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoNotRandomGenerator implements LottoGenerator {
    public static Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    public static int bonusNumber = 7;
    public static WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

    // 당첨번호: 1,2,3,4,5,6 / 보너스 번호: 7 기준
    public List<Lotto> fixedTickets = new ArrayList<>() {{
        add(new Lotto(List.of(2, 3, 4, 5, 6, 1))); // 1등 복권
        add(new Lotto(List.of(14, 15, 16, 17, 18, 19)));    // 꽝
        add(new Lotto(List.of(2, 3, 4, 5, 6, 10))); // 3등 복권
        add(new Lotto(List.of(2, 3, 4, 5, 10, 11))); // 4등 복권
        add(new Lotto(List.of(2, 3, 4, 10, 11, 12))); // 5등 복권
        add(new Lotto(List.of(9, 3, 4, 5, 11, 12))); // 5등 복권
        add(new Lotto(List.of(10, 3, 4, 5, 11, 12))); // 5등 복권
        add(new Lotto(List.of(12, 13, 14, 15, 16, 17)));    // 꽝
    }};
    public int fixedTicketsIndex = 0;

    @Override
    public Lotto generate() {
        return fixedTickets.get(fixedTicketsIndex++);
    }
}