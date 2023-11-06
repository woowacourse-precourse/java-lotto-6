package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final LottoMachine lottoMachine;
    private final LottoView lottoView;

    public LottoController(LottoMachine lottoMachine, LottoView lottoView) {
        this.lottoMachine = lottoMachine;
        this.lottoView = lottoView;
    }

    public void play() {
        int purchaseAmount = getValidPurchaseAmount();
        List<Lotto> purchasedLottos = purchaseLottos(purchaseAmount);
        Lotto winningLotto = getWinningLotto();

        // TODO: 당첨 결과 계산 및 출력
        checkResults(purchasedLottos, winningLotto);
    }

    private int getValidPurchaseAmount() {
        int purchaseAmount;
        while (true) {
            try {
                purchaseAmount = lottoView.inputMoney();
                validatePurchaseAmount(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }

    private List<Lotto> purchaseLottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");

        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; ++i) {
            Lotto lotto = lottoMachine.generateLotto();
            purchasedLottos.add(lotto);
            System.out.println(lotto.getNumbers());
        }
        return purchasedLottos;
    }

    private Lotto getWinningLotto() {
        while (true) {
            try {
                List<Integer> winningNumbers = lottoView.inputWinningNumbers();
                return new Lotto(winningNumbers);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식이 올바르지 않습니다. 다시 시도해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 잘못된 입력입니다. 다시 시도해주세요.");
            }
        }
    }

    public void runMachine(int purchaseAmount) {
        int lottoCount = purchaseAmount / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");

        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; ++i) {
            Lotto lotto = lottoMachine.generateLotto();
            purchasedLottos.add(lotto);
            System.out.println(lotto.getNumbers());
        }
        // TODO: 당첨 번호 입력받기, 당첨 결과 계산 및 출력 등의 로직을 추가할 예정.
    }

    private void validatePurchaseAmount(int money) {
        if (money < 1000 || money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위의 정수여야 합니다.");
        }
    }
    private void checkResults(List<Lotto> purchasedLottos, Lotto winningLotto) {
        // TODO: 당첨 결과를 계산하고 출력하는 로직을 구현해야 함.
    }


}
