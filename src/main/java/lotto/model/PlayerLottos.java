package lotto.model;

import java.util.List;

public class PlayerLottos {
    private List<Lotto> playerLottos;

    public PlayerLottos(int lottoAmount) {
        for (int i = 0; i < lottoAmount; i++){
            List<Integer> numbers = LottoService.generateLottoNumber();
            playerLottos.add(new Lotto(numbers));
        }
    }
}
