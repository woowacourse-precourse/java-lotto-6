package lotto.view;

import lotto.entity.Lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.Validator.validateBonusNumber;


public class Prompt {
    public static String forInputMoney() {
        System.out.println("구입금액을 입력해주세요");
        String money = readLine();

        return money;
    }

    public static String forInputLottoNumbers() {
        System.out.println("\n당첨 번호를 입력해주세요");
        String lottoNumber = readLine();

        return lottoNumber;
    }

    public static void forShowLottoList(List<Lotto> boughtLotto) {
        int size = boughtLotto.size();
        System.out.println(size + "개를 구매하였습니다");
        boughtLotto.stream().forEach(a -> System.out.println(a.getNumbers()));
    }

    public static Integer forInputBonusNumber() {
        System.out.println("\n당첨 번호를 입력해주세요");
        String string = readLine();
        Integer bonusNumber = validateBonusNumber(string);
        return bonusNumber;
    }
}
