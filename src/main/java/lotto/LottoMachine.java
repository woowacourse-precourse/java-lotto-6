package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoMachine {

    static private int money;       // 구입 금액
    static private int ticketNumber; // 구입 장 수
    static List<Lotto> totalLottoTickets = new ArrayList<Lotto>(); // 구입한 로또 리스트

    static void receivingMoney() {          // 구입 금액을 입력받는 메소드
        while (true) {
            System.out.println("구입 금액을 입력해 주세요.");
            String input = Console.readLine();
            if (validateMoney(input) && validateFormat(input)) {
                break;
            }
        }
    }

    static boolean validateFormat(String input) {
        try {
            money = Integer.parseInt(input);
            // 입력이 유효한 경우 true 반환
            return true;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자 형식이 잘못되었습니다: " + e.getMessage());
            return false;
        }
    }

    static boolean validateMoney(String input) {           // 구입 금액의 유효성을 검증하는 메소드
        try {
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
            } else if (money < 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 양수여야 합니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    static void givingLottoTickets() {      // 구입 금액만큼 로또를 생성하는 메소드
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


    static void printingLottoTickets() {           // 로또 내역을 프린트하는 메소드
        System.out.println(String.format("%d개를 구매했습니다.", ticketNumber));
        for (Lotto lotto: totalLottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    static public int getMoney() {
        return money;
    }

    static public void setMoney(int money) {
        money = money;
    }


}
