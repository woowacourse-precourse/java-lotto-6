package lotto.dto;

import java.util.List;
import lotto.Lotto;
import lotto.domain.LottoBundle;

public class LottoBundleDto {

    private List<List<Integer>> lotteries;

    private LottoBundleDto() {
    }

    public static LottoBundleDto valueOf(List<List<Integer>> lottoBundle) {
        LottoBundleDto lottoBundleDto = new LottoBundleDto();
        lottoBundleDto.lotteries = lottoBundle;
        return lottoBundleDto;
    }

    public List<List<Integer>> getLotteries() {
        return lotteries;
    }
}
