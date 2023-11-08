package lotto.dto;

import java.util.List;

public class LottoInfoDto {

    private List<List<Integer>> lotteries;
    private List<Integer> winnerLotto;
    private int bonusNumber;

    private LottoInfoDto() {}

    public static LottoInfoDto valueOf(List<List<Integer>> lotteries, List<Integer> winnerLotto, int bonusNumber) {
        LottoInfoDto lottoInfoDto = new LottoInfoDto();
        lottoInfoDto.lotteries = lotteries;
        lottoInfoDto.winnerLotto = winnerLotto;
        lottoInfoDto.bonusNumber = bonusNumber;
        return lottoInfoDto;
    }

    public List<List<Integer>> getLotteries() {
        return lotteries;
    }

    public List<Integer> getWinnerLotto() {
        return winnerLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
