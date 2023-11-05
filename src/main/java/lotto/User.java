package lotto;

public class User {

    final String PRICE_ERROR = "[ERROR] 로또 구입 금액은 1,000원 단위로 입력해주세요.";
    final String FORMAT_ERROR = "[ERROR] 로또 구입 금액은 숫자로만 입력이 가능합니다.";

    public void validateBuyLotto( String inputPrice ) {

        int price = 0;

        try {

            price = Integer.parseInt( inputPrice );

        } catch ( NumberFormatException e ) {

            System.out.println( FORMAT_ERROR );
        }

        int count = price % 1000;

        if ( count != 0 ) {

            System.out.println( PRICE_ERROR );
        }
    }
}
