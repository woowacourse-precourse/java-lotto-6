package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        final String START = "구입금액을 입력해 주세요.";
        final String WIN_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
        final String WIN_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

        boolean isContinue = false;
        User user = new User();

        String price = "";

        while( !isContinue ) {

            System.out.println( START );
            price = Console.readLine();

            try{

                user.validateInputPrice( price );
                isContinue = true;
            } catch ( IllegalArgumentException e ) {

                System.out.println(e.getMessage());
            }
        }

        int lottoNum = user.lottoNumber( price );
        final String BUY_LOTTO = "\n" + lottoNum + "개를 구매했습니다.";
        System.out.println( BUY_LOTTO );

        List<List<Integer>> userLotto = user.makeUserLotto( lottoNum );
        user.printUserLotto( userLotto );

        Lotto lotto = new Lotto();

        isContinue = false;
        while( !isContinue ){

            try{

                System.out.println( "\n" + WIN_LOTTO_NUMBER );
                String winNumber = Console.readLine();

                lotto.makeWinLottoNumber( winNumber );
                isContinue = true;

            } catch ( IllegalArgumentException e ) {

                System.out.println( e.getMessage() );
            }
        }

        isContinue = false;
        while( !isContinue ) {

            try {
                System.out.println( "\n" + WIN_BONUS_NUMBER );
                String bonusNumber = Console.readLine();

                lotto.makeWinLottoBonus( bonusNumber );
                isContinue = true;

            } catch ( IllegalArgumentException e ) {

                System.out.println( e.getMessage() );
            }
        }

        int wonMoney = lotto.getResult( userLotto );
        int spentMoney = Integer.parseInt(price);

        double result = ((double) (wonMoney - spentMoney) / spentMoney ) * 100.0;
        if( result < 0 ) {
            result = 100 + result;
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        System.out.println( "총 수익률은 " + decimalFormat.format( result ) + "%입니다." );
    }
}
