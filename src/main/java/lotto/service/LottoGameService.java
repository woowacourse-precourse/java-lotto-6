package lotto.service;

import lotto.dto.LottoGameDto;
import lotto.entity.Lotto;
import lotto.entity.LottoGame;
import lotto.repository.LottoGameRepository;

import java.util.ArrayList;
import java.util.List;

public class LottoGameService {

    private LottoGameRepository lottoGameRepository;

    public LottoGameService(LottoGameRepository lottoGameRepository) {
        this.lottoGameRepository = lottoGameRepository;
    }

    public LottoGameDto.Response initLottoGame(int amount) {
        LottoGame saveLottoGame = new LottoGame();
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottoNumbers.add(saveLottoGame.createLotto());
        }
        Long lottoGameId = lottoGameRepository.save(saveLottoGame);
        return new LottoGameDto.Response(lottoGameId,lottoNumbers);
    }


    public LottoGameDto.Result doLottoGame(LottoGameDto.Request request) {
        LottoGame lottoGame = lottoGameRepository.findById(request.getLottoGameId());
        return lottoGame.doLottoGame();
    }
}
