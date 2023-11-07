package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.Winning;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.repository.WinningLottoRepository;

public class WinningLottoService {
    private final WinningLottoRepository winningLottoRepository;

    public WinningLottoService(WinningLottoRepository winningLottoRepository) {
        this.winningLottoRepository = winningLottoRepository;
    }

    public void saveWinningLotto(Lotto lotto, int bonus) {
        WinningLotto winningLotto = new WinningLotto(lotto, bonus);
        winningLottoRepository.save(winningLotto);
    }

    public List<WinningResult> calculateAllWinningResult(User user) {
        WinningLotto winningLotto = winningLottoRepository.find();

        return Arrays.stream(Winning.values())
                .map(winning -> new WinningResult(user, winningLotto, winning))
                .collect(
                Collectors.toList());
    }



}
