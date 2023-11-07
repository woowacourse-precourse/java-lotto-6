package lotto.controller;

import lotto.vo.Lotto;
import lotto.service.DeliverService;
import lotto.view.Output;

import java.util.List;

import static lotto.values.ExceptionMessage.NOT_WORK_LOTTO_GENERATOR;

public class DeliverController {
    List<Lotto> lottoPackage;

    public DeliverController(int num) {
        Output output = new Output();
        deliverLottoPackage(num);
        if (lottoPackage != null) output.printLotto(lottoPackage);
    }

    private void deliverLottoPackage(int num) {
        while (lottoPackage == null) {
            try {
                DeliverService deliverService = new DeliverService();
                lottoPackage = deliverService.generateLotto(num);
            } catch (IllegalArgumentException e) {
                Output output = new Output();
                output.printError(NOT_WORK_LOTTO_GENERATOR.getMessage());
            }
        }
    }

    public List<Lotto> getLottoPackage() {
        return lottoPackage;
    }
}
