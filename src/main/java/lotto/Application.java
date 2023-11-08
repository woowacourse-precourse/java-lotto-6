package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // 구입 금액 입력
            System.out.println("구입금액을 입력해 주세요.");
            int purchaseAmount = scanner.nextInt();
            int numberOfLottoTickets = purchaseAmount / 1000;

            // 로또 번호 생성 및 출력
            List<Lotto> lottos = generateLottoNumbers(numberOfLottoTickets);
            System.out.println(numberOfLottoTickets + "개를 구매했습니다.");
            for (Lotto lotto : lottos) {
                System.out.println(lotto);
            }

            // 당첨 번호 및 보너스 번호 입력
            System.out.println("당첨 번호를 입력해 주세요.");
            List<Integer> winningNumbers = readNumbers(scanner);
            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber = scanner.nextInt();

            // 당첨 결과 계산 및 출력
            LottoResult lottoResult = calculateResult(lottos, winningNumbers, bonusNumber);
            System.out.println("당첨 통계");
            System.out.println("----");
            System.out.println(lottoResult);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private static List<Lotto> generateLottoNumbers(int numberOfTickets) {
        return new ArrayList<>(numberOfTickets).stream()
                .map(i -> new Lotto(Lotto.generateRandomNumbers()))
                .collect(Collectors.toList());
    }

    private static List<Integer> readNumbers(Scanner scanner) {
        String input = scanner.next();
        String[] numbers = input.split(",");
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static LottoResult calculateResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.calculateMatch(winningNumbers, bonusNumber))
                .collect(Collectors.toList())
                .stream()
                .reduce(LottoResult::merge)
                .orElse(new LottoResult());
    }

}
