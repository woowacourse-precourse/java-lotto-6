package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class Prompt {
    public static String forInputMoney() {
        System.out.println("구입금액을 입력해주세요");
        String money = readLine();

        return money;
    }

    public static String forInputLottoNumbers() {
        System.out.println("당첨 번호를 입력해주세요");
        String lottoNumber = readLine();

        return lottoNumber;
    }
}
