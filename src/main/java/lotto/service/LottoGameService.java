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

    public LottoGameDto.CreateResponse createLottoGame(String budget) throws IllegalArgumentException {
        LottoGame saveLottoGame = new LottoGame(budget);
        Long lottoGameId = lottoGameRepository.save(saveLottoGame);
        return new LottoGameDto.CreateResponse(lottoGameId, saveLottoGame.getAmount());
    }

    public LottoGameDto.Response initLottoGame( LottoGameDto.InitRequest request) {
        LottoGame lottoGame = lottoGameRepository.findById(request.getLottoGameId());
        List<List<Integer>> lottoNumbers = lottoGame.createLotto();

        return new LottoGameDto.Response(lottoGame.getId(), lottoNumbers);
    }


    public LottoGameDto.Result doLottoGame(LottoGameDto.Request request) {
        LottoGame lottoGame = lottoGameRepository.findById(request.getLottoGameId());
        lottoGame.setWinningNumbers(request.getWinningNumbers(),request.getBonusNumber());
        return lottoGame.doLottoGame();
    }
}
