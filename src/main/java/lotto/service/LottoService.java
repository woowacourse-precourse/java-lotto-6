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
        int ticket = lottoController.getLottoTicket(money);
        lottoController.setRandomLottoNumber(ticket);
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
        System.out.println("3개 일치 (5,000원) - " + resultTypes.getOrDefault(ResultType.THIRD, (long) 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + resultTypes.getOrDefault(ResultType.FOURTH, (long) 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + resultTypes.getOrDefault(ResultType.FIFTH, (long) 0) +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultTypes.getOrDefault(ResultType.FIFTH_BONUS, (long) 0) +"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + resultTypes.getOrDefault(ResultType.ALL, (long) 0) +"개");
        System.out.println("총 수익률은 " + returnRate + "%입니다");
    }

    public void printLottoService() {
        printRandomLotto();
        printinputLotto();
        Map<ResultType, Long> resultTypes = lottoController.getAllOfResult();
        double returnRate = lottoController.getReturnRate(resultTypes);
        printTemplate(resultTypes, returnRate);
    }
}
