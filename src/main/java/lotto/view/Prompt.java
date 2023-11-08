package lotto.view;

import lotto.entity.Lotto;
import lotto.entity.LottoResult;
import lotto.entity.User;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.utilTest.Validator.validateBonusNumber;


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
        System.out.println(size + "개를 구매했습니다.");
        boughtLotto.stream().forEach(a -> System.out.println(a.getNumbers()));
    }

    public static Integer forInputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해주세요");
        String string = readLine();
        Integer bonusNumber = validateBonusNumber(string);
        return bonusNumber;
    }

    public static void showResult(LottoResult lottoResult, User user) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoResult.getNumberOf_3Correction()+"개");
        System.out.println("4개 일치 (50,000원) - " + lottoResult.getNumberOf_4Correction() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.getNumberOf_5Correction() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.getNumberOf_5CorrectionAndBonus() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResult.getNumberOf_6Correction() + "개");
        System.out.println("총 수익률은 " + lottoResult.getProfitRate(user.getMoney()) + "%입니다.");
    }
}
