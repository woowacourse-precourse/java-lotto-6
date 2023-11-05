package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.validator.TypeMismatchValidator;

import java.util.List;

public class LotteryGame {

    private final Merchant merchant;
    private final LotteryMachine machine;

    public LotteryGame(Merchant merchant, LotteryMachine machine) {
        this.merchant = merchant;
        this.machine = machine;
    }

    public void start() {
        // TODO: 로또게임 시작
        User user = makeUserInfo();

    }

    private void pickNumbers() {
        makeUserInfo();
        makeWinningInfo();
    }

    private User makeUserInfo() {
        int price = getUserPrice();
        return User.of(getUserLottoNumbers(price));
    }

    private List<Lotto> getUserLottoNumbers(int price) {
        return merchant.getLotteryNumberWith(price);
    }

    private int getUserPrice() {
        System.out.println("구입 금액을 입력해주세요");
        String input = Console.readLine();
        TypeMismatchValidator.validateInputInteger(input);
        int price = Integer.parseInt(input);
        return price;
    }

    private void makeWinningInfo() {

    }


}
