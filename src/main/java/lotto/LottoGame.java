package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private List<Integer> winningNumbers = new ArrayList<>();
    private List<Lotto> lottoTickets = new ArrayList<>();
    private Integer money;

    public LottoGame() {
    }

    public void start() {
        boolean isGaming = true;

        while (isGaming) {
            inputMoney();
            inputNumbers();
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
        System.out.println("로또 번호를 입력하세요");

        String inputNumbers = Console.readLine();
        lottoTickets.add(new Lotto(splitByComma(inputNumbers)));
    }

    private List<Integer> splitByComma(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
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