package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoBundle;

public class BuyLottoDto {
    private List<List<Integer>> lottoBundle;
    private long lottoCnt;

    private BuyLottoDto() {
    }

    public static BuyLottoDto valueOf(LottoBundle lottoBundle, long lottoCnt) {
        BuyLottoDto buyLottoDto = new BuyLottoDto();
        buyLottoDto.lottoBundle = lottoBundle.getLotteries().stream()
                .map(lottery -> new ArrayList<>(lottery.getNumbers())).collect(Collectors.toList());
        buyLottoDto.lottoCnt = lottoCnt;
        return buyLottoDto;
    }

    public List<List<Integer>> getLottoBundle() {
        return lottoBundle;
    }

    public long getLottoCnt() {
        return lottoCnt;
    }
}
