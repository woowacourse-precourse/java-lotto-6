package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class TotalLotto {
    private final List<Lotto> totalLotto;

    public TotalLotto() {
        this.totalLotto = new ArrayList<>();
    }

    public void generateTotalLotto(Lotto lotto) {
        totalLotto.add(lotto);
    }

    public List<Lotto> getLottoList() {
        return new ArrayList<>(totalLotto); // 복제된 리스트 반환
    }

    public int getTotalLottoCount() {
        return totalLotto.size();
    }


}
