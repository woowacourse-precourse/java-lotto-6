package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class User {

    final String PRICE_ERROR = "[ERROR] 로또 구입 금액은 1,000원 단위로 입력해주세요.";
    final String FORMAT_ERROR = "[ERROR] 로또 구입 금액은 숫자로만 입력이 가능합니다.";

    public void validateInputPrice( String inputPrice ) {

        int price = 0;

        try {

            price = Integer.parseInt( inputPrice );

        } catch ( NumberFormatException e ) {

            throw new IllegalArgumentException( FORMAT_ERROR );
        }

        int count = price % 1000;

        if ( count != 0 ) {

            throw new IllegalArgumentException( PRICE_ERROR );
        }
    }

    public int lottoNumber ( String price ) {

        return Integer.parseInt( price ) / 1000;
    }

    private List<Integer> createLottoNumbers() {

        List<Integer> lottoNumbers = new ArrayList<>();

        for ( int i = 0; i < 7; i++ ){
            int randomNumber;

            do {
                randomNumber = new Random().nextInt(45) + 1;
            } while ( lottoNumbers.contains( randomNumber ) );

            lottoNumbers.add( randomNumber );
        }

        Collections.sort( lottoNumbers );

        return lottoNumbers;
    }

    public List<List<Integer>> makeUserLotto( int number ) {

        List<List<Integer>> userLotto = new ArrayList<>();

        for ( int i = 0; i < number; i++ ) {

            userLotto.add( this.createLottoNumbers() );
        }
        return userLotto;
    }

    public void printUserLotto( List<List<Integer>> lotto ) {

        for ( int i = 0; i < lotto.size(); i++ ) {

            List<Integer> lottoTicket = lotto.get(i);

            System.out.println( lottoTicket );
        }
    }
}
