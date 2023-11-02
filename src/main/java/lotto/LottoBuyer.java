package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class LottoBuyer {
    final int LOTTO_PURCHASE_UNIT = 1000;
    private int purchaseAmount;
    private int purchaseLottoCount;
    private ArrayList<Lotto> myLottos;

    public LottoBuyer() {
        this.purchaseAmount = 0;
        this.purchaseLottoCount = 0;
        this.myLottos = new ArrayList<>();
    }

    public void inputPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        buyLotto(Console.readLine());
    }

    public void buyLotto(String inputAmount) {
        purchaseAmount = validateInputAmount(inputAmount);
    }

    public int validateInputAmount(String inputAmount) {
        int resultAmount;
        try {
            resultAmount = Integer.parseInt(inputAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if ((resultAmount % 1000) != 0 || (resultAmount < 0)) {
            throw new IllegalArgumentException();
        }

        return resultAmount;
    }

    public void addMyLottos(Lotto publishedLotto) {
        myLottos.add(publishedLotto);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int calculatePublishCount() {
        return purchaseAmount / LOTTO_PURCHASE_UNIT;
    }

    public ArrayList<Lotto> getMyLotts() {
        return myLottos;
    }
}
