package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class LottoHandler {

    private final LottoManager lottoManager;

    public LottoHandler(LottoManager lottoManager) {
        this.lottoManager = lottoManager;
    }

    void run() {
        System.out.println("구입금액을 입력해 주세요.");

        Lottos lottos = lottoManager.createLottos(inputMoney());
        WinningLotto winningLotto = lottoManager.createWinningLotto(inputWinningNumbers(), inputBonusNumbers());

        System.out.println(lottos.size() + "개를 구매했습니다.");
        System.out.println(lottos);


        lottoManager.calculateLottos(lottos, winningLotto);
    }

    private List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String inputWinningNumbers = Console.readLine();
                String[] split = inputWinningNumbers.split(",");
                if (split.length != Lotto.LOTTO_NUMBER_SIZE) {
                    throw new IllegalArgumentException("[ERROR] 로또 숫자는 6개만 입력이 가능합니다.");
                }
                return Arrays.stream(split).map(Integer::parseInt).toList();
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 당첨 번호는 숫자만 입력할 수 있습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private int inputBonusNumbers() {
        while (true) {
            try {
                System.out.println("보녀스 번호를 입력해 주세요.");
                String inputBonusNumber = Console.readLine();
                return Integer.parseInt(inputBonusNumber);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 숫자만 입력할 수 있습니다.");
            }
        }
    }

    private int inputMoney() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 로또 구입 금액은 숫자여야 합니다.");
            throw e;
        }
    }
}
