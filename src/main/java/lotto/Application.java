package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private final User user;
    private final LottoGame lottoGame;

    public Application(User user, LottoGame lottoGame) {
        this.user = user;
        this.lottoGame = lottoGame;
    }

    public void run() {
        int severalLottos;

        System.out.println("구입금액을 입력해 주세요.");
        int allLottoPay = Integer.parseInt(Console.readLine());
        severalLottos = user.inputAmount(allLottoPay);

        System.out.println(severalLottos + "개를 구매했습니다.");
        List<Lotto> lottos = user.saveLottos();
        lottoGame.printLottos(lottos);

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        lottoGame.inputLottoNumbers(winningNumbers);
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        System.out.println();

        System.out.println("당첨 통계\n---");
        lottoGame.checkPrizeNumber(lottos, bonusNumber);
    }

    public static void main(String[] args) {
        User user = new User();
        LottoGame lottoGame = new LottoGame();
        Application app = new Application(user, lottoGame);

        try {
            app.run();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

}
