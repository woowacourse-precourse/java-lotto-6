package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.entity.Lotto;
import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public Integer getCount(int money){
        return lottoService.getCount(money);
    }

    public List<Lotto> lottoGenerate(int count){
        return lottoService.lottoGenerate(count);
    }

}
