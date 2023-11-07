package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // 로또 구입 금액을 입력 받습니다.
        int purchaseAmount;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                if (!input.matches("^\\d+$")) { // 입력 문자열이 숫자로만 이루어져 있는지 검사
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해야 합니다.");
                }
                purchaseAmount = Integer.parseInt(input);
                if (purchaseAmount % 1000 != 0) { // 구매 금액이 1000으로 나누어 떨어지지 않는 경우
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1000의 배수로 입력해야 합니다.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입 금액은 숫자로 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        int count = purchaseAmount / 1000;

        // 로또 티켓을 구매합니다.
        LottoTicket lottoTicket = new LottoTicket(count);
        System.out.println(count + "개를 구매했습니다.");
        lottoTicket.getLottos().forEach(lotto -> System.out.println(lotto.getNumbers()));

        // 당첨 번호와 보너스 번호를 입력 받습니다.
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = Stream.of(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());

        WinningNumbers winningNumbersObj = new WinningNumbers(winningNumbers, bonus);

        // 로또 게임을 실행합니다.
        LottoGame lottoGame = new LottoGame(lottoTicket, winningNumbersObj);
        lottoGame.play();
    }
}
