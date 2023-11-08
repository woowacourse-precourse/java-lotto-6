package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoMoney {
    private static final int LOTTO_MONEY_UNIT = 1000;
    private static final String ERROR_MESSAGE = "[ERROR]";

    protected final int money;

    public LottoMoney() {
        this.money = purchaseLotto();
    }

    private static int purchaseLotto() {
        try {
            System.out.println("구매금액을 입력해 주세요.");
            int lottoMoney = inputLottoMoney();
            validateLottoMoney(lottoMoney);

            return lottoMoney;
        } catch (IllegalArgumentException e) {
            return purchaseLotto();
        }
    }

    private static int inputLottoMoney() {
        try {
            int lottoMoney = Integer.parseInt(Console.readLine());
            return lottoMoney;
        } catch (NumberFormatException exception) {
            System.out.println(ERROR_MESSAGE + " 숫자만 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void validateLottoMoney(int lottoMoney) {
        if (lottoMoney % LOTTO_MONEY_UNIT != 0) {
            System.out.println(ERROR_MESSAGE + " 구매금액은 1000원 단위여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
