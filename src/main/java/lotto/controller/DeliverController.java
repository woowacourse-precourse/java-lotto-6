package lotto.controller;

import lotto.Lotto;
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
        deliverService.generateLotto(num);
        lottoPackage = deliverService.getLottoPackage();
    }

    public List<Lotto> getLottoPackage() {
        return lottoPackage;
    }
}
