package lotto;

import java.util.List;

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
        severalLottos = user.inputAmount();
        System.out.println(severalLottos + "개를 구매했습니다.");

        List<Lotto> lottos = user.saveLottos();
        lottoGame.printLottos(lottos);

        System.out.println("당첨 번호를 입력해 주세요.");
        lottoGame.inputLottoNumbers();
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        lottoGame.inputBonusNumber();
        System.out.println();

        System.out.println("당첨 통계\n---");

        lottoGame.checkNumber(lottos);

    }

    public static void main(String[] args) {
        User user = new User();
        LottoGame lottoGame = new LottoGame();
        Application app = new Application(user, lottoGame);

        app.run();
    }


}
