package lotto.dto;

import java.util.List;
import lotto.Lotto;
import lotto.domain.LottoBundle;

public class LottoBundleDto {

    private List<List<Integer>> lotteries;

    private LottoBundleDto() {
    }

    public static LottoBundleDto valueOf(LottoBundle lottoBundle) {
        LottoBundleDto lottoBundleDto = new LottoBundleDto();
        lottoBundleDto.lotteries = lottoBundle.getLotteries().stream().map(Lotto::getNumbers).toList();
        return lottoBundleDto;
    }

    public List<List<Integer>> getLotteries() {
        return lotteries;
    }
}
