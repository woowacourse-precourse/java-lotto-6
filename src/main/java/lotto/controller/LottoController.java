package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.LottoService;
import utils.RandomUtils;

import java.util.List;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public void run() {
        inputLottoAmount();
        setLottoNumber();
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

                this.lottoService.initLottoNumber(inputLotto);
                exceptionCheck = false;

            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void setLottoNumber() {
        List<List<Integer>> userLottos = this.lottoService.setLottoNumbers();
        for (List<Integer> userLotto : userLottos) {
            System.out.println(userLotto);
        }
    }
}