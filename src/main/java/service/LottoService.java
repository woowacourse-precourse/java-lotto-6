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
        int lottoCount = input / 1000;
        for (int i = 0; i < lottoCount; i++) {
            getLottoNumbers();
        }
        return lottos.getLottoList();
    }

    private void getLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        lottos.addLotto(new Lotto(numbers));
    }

    public void setPlayer(List<Integer> winningNumbers, int bonusNumber) {
        player = new Player(winningNumbers, bonusNumber);
    }

}
