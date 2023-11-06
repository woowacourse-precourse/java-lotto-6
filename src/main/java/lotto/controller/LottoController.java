package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.LottoService;

import java.util.List;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public void run() {
        inputBuyLottoTickets();
        createUserLottoNumbers();
        inputWinnerLottoTicket();
        inputBonusNumber();
        processPrizeCalculation();
    }

    public void inputBuyLottoTickets() {
        boolean exceptionCheck = true;
        while (exceptionCheck) {
            try {
                System.out.println("구매 금액을 입력하세요.");
                String inputAmount = Console.readLine();

                this.lottoService.buyLottoTickets(inputAmount);

                exceptionCheck = false;

            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inputWinnerLottoTicket() {
        boolean exceptionCheck = true;
        while (exceptionCheck) {
            try {
                System.out.println("당첨 번호를 입력하세요.");
                String inputLotto = Console.readLine();

                this.lottoService.createLottoWinningNumber(inputLotto);
                exceptionCheck = false;

            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void createUserLottoNumbers() {
        List<List<Integer>> userLottoNumbers = this.lottoService.getUserLottoNumbers();
        printTicketsCount(userLottoNumbers.size());

        for (List<Integer> userLotto : userLottoNumbers) {
            System.out.println(userLotto);
        }
    }

    public void printTicketsCount(int ticketsCount) {
        System.out.println(ticketsCount + "개를 구매했습니다.");
    }

    public void inputBonusNumber() {
        boolean exceptionCheck = true;
        while (exceptionCheck) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String inputBonus = Console.readLine();

                this.lottoService.createBonusNumber(inputBonus);
                exceptionCheck = false;

            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void processPrizeCalculation() {
        this.lottoService.calculatePrize();
    }
}