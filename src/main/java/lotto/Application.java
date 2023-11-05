package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        // 1. 구입 금액 입력
        System.out.println("구입금액을 입력해 주세요.");
        String inputString = Console.readLine();

        if (!inputString.matches("\\d+")) { // 입력 문자열이 숫자로만 구성되어 있는지 검사
            System.out.println("[ERROR] 올바른 숫자를 입력해 주세요.");
            return;
        }

        int purchase_amount = Integer.parseInt(inputString);
        if (purchase_amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        System.out.println();


        // 2. 로또 발행
        List<List<Integer>> purchase_lottos = new ArrayList<>();
        int purchase_count = purchase_amount / 1000;
        for (int i=0; i<purchase_count; i++) {
            List<Integer> tempNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> numbers = new ArrayList<>(tempNumbers);
            numbers.sort(null);
            purchase_lottos.add(numbers);
        }

        // 3. 로또 발행 내역 출력
        System.out.printf("%d개를 구매했습니다.%n", purchase_count);
        for (List<Integer> lotto : purchase_lottos) {
            System.out.println(lotto);
        }

        // 4. 당첨 번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] stringNumbers = Console.readLine().split(",");
        ArrayList<Integer> win_lottos = Arrays.stream(stringNumbers)
                .map(Integer::parseInt).sorted().collect(Collectors.toCollection(ArrayList::new));
        if (win_lottos.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        if (win_lottos.stream().distinct().count() != win_lottos.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
        }
        if (win_lottos.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이여야 합니다.");
        }
        System.out.println();

        // 5. 보너스 번호 입력
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus_lotto = Integer.parseInt(Console.readLine());
        if (bonus_lotto < 1 || bonus_lotto > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (win_lottos.contains(bonus_lotto)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        System.out.println();

        // 6. 구매 번호와 당첨 번호 비교
        List<Integer> matches = new ArrayList<>();
        for (List<Integer> lotto : purchase_lottos) {
            int match_count = 0;
            match_count += (int) lotto.stream()
                    .filter(win_lottos::contains)
                    .count();
            matches.add(match_count);
        }

        List<Integer> win_counts = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

        for (int i = 0; i < matches.size(); i++) {
            int match_count = matches.get(i);

            if (match_count == 3) {
                win_counts.set(0, win_counts.get(0) + 1);
            }
            if (match_count == 4) {
                win_counts.set(1, win_counts.get(1) + 1);
            }
            if (match_count == 5 && purchase_lottos.get(i).contains(bonus_lotto)) {
                win_counts.set(2, win_counts.get(2) + 1);
            }
            if (match_count == 5 && !purchase_lottos.get(i).contains(bonus_lotto)) {
                win_counts.set(3, win_counts.get(3) + 1);
            }
            if (match_count == 6) {
                win_counts.set(4, win_counts.get(5) + 1);
            }
        }
        int total_return = 5000 * win_counts.get(0)
                + 50000 * win_counts.get(1)
                + 1500000 * win_counts.get(2)
                + 30000000 * win_counts.get(3)
                + 2000000000 * win_counts.get(4);

        // 7. 당첨 내역 출력
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", win_counts.get(0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", win_counts.get(1));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", win_counts.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", win_counts.get(3));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", win_counts.get(4));

        // 8. 수익률 출력
        float return_rate = ((float) total_return / purchase_amount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.", return_rate);
    }
}