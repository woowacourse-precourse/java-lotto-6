package lotto.v1.controller;

import lotto.v1.model.LottoV1;
import lotto.v1.model.LottoMachineV1;
import lotto.v1.model.LottoResultV1;
import lotto.v1.view.LottoViewV1;
import lotto.v1.model.WinningLottoV1;

import java.util.ArrayList;
import java.util.List;

public class LottoControllerV1 {
    private static final int LOTTO_PRICE = 1000;
    private final LottoMachineV1 lottoMachine;
    private final LottoViewV1 lottoView;

    public LottoControllerV1(LottoMachineV1 lottoMachine, LottoViewV1 lottoView) {
        this.lottoMachine = lottoMachine;
        this.lottoView = lottoView;
    }

    public void play() {
        int purchaseAmount = getValidPurchaseAmount();
        List<LottoV1> purchasedLottos = purchaseLottos(purchaseAmount);
        WinningLottoV1 winningLotto = getWinningLotto();

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

    private List<LottoV1> purchaseLottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");

        List<LottoV1> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; ++i) {
            LottoV1 lotto = lottoMachine.generateLotto();
            purchasedLottos.add(lotto);
            System.out.println(lotto.getNumbers());
        }
        return purchasedLottos;
    }

    private WinningLottoV1 getWinningLotto() {
        while (true) {
            try {
                List<Integer> winningNumbers = lottoView.inputWinningNumbers();
                int bonusNumber = lottoView.inputBonusNumber(winningNumbers);
                return new WinningLottoV1(winningNumbers, bonusNumber);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식이 올바르지 않습니다. 다시 시도해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 잘못된 입력입니다. 다시 시도해주세요.");
            }
        }
    }

    private void validatePurchaseAmount(int money) {
        if (money < 1000 || money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위의 정수여야 합니다.");
        }
    }
    private void checkResults(List<LottoV1> purchasedLottos, WinningLottoV1 winningLotto) {
        LottoResultV1 lottoResult = new LottoResultV1();
        lottoResult.calculateResults(purchasedLottos, winningLotto.getLotto(), winningLotto.getBonusNumber());

        lottoResult.printStatistics();
        double yield = lottoResult.calculateYield(LOTTO_PRICE, purchasedLottos.size());
        System.out.printf("총 수익률은 %.2f%%입니다.\n", yield);
    }

}
