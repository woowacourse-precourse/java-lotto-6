package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Match;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.view.LottoView;

public class LottoController {

    LottoService lottoService = new LottoServiceImpl();
    LottoView lottoView = new LottoView();

    private final int LOTTO_PRICE = 1000;
    private int price;

    public void run() {
        this.price = 0;

        inputBuyPrice();
        outputBoughtLotto();
        inputWinLotto();
        outputWinStats();
    }

    public void inputBuyPrice() {
        lottoView.guidePrice();
        try {
            this.price = Integer.parseInt(Console.readLine());

            lottoService.buyLotto(price / LOTTO_PRICE);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("[ERROR] 금액은 숫자를 입력해주세요.");
            inputBuyPrice();
        }
    }

    public void outputBoughtLotto() {
        lottoView.showBoughtLotto(price / LOTTO_PRICE, lottoService.boughtLottoList());
    }

    public void inputWinLotto() {
        try {
            Lotto winLotto = new Lotto(inputWinLottoNumber());
            int bonusNum = inputBonusNum();

            if (winLotto.isContainNum(bonusNum)) {
                throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨 번호와 중복되지 않게 입력해주세요.");
            }

            lottoService.setAnswer(winLotto, bonusNum);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            inputWinLotto();
        }
    }

    private List<Integer> inputWinLottoNumber() {
        List<Integer> winLottoList = new ArrayList<>();

        lottoView.guideWinLotto();
        try {
            String winLotto = Console.readLine();
            winLottoList = Stream.of(winLotto.split(",")).mapToInt(Integer::parseInt).boxed().toList();

        } catch (NumberFormatException numberFormatException) {
            System.out.println("[ERROR] 로또 번호는 숫자로 입력해주세요.");
            inputWinLottoNumber();
        }
        return winLottoList;
    }

    private int inputBonusNum() {
        int bonusNum = 0;

        lottoView.guideBonusNum();
        try {
            bonusNum = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            System.out.println("[ERROR] 보너스 번호는 숫자를 입력해주세요.");
            inputBonusNum();
        }
        return bonusNum;
    }

    public void outputWinStats() {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Match match : Match.values()) {
            lottoView.showWinStats(match, lottoService.countMatch(match));
        }

        lottoView.showYield(lottoService.calculateYield(price));
    }
}
