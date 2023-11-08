package lotto.dto;

import lotto.repository.LottoWinningRepository;
import lotto.repository.UserLottoRepository;

public class RepositoryDto {

    UserLottoRepository userLottoRepository;
    LottoWinningRepository lottoWinningRepository;

    public RepositoryDto(UserLottoRepository userLottoRepository,
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
