package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.service.LottoService;

import java.util.Arrays;
import java.util.List;


public class LottoController {

    LottoService lottoService = new LottoService();

    public void run() {
        inputLottoAmount();
        inputLottoNumber();
    }

    public void inputLottoAmount() {
        boolean exceptionCheck = true;
        while (exceptionCheck) {
            try {
                System.out.println("구매 금액을 입력하세요.");
                String inputAmount = Console.readLine();

                this.lottoService.initLottoAmount(inputAmount);

                exceptionCheck = false;

            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputLottoNumber() {
        boolean exceptionCheck = true;
        while (exceptionCheck) {
            try {
                System.out.println("당첨 번호를 입력하세요.");
                String inputLotto = Console.readLine();

                List<Integer> lottoNumbers = Arrays.stream(inputLotto.split(","))
                        .map(Integer::parseInt)
                        .toList();

                this.lottoService.initLottoNumber(lottoNumbers);

                exceptionCheck = false;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
