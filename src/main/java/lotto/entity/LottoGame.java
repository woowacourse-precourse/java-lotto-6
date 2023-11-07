package lotto.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoGame {
    private Long id;
    private List<Lotto> lottos = new ArrayList<>();
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
