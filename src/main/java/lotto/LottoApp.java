package lotto;

import camp.nextstep.edu.missionutils.Console;
import exception.BusinessException;
import exception.ErrorCode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoApp {
    private final int PRICE_LOTTO = 1000;
    private final LottoPlayer player;
    private final LottoAdmin admin;

    public LottoApp(LottoPlayer player, LottoAdmin admin) {
        this.player = player;
        this.admin = admin;
    }

    public void playGame() {
        player.buyLottos(getPurchaseMoney() / PRICE_LOTTO);
        admin.setWinningNumbers(getWinningNumbers());
        admin.setBonusNumber(getBonusNumber());

        admin.checkLottos(player);
        admin.printPrize(player);
        admin.payPrizeMoney(player);
        player.printRateOfProfit(PRICE_LOTTO);
    }

    private int getPurchaseMoney() {
        System.out.println("구입금액을 입력해주세요.");
        try {
            int money = Integer.parseInt(Console.readLine());
            if (money % PRICE_LOTTO != 0) throw new BusinessException(ErrorCode.MoneyInputError);
            return money;
        } catch (NumberFormatException ne) {
            System.out.println("[ERROR]숫자를 입력해야 합니다.");
        } catch (BusinessException be) {
            System.out.println(be.getMessage());
        }
        return getPurchaseMoney();
    }

    private List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            String[] strings = Console.readLine().split(",");
            if (strings.length != 6) throw new BusinessException(ErrorCode.WinningNumberInputError);
            return Arrays.stream(strings)
                    .map(Integer::parseInt)
                    .map(this::validateLottoNumber)
                    .collect(Collectors.toList());
        } catch (NumberFormatException ne) {
            System.out.println("[ERROR]숫자를 입력해야 합니다.");
        } catch (BusinessException be) {
            System.out.println(be.getMessage());
        }
        return getWinningNumbers();
    }

    private Integer getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            int bonusNumber = Integer.parseInt(Console.readLine());
            validateLottoNumber(bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException ne) {
            System.out.println("[ERROR]숫자를 입력해야 합니다.");
        } catch (BusinessException be) {
            System.out.println(be.getMessage());
        }
        return getBonusNumber();
    }

    private int validateLottoNumber(int number) throws BusinessException {
        if (number < 1 || number > 45) throw new BusinessException(ErrorCode.LottoNumberInputError);
        return number;
    }
}
