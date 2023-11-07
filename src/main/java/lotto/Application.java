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

                System.err.println("[ERROR] 로또 구입 금액 에러");
            }
        }


        int lottoNum = user.lottoNumber( price );
        final String BUY_LOTTO = "\n" + lottoNum + "개를 구매했습니다.";
        System.out.println( BUY_LOTTO );

        List<List<Integer>> userLotto = user.makeUserLotto( lottoNum );
        user.printUserLotto( userLotto );

        List<Integer> wonLottoNumber = new ArrayList<>();
        Lotto lotto = new Lotto();

        isContinue = false;
        while( !isContinue ){

            System.out.println( "\n" + WIN_LOTTO_NUMBER );
            String winNumber = Console.readLine();

            try{

                lotto.validateLottoNumber( winNumber );

                List<String> inputLotto = List.of( winNumber.split(",", -1) );

                for ( String lottoNumber : inputLotto ) {

                    int number = Integer.parseInt( lottoNumber );

                    wonLottoNumber.add(number);
                }

                isContinue = true;

            } catch ( IllegalArgumentException e ) {

                System.err.println( e.getMessage() );
            }





        }

        isContinue = false;
        while( !isContinue ) {

            System.out.println( "\n" + WIN_BONUS_NUMBER );
            String bonusNumber = Console.readLine();

            try {

                lotto.validateBonusNumber( bonusNumber, wonLottoNumber );
                wonLottoNumber.add( Integer.parseInt( bonusNumber ));
                isContinue = true;

            } catch ( IllegalArgumentException e ) {

                System.err.println( e.getMessage() );
            }
        }

        //TODO 결과 출력
    }
}
