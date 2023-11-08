package lotto.controller;

import lotto.Lotto;
import lotto.service.LottoService;
import lotto.view.LottoView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private LottoService service = LottoService.getInstance();

    public void produce(int number){
        List<Lotto> lottos = service.prodcue(number);
        LottoView.print(number,lottos);
        price(number,lottos);
    }
    public void price(int number, List<Lotto> lottos){
        List<Integer> priceNumbers = LottoView.inputPrice();
        int bonusNumber = LottoView.inputBonus();
        Map<Integer,Integer> result = service.price(lottos,priceNumbers,bonusNumber);
        double rate =service.rate(number,result);
        ResultView.print(result,rate);
    }


}
