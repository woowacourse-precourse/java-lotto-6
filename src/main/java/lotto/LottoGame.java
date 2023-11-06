package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private List<Integer> winningNumbers = new ArrayList<>();
    private List<Lotto> lottoTickets = new ArrayList<>();
    private Integer money;
    private Boolean isGaming = true;

    public LottoGame() {
    }

    public void start() {
        while (isGaming) {
            inputMoney();
        }
    }


    private void inputMoney() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("로또 구입 금액이 얼마인가요?");
                money = Integer.valueOf(Console.readLine());
                validateThousandWonUnits(money);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateThousandWonUnits(Integer money) {
        if (!(money % 1000 == 0)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 천원 단위여야 합니다.");
        }
    }

    private void inputNumbers() {

    }

    private void splitByComma() {
        
    }

    private void winnigNumbers() {

    }

    private void pickBonusNumber() {

    }

    private void getLottoRank() {

    }

    private void getMoneyForRank() {

    }

    private void generateLottoTickets() {
    }

    private void printResult() {

    }

    private void getRateOfReturn() {

    }

    private void end() {

    }

}