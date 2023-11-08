package lotto.presentation;

import camp.nextstep.edu.missionutils.Console;
import lotto.application.LottoService;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.User;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private final LottoService lottoService;


    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void startGame() {
        User user = purchaseLotto();
        printUserLottos(user);
        WinningLotto winningLotto = makeWinningLotto();
        printResult(user, winningLotto);
    }

    private User purchaseLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        while(true) {
            try {
                User user = lottoService.purchaseLotto(Integer.parseInt(Console.readLine()));
                System.out.println();
                return user;
            } catch (NumberFormatException ex) {
                System.out.println("[ERROR] 1000단위로 떨어지는 숫자를 입력해주세요.");;
            }
        }
    }

    private void printUserLottos(User user) {
        List<Lotto> lottos = user.getLottos();

        System.out.printf("%d개를 구매했습니다.", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }



    private WinningLotto makeWinningLotto() {
        while(true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                List<Integer> input = Arrays.stream(Console.readLine().split(",")).mapToInt(Integer::parseInt).boxed().toList();


                System.out.println();
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNumber = Integer.parseInt(Console.readLine());

                System.out.println();
                return lottoService.makeWinningLotto(new Lotto(input), bonusNumber);
            } catch (NumberFormatException ex) {
                System.out.println("[ERROR] 로또는 1,2,3,4,5,6 형태로 입력해주세요. 그리고 숫자만 입력해주세요.");
            } catch (IllegalArgumentException ex) {
                System.out.println("[ERROR] 1~45 사이 숫자만 입력해주세요. 중복되지 않게 입력해주세요.");
            }
        }
    }

    private void printResult(User user, WinningLotto winningLotto) {
        EnumMap<LottoResult, Integer> result = user.getLottoResultsAndSetRateOfReturn(winningLotto);
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("%s - %d개\n", LottoResult.FIFTH.getMessage(), result.get(LottoResult.FIFTH));
        System.out.printf("%s - %d개\n", LottoResult.FOURTH.getMessage(), result.get(LottoResult.FOURTH));
        System.out.printf("%s - %d개\n", LottoResult.THIRD.getMessage(), result.get(LottoResult.THIRD));
        System.out.printf("%s - %d개\n", LottoResult.SECOND.getMessage(), result.get(LottoResult.SECOND));
        System.out.printf("%s - %d개\n", LottoResult.FIRST.getMessage(), result.get(LottoResult.FIRST));
        System.out.printf("총 수익률은 %.1f%%입니다.", user.getRateOfReturn());
    }
}
