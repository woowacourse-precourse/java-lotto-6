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
        int ticket;
        while (true) {
            try {
                String money = InputService.inputMoney();
                ticket = lottoController.getLottoTicket(money);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        lottoController.setRandomLottoNumber(ticket);
        System.out.println("\n" + ticket + "개를 구매했습니다.");
        System.out.println(lottoController.getLottoString());
    }

    public void inputLottoNumbers() {
        while (true) {
            try {
                String lottoNumbers = InputService.inputNumbers();
                lottoController.setInputLottoNumber(lottoNumbers);
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputLottoBonusNumber() {
        while (true) {
            try {
                String lottoBonusNumber = InputService.inputBonusNumber();
                lottoController.setBonusNumber(lottoBonusNumber);
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void printTemplate(Map<ResultType, Long> resultTypes, double returnRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + resultTypes.getOrDefault(ResultType.THIRD, (long) 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + resultTypes.getOrDefault(ResultType.FOURTH, (long) 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + resultTypes.getOrDefault(ResultType.FIFTH, (long) 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultTypes.getOrDefault(ResultType.FIFTH_BONUS, (long) 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + resultTypes.getOrDefault(ResultType.ALL, (long) 0) + "개");
        System.out.println("총 수익률은 " + returnRate + "%입니다.");
    }

    // 이 메서드로 로또를 실행할 수 있다.
    public void printLottoService() {
        printRandomLotto();
        inputLottoNumbers();
        inputLottoBonusNumber();
        Map<ResultType, Long> resultTypes = lottoController.getAllOfResult();
        double returnRate = lottoController.getReturnRate(resultTypes);
        printTemplate(resultTypes, returnRate);
    }
}
