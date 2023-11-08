package lotto;

import camp.nextstep.edu.missionutils.Console;
import exception.BusinessException;
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
        admin.setBonusNumber(getBonusNumber(admin.getWinningNumbers()));

        admin.checkLottos(player);
        admin.printPrize(player);
        admin.payPrizeMoney(player);
        player.printRateOfProfit(PRICE_LOTTO);
    }

    private int getPurchaseMoney() {
        System.out.println("구입금액을 입력해주세요.");
        try {
            int money = Integer.parseInt(Console.readLine());
            if (money % PRICE_LOTTO != 0)
                throw new IllegalArgumentException("[ERROR]1,000원으로 나누어 떨어지는 수를 입력해야 합니다.");
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
            return validateWinningNumbers(strings);
        } catch (NumberFormatException ne) {
            System.out.println("[ERROR]숫자를 입력해야 합니다.");
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
        }
        return getWinningNumbers();
    }

    private Integer getBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            int bonusNumber = Integer.parseInt(Console.readLine());
            return validateBonusNumber(winningNumbers, bonusNumber);
        } catch (NumberFormatException ne) {
            System.out.println("[ERROR]숫자를 입력해야 합니다.");
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
        }
        return getBonusNumber(winningNumbers);
    }

    private List<Integer> validateWinningNumbers(String[] strings) throws IllegalArgumentException {
        long distinctSize = Arrays.stream(strings)
                .distinct()
                .count();
        if (distinctSize != 6) throw new IllegalArgumentException("[ERROR]6개의 중복되지 않은 수를 입력해야 합니다.");

        return Arrays.stream(strings)
                .map(Integer::parseInt)
                .map(this::validateLottoNumber)
                .collect(Collectors.toList());
    }

    private int validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) throws IllegalArgumentException {
        if (winningNumbers.contains(bonusNumber)) throw new IllegalArgumentException("[ERROR]당첨 번호와 중복됩니다.");
        return validateLottoNumber(bonusNumber);
    }

    private int validateLottoNumber(int number) throws IllegalArgumentException {
        if (number < 1 || number > 45) throw new IllegalArgumentException("[ERROR]1-45 사이의 숫자를 입력해야 합니다.");
        return number;
    }
}
