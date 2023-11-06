package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        int money = user.inputMoney();
        List<List<Integer>> lottoNumbers = user.generateLottoNumber(money);
        List<Integer> answerNum = user.inputAnswer();
        int bonus = user.inputBonusNumber();

        Lotto lotto = new Lotto(answerNum);
        lotto.calLottoResult(lottoNumbers, bonus, money);

    }


}
