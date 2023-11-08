package lotto;

import java.util.List;

public class Player {
    private final PlayerLotto playerLotto;
    private final int purchaseAmount;

    private Player(PlayerLotto playerLotto, int purchaseAmount) {
        this.playerLotto = playerLotto;
        this.purchaseAmount = purchaseAmount;
    }

    public static Player initialize(int purchaseAmount) {
        validateRange(purchaseAmount);
        validateUnit(purchaseAmount);

        return new Player(new PlayerLotto(), purchaseAmount);
    }


    private static void validateRange(int purchaseAmount) {
        if (purchaseAmount < LottoConfig.PURCHASING_UNIT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_AMOUNT.getMessage());
        }
    }

    private static void validateUnit(int purchaseAmount) {
        if (purchaseAmount % LottoConfig.PURCHASING_UNIT.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_AMOUNT.getMessage());
        }
    }

    public int getPurchaseQuantity() {
        return purchaseAmount / LottoConfig.PURCHASING_UNIT.getValue();
    }

    public void buyLotto() {
        playerLotto.publish(getPurchaseQuantity());
    }

    public void outputLottoInfo() {
        System.out.printf(LottoMessage.LOTTO_PURCHASE_QUANTITY.getMessage(), getPurchaseQuantity());
        System.out.printf(playerLotto.getAllLottoInfo());
    }

    public ResultDTO calculateResult(WinningNumber winningNumber) {
        List<Integer> result = playerLotto.calculateResult(winningNumber);
        List<Boolean> bonusCount = playerLotto.bonusResult(winningNumber);

        return new ResultDTO(result, bonusCount);
    }
}
