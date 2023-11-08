package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
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
            money = inputMoney();
            lottoTickets = generateLottoTickets(money);

        }
    }

    private Integer inputMoney() {
        boolean validInput = false;
        Integer money = 0;

        System.out.println("로또 구입 금액이 얼마인가요?");

        while (!validInput) {
            try {
                money = Integer.valueOf(Console.readLine());
                validateThousandWonUnits(money);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return money;
    }

    private void validateThousandWonUnits(Integer money) {
        if (!(money % 1000 == 0)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 천원 단위여야 합니다.");
        }
    }

    private Lotto inputNumbers() {
        Lotto lotto = null;
        String inputNumbers = null;
        boolean validInput = false;

        System.out.println("로또 번호를 입력하세요.");

        while (!validInput) {
            inputNumbers = Console.readLine();
            try {
                lotto = new Lotto(splitByComma(inputNumbers));
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lotto;
    }

    private Lotto inputBonusNumber(Lotto lotto) {
        String inputNumber;

        System.out.println("보너스 번호를 입력해주세요.");

        inputNumber = Console.readLine();

        lotto.setBonusNumber(Integer.valueOf(inputNumber));

        return lotto;
    }

    private List<Integer> splitByComma(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<Integer> pickWinningNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 7);
    }

    private void getLottoRank() {

    }

    private void getMoneyForRank() {

    }

    private List<Lotto> generateLottoTickets(Integer money) {
        List<Lotto> lottos = new ArrayList<>();
        int ticketAmount = (int) money / 1000;

        for (int i = 0; i < ticketAmount; i++) {
            Lotto newLotto = inputNumbers();
            Lotto newLottoBonus = inputBonusNumber(newLotto);
            lottos.add(newLottoBonus);
        }

        return lottos;
    }

    private void printResult() {

    }

    private void getRateOfReturn() {

    }

    private void end() {

    }

}