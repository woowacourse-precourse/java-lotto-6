package lotto.v2.controller;

import lotto.v2.model.LottoMachineV2;
import lotto.v2.model.LottoResultV2;
import lotto.v2.model.LottoV2;
import lotto.v2.model.WinningLottoV2;
import lotto.v2.view.LottoViewV2;

import java.util.ArrayList;
import java.util.List;

public class LottoControllerV2 {
    private static final int LOTTO_PRICE = 1000;
    private final LottoMachineV2 lottoMachine;
    private final LottoViewV2 lottoView;

    public LottoControllerV2(LottoMachineV2 lottoMachine, LottoViewV2 lottoView) {
        this.lottoMachine = lottoMachine;
        this.lottoView = lottoView;
    }

    public void play() {
        int purchaseAmount = getValidPurchaseAmount();
        List<LottoV2> purchasedLottos = purchaseLottos(purchaseAmount);
        WinningLottoV2 winningLotto = getWinningLotto();

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
                System.out.println("[ERROR] " + e.getMessage() + " 다시 입력해주세요.");
            }
        }
        return purchaseAmount;
    }

    private List<LottoV2> purchaseLottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");

        List<LottoV2> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; ++i) {
            LottoV2 lotto = lottoMachine.generateLotto();
            purchasedLottos.add(lotto);
            System.out.println(lotto.getNumbers());
        }
        return purchasedLottos;
    }

    private WinningLottoV2 getWinningLotto() {
        while (true) {
            try {
                List<Integer> winningNumbers = lottoView.inputWinningNumbers();
                int bonusNumber = lottoView.inputBonusNumber(winningNumbers);
                return new WinningLottoV2(winningNumbers, bonusNumber);
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
    private void checkResults(List<LottoV2> purchasedLottos, WinningLottoV2 winningLotto) {
        LottoResultV2 lottoResult = new LottoResultV2();
        lottoResult.calculateResults(purchasedLottos, winningLotto.getLotto(), winningLotto.getBonusNumber());

        lottoResult.printStatistics();
//        double yield = lottoResult.calculateYield(LOTTO_PRICE, purchasedLottos.size());
//        System.out.printf("총 수익률은 %.2f%%입니다.\n", yield);
    }

}
