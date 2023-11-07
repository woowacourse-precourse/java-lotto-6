package lotto.controller;

import lotto.vo.Lotto;
import lotto.service.DeliverService;
import lotto.view.Output;

import java.util.List;

public class DeliverController {
    List<Lotto> lottoPackage;
    public DeliverController(int num){
        Output output = new Output();
        deliverLottoPackage(num);
        output.printLotto(lottoPackage);
    }

    private void deliverLottoPackage(int num){
        DeliverService deliverService = new DeliverService();
        lottoPackage = deliverService.generateLotto(num);
    }

    public List<Lotto> getLottoPackage() {
        return lottoPackage;
    }
}
