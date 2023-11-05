package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final UserService userService;

    public LottoService() {
        this.userService = new UserService();
    }

    public void sellLottos(int cnt){
        List<Lotto> lottos = generateLottos(cnt);
        userService.updateUser(lottos, cnt);
    }

    private List<Lotto> generateLottos(int cnt){
        List<Lotto> lottos = new ArrayList<>(cnt);

        for (int i = 0; i < cnt; ++i) {
            lottos.add(LottoGenerator.generate());
        }

        return lottos;
    }
}
