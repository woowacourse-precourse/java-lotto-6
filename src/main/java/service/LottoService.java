package service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Lotto;
import domain.Lottos;
import domain.Player;
import utils.Validator;

import java.util.Collections;
import java.util.List;

public class LottoService {
    private Player player;
    private Lottos lottos = new Lottos();

    public List<Lotto> buyLotto(int input) {
        lottos = new Lottos();
        for (int i = 0; i < input; i++) {
            getLottoNumbers();
        }
        return lottos.getLottoList();
    }

    public int getTotalCount(int input) {
        return input / 1000;
    }

    private void getLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        lottos.addLotto(new Lotto(numbers));
    }

    public void setPlayer(List<Integer> winningNumbers, int bonusNumber) {
        player = new Player(winningNumbers, bonusNumber);
    }

    public List<Lotto> getLottos() {
        return lottos.getLottoList();
    }

    public Lotto getWinnerNumbers() {
        return player.getWinningLotto();
    }
}
