package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;

public class Manager {
    private static List<Lotto> customerTickets = new ArrayList<>();

    public int receiveMoney() {
        String inputMoney = Console.readLine();
        while (!Validators.validateMoney(inputMoney)) {
            inputMoney = Console.readLine();
        }
        return Integer.parseInt(inputMoney);
    }

    public List<Lotto> printTickets(int numberOfTickets) {
        for (int i = 0; i < numberOfTickets; i++) {
            customerTickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            System.out.println(customerTickets.get(i));
        }
        return customerTickets;
    }

    public static List<Lotto> totalTickets() {
        return customerTickets;
    }

    public List<Integer> setWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        String inputWinningNumbers = Console.readLine().replace(" ", "");
        while (!Validators.validateWinningNumbers(inputWinningNumbers)) {
            inputWinningNumbers = Console.readLine().replace(" ", "");
        }
        String[] stringWinningNumbers = inputWinningNumbers.split(",");
        winningNumbers = convertStringToIntegerList(stringWinningNumbers);
        winningNumbers.sort(Comparator.naturalOrder());
        return winningNumbers;
    }

    public static List<Integer> convertStringToIntegerList(String[] target) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String convertableNumber : target) {
            winningNumbers.add(Integer.parseInt(convertableNumber));
        }
        return winningNumbers;
    }

    public int setBonusNumber(List<Integer> winningNumbers) {
        String inputBonusNumber = Console.readLine();
        int bonusNumber;
        while (true) {
            try {
                Validators.validateStringIsIntegerConvertable(inputBonusNumber);
                bonusNumber = Integer.parseInt(inputBonusNumber);
                Validators.validateBonusNumber(bonusNumber, winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            inputBonusNumber = Console.readLine();
        }
        return bonusNumber;
    }


}
