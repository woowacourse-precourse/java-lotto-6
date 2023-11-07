package lotto.entity;

import lotto.dto.LottoGameDto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private Long id;
    private List<Lotto> lottos = new ArrayList<>();
    List<Integer> winningNumbers;
    Integer bonusNumber;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public LottoGameDto.Result doLottoGame() {
        int[] result = {0, 0, 0, 0, 0, 0, 0, 0};
        for (Lotto lotto : lottos) {
            int score = lotto.checkLottoScore(winningNumbers);
            if (score == 5 && lotto.checkLottoBonus(bonusNumber)) {
                score = 7;
            }
            result[score] += 1;
        }
        return new LottoGameDto.Result(result[3], result[4], result[5], result[7], result[6]);
    }
}
