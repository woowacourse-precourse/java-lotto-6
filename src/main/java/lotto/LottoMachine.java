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
    static private List<Lotto> totalLottoTickets = new ArrayList<Lotto>(); // 구입한 로또 리스트

    // 수익률 계산을 위한 필드 + 초기화
    static int firstPlace = 0; // 6개
    static int secondPlace = 0; // 5개
    static int thirdPlace = 0; // 5개 + 보너스
    static int fourthPlace = 0; // 4개

    static int fifthPlace = 0; // 3개

    static int profit;

    static void receivingMoney() {          // 구입 금액을 입력받는 메소드
        System.out.println("구입 금액을 입력해 주세요.");
        String input = Console.readLine();
        money = Integer.parseInt(input);
        validateMoney();
    }

    static void validateMoney() {           // 구입 금액의 유효성을 검증하는 메소드
        try {
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
            } else if (money < 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 양수여야 합니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            receivingMoney();
        }
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
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    static void printingLottoTickets() {           // 로또 내역을 프린트하는 메소드
        System.out.println(String.format("%d개를 구매했습니다.", ticketNumber));
        for (Lotto lotto: totalLottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    static void calculate() {
        int bonusNumber = WinningNumber.bonusNumber;
        for (Lotto lotto: totalLottoTickets) {
            int temp_num = compare(lotto);
            if (temp_num == 3) {
                fifthPlace += 1;
            } else if (temp_num == 4) {
                fourthPlace += 1;
            } else if (temp_num == 5) {
                if (lotto.getNumbers().contains(bonusNumber)) { // depth 수정 필요
                    secondPlace += 1;
                } else {
                    thirdPlace += 1;
                }
            } else if (temp_num == 6) {
                firstPlace += 1;
            }
        }
    }

    static int compare(Lotto lotto) {

        List<Integer> winningNumber = WinningNumber.winningNumbers;

        // 집합으로 변경
        Set<Integer> winningSet = new HashSet<Integer>(winningNumber);
        Set<Integer> lottoSet = new HashSet<Integer>(lotto.getNumbers());

        // 교집합 구하기
        winningSet.retainAll(lottoSet);

        // 교집합 개수 반환
        return winningSet.size();
    }

    static void calculateProfit() {
        profit = 2000000000*firstPlace + 30000000*secondPlace + 1500000*thirdPlace + 50000*fourthPlace + 5000*fifthPlace;
    }
    static void printResult() {

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(String.format("3개 일치 (5,000원) - %d개", fifthPlace));
        System.out.println(String.format("4개 일치 (50,000원) - %d개", fourthPlace));
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개", thirdPlace));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", secondPlace));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개", firstPlace));
        System.out.println(String.format("총 수익률은 %s%%입니다.", String.format("%.1f", ((double)profit/money) * 100)));
    }

    static public int getMoney() {
        return money;
    }

    static public void setMoney(int money) {
        money = money;
    }


}
