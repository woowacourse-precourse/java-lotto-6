package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class LottoBuyer {
    final String REQUEST_INPUT_MESSAGE = "구입 금액을 입력해 주세요.\n";
    final String PRINT_MY_LOTTOS = "%d개를 구매했습니다.\n";
    final int LOTTO_PURCHASE_UNIT = 1000;
    private int purchaseAmount;
    private ArrayList<Lotto> myLottos;
    ErrorMessages errorType;

    public LottoBuyer() {
        this.purchaseAmount = 0;
        this.myLottos = new ArrayList<Lotto>();
    }

    public void inputPurchaseAmount() {
        System.out.print(REQUEST_INPUT_MESSAGE);
        try {
            buyLotto(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
            inputPurchaseAmount();
        }
    }

    public int validateInputAmount(String inputAmount) {
        int resultAmount;
        try {
            resultAmount = Integer.parseInt(inputAmount);
        } catch (NumberFormatException e) {
            errorType = ErrorMessages.INPUT_IS_NOT_NUMBER;
            throw new IllegalArgumentException(errorType.getDescription());
        }

        if ((resultAmount % LOTTO_PURCHASE_UNIT) != 0 || (resultAmount < 0)) {
            errorType = ErrorMessages.INPUT_NOT_UNIT_MONEY;
            throw new IllegalArgumentException(errorType.getDescription());
        }

        return resultAmount;
    }

    public void buyLotto(String inputAmount) {
        purchaseAmount = validateInputAmount(inputAmount);
    }

    public void addMyLottos(Lotto publishedLotto) {
        myLottos.add(publishedLotto);
    }

    public ArrayList<Lotto> getMyLottos() {
        return myLottos;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int calculatePublishCount() {
        return purchaseAmount / LOTTO_PURCHASE_UNIT;
    }

    public void printMyLottos() {
        System.out.printf(PRINT_MY_LOTTOS, calculatePublishCount());

        for (Lotto lotto : myLottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
