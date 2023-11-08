package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoMachine {

    static private int money;
    static private int ticketNumber;
    static List<Lotto> totalLottoTickets = new ArrayList<Lotto>();

    static void receivingMoney() {
        while (true) {
            System.out.println("구입 금액을 입력해 주세요.");
            String input = Console.readLine();
            if (validateFormat(input) && validateMoney(input)) {
                break;
            }
        }
    }

    static boolean validateFormat(String input) {
        try {
            money = Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            return false;
        }
    }

    static boolean validateMoney(String input) {
        try {
            if (money < 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 양수여야 합니다.");
            } else if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    static void givingLottoTickets() {
        ticketNumber = money / 1000;
        for (int i = 0; i < ticketNumber; i++) {
            List<Integer> numbers = pickRandomLottoNumbers();
            Lotto lotto = new Lotto(numbers);
            totalLottoTickets.add(lotto);
        }
    }

    static List<Integer> pickRandomLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers;
    }


    static void printingLottoTickets() {
        System.out.println(String.format("%d개를 구매했습니다.", ticketNumber));
        for (Lotto lotto: totalLottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    static public int getMoney() {
        return money;
    }

}
