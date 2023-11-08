package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;


public class Manager {
    public static List<Lotto> customerTickets = new ArrayList<>();

    public List<Lotto> printTickets(int numberOfTickets) {
        System.out.printf("%d개를 구매했습니다.", numberOfTickets);
        List<Lotto> customerTickets1 = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            customerTickets1.add(new Lotto(randomNumbers));
            System.out.println(customerTickets1.get(i));
        }
        return customerTickets1;
    }

    public static List<Lotto> totalTickets() {
        return customerTickets;
    }

    public List<Integer> setWinningNumbers(String inputWinningNumbers, List<Integer> winningNumbers) {
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
}
