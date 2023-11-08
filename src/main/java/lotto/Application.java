package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();

        System.out.println("구입금액을 입력해 주세요.");
        int money = user.inputMoney();
        List<List<Integer>> lottoNumbers = user.generateLottoNumber(money);
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto lotto = user.inputAnswer();
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = user.inputBonusNumber();
        System.out.println();

        lotto.calLottoResult(lottoNumbers, bonus, money);

    }


}
