package lotto;

import camp.nextstep.edu.missionutils.Console;
import exception.BusinessException;
import exception.ErrorCode;

public class LottoApp {
    private final int PRICE_LOTTO = 1000;
    private final LottoPlayer player;
    private final LottoAdmin admin;

    public LottoApp(LottoPlayer player, LottoAdmin admin) {
        this.player = player;
        this.admin = admin;
    }

    public void playGame() {
        int times = getPurchaseMoney() / PRICE_LOTTO;
        player.generateLottos(times);
        admin.checkLottos(player);
        admin.printPrize(player);
        admin.payPrizeMoney(player);
    }

    private int getPurchaseMoney() {
        System.out.println("구입금액을 입력해주세요.");
        String input = Console.readLine();
        try {
            int money = Integer.parseInt(input);
            if (money % PRICE_LOTTO != 0) throw new BusinessException(ErrorCode.MoneyInputError);
            return money;
        } catch (NumberFormatException ne) {
            System.out.println("[ERROR]숫자를 입력해야 합니다.");
        } catch (BusinessException be) {
            System.out.println(be.getMessage());
        }
        return getPurchaseMoney();
    }
}
