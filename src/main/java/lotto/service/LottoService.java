package lotto.service;

import lotto.controller.LottoController;
import lotto.type.ResultType;

import java.util.Map;

public class LottoService {
    LottoController lottoController;

    public LottoService() {
        lottoController = new LottoController();
    }
    public void printRandomLotto() {
        int money = InputService.inputMoney();
        lottoController.getLottoTicket(money);
        System.out.println(lottoController.getLottoString());
        System.out.println();
    }

    public void printinputLotto() {
        String lottoNumbers = InputService.inputNumbers();
        String lottoBonusNumber = InputService.inputBonusNumber();
        lottoController.setinputLottoNumber(lottoNumbers);
        lottoController.setBonusNumber(lottoBonusNumber);
    }

    public void printTemplate(Map<ResultType, Long> resultTypes, double returnRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %ld개\n", resultTypes.getOrDefault(ResultType.THIRD, (long) 0));
        System.out.printf("4개 일치 (5,000원) - %ld개\n", resultTypes.getOrDefault(ResultType.THIRD, (long) 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (5,000원) - %ld개\n", resultTypes.getOrDefault(ResultType.THIRD, (long) 0));
        System.out.printf("6개 일치 (5,000원) - %ld개\n", resultTypes.getOrDefault(ResultType.THIRD, (long) 0));
        System.out.printf("총 수익률은 %f%입니다\n", returnRate);
    }

    public void printLottoService() {
        printRandomLotto();
        printinputLotto();
        Map<ResultType, Long> resultTypes = lottoController.getAllOfResult();
        double returnRate = lottoController.getReturnRate(resultTypes);
        printTemplate(resultTypes, returnRate);
    }
}
