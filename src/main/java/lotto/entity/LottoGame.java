package lotto.entity;

import camp.nextstep.edu.missionutils.Randoms;
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

    public List<Integer> createLotto() {
        List<Integer> lottoNumber = new ArrayList<>();
        while (lottoNumber.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!lottoNumber.contains(randomNumber)) {
                lottoNumber.add(randomNumber);
            }
        }
        Lotto lotto = new Lotto(lottoNumber);
        lottos.add(lotto);
        return lottoNumber;
    }

    public void setWinningNumbers(List<Integer> winningNumbers,Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
