package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        final String START = "구입금액을 입력해 주세요.";
        final String WIN_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
        final String WIN_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
        System.out.println( START );
        String price = Console.readLine();

        User user = new User();
        user.validateInputPrice( price );

        int lottoNum = user.lottoNumber( price );
        final String BUY_LOTTO = "\n" + lottoNum + "개를 구매했습니다.";
        System.out.println( BUY_LOTTO );

        List<List<Integer>> userLotto = user.makeUserLotto( lottoNum );
        user.printUserLotto( userLotto );

        List<Integer> wonLottoNumber = new ArrayList<>();
        System.out.println( "\n" + WIN_LOTTO_NUMBER );
        String winNumber = Console.readLine();

        Lotto lotto = new Lotto();
        lotto.validateLottoNumber( winNumber );

        System.out.println( "\n" + WIN_BONUS_NUMBER );
        String bonusNumber = Console.readLine();



    }
}
