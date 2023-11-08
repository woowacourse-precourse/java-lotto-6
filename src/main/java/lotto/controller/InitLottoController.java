package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;

import java.util.ArrayList;
import java.util.List;

public class InitLottoController {

    private LottoService lottoService = new LottoService();

    public List<Lotto> runInitLotto(int ticketNumber){
        return processLottoNumber(ticketNumber);
    }

    public List<Lotto> processLottoNumber(int ticketNumber){
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i <ticketNumber; i++){
            lottos.add(new Lotto(lottoService.initLottoNumber()));
        }

        return lottos;
    }


}
