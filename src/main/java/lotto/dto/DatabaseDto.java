package lotto.dto;

import lotto.repository.LottoWinningRepository;
import lotto.repository.UserLottoRepository;

public class DatabaseDto {

    UserLottoRepository userLottoRepository;
    LottoWinningRepository lottoWinningRepository;

    public DatabaseDto(UserLottoRepository userLottoRepository,
                       LottoWinningRepository lottoWinningRepository) {
        this.userLottoRepository = userLottoRepository;
        this.lottoWinningRepository = lottoWinningRepository;
    }

    public LottoWinningRepository getLottoWinningDataRepository() {
        return lottoWinningRepository;
    }

    public UserLottoRepository getUserLottoDataRepository() {
        return userLottoRepository;
    }

}
