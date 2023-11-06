package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import constValue.ConstMessage;
import constValue.ConstNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private Integer lottoGameCount;
    private List<Lotto> lottos;

    public LottoGame() {
        this.lottos = new ArrayList<>();
        System.out.println("구입금액을 입력해 주세요.");
        setLottoGameCount(enterPurchaseAmount());
        addLottos(getLottoGameCount());
        System.out.println(getLottoGameCount() + "개를 구매했습니다.");
        printLottos();
    }

    public Integer enterPurchaseAmount() {
        try {
            return Integer.parseInt(validatePurchaseAmount(Console.readLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(ConstMessage.PURCHASE_AMOUNT_INPUT_ERROR_MESSAGE.getMessage());
            return enterPurchaseAmount();
        }
    }

    private String validatePurchaseAmount(String purchaseAmount) throws IllegalArgumentException {
        if (purchaseAmount.matches("[1-9]+000")) {
            return purchaseAmount;
        }
        throw new IllegalArgumentException();
    }

    private Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(ConstNumber.MINIMUM_LOTTO_NUMBER.getValue(),
                ConstNumber.MAXIMUM_LOTTO_NUMBER.getValue(),
                ConstNumber.LOTTO_NUMBER_COUNT.getValue()));
    }

    private Integer getLottoGameCount() {
        return this.lottoGameCount;
    }

    private void setLottoGameCount(Integer lottoGameCount) {
        this.lottoGameCount = lottoGameCount / ConstNumber.LOTTO_PRICE.getValue();
    }

    private List<Lotto> getLottos() {
        return this.lottos;
    }

    private void addLottos(Integer lottoGameCount) {
        for (int index = 0; index < lottoGameCount; index++) {
            this.lottos.add(createLotto());
        }
    }

    private void printLottos() {
        for (Lotto lotto : this.lottos) {
            System.out.println(lotto.toString());
        }
    }
}
