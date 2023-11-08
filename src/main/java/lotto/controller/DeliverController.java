package lotto.controller;

import lotto.vo.Lotto;
import lotto.service.DeliverService;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

import static lotto.values.ExceptionMessage.NOT_WORK_LOTTO_GENERATOR;

public class DeliverController {

    DeliverService deliverService;
    public DeliverController(int num, DeliverService deliverService) {
        this.deliverService = deliverService;
        Output output = new Output();
        List<Lotto> lottoPackage = deliverLottoPackage(num);
        if (lottoPackage != null) output.printLotto(lottoPackage);
    }

    private List<Lotto> deliverLottoPackage(int num) {
        List<Lotto> lottoPackage = null;
        while (lottoPackage == null) {
            try {
                lottoPackage = deliverService.generateLotto(num);
            } catch (IllegalArgumentException e) {
                Output output = new Output();
                output.printError(NOT_WORK_LOTTO_GENERATOR.getMessage());
            }
        }
        return lottoPackage;
    }
}
