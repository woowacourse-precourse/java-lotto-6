package lotto.service;

import lotto.dto.LottoGameDto;
import lotto.entity.Lotto;
import lotto.entity.LottoGame;
import lotto.repository.LottoGameRepository;

import java.util.List;

public class LottoGameService {

    private LottoGameRepository lottoGameRepository;

    public LottoGameService(LottoGameRepository lottoGameRepository) {
        this.lottoGameRepository = lottoGameRepository;
    }

    public LottoGameDto.Response initLottoGame(List<List<Integer>> buyLottos) {
        LottoGame saveLottoGame = new LottoGame();
        for (List<Integer> buyLotto : buyLottos) {
            Lotto makeLotto = new Lotto(buyLotto);
            saveLottoGame.addLotto(makeLotto);
        }
        Long lottoGameId = lottoGameRepository.save(saveLottoGame);
        return new LottoGameDto.Response(lottoGameId);
    }
}
