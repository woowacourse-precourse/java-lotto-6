package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto() {
        numbers = new ArrayList<>();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void validateBonusNumber( String number, List<Integer> lotto ) {

        this.checkNameValid( number );
        this.checkNumberRange( number );
        this.checkIsEmpty( number );
        this.checkIsDuplicateBonusWithLotto( number, lotto );
    }

    public void validateLottoNumber ( String number ) {
        List<String> lotto = List.of( number.split(",", -1) );

        this.checkLottoNumberCount( lotto );

        for ( String lottoNumber : lotto ) {

            this.checkNameValid( lottoNumber );
            this.checkNumberRange( lottoNumber );
            this.checkIsEmpty( lottoNumber );
        }
        this.checkIsDuplicate( lotto );

    }

    private void checkNameValid( String number ) {
        try {

            Integer.parseInt( number );

        } catch ( NumberFormatException e ) {

            throw new IllegalArgumentException( "[ERROR] 숫자로만 이루어진 로또번호를 입력해주세요." );
        }
    }
    private void checkNumberRange( String number ) {

        int lottoNumber = Integer.parseInt( number );

        if ( 1 > lottoNumber || lottoNumber > 45 ) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자를 입력해주세요.");
        }
    }

    private void checkIsEmpty( String number ) {

        if ( number.trim().isEmpty() ) {
            throw new IllegalArgumentException("[ERROR] 로또 값을 입력해주세요.");
        }
    }

    private void checkIsDuplicate( List<String> number ) {

        int originSize = number.size();
        int removeDuplicate = (int) number.stream().distinct().count();

        if ( originSize != removeDuplicate ) {
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 존재할 수 없습니다.");
        }
    }

    private void checkIsDuplicateBonusWithLotto( String bonus, List<Integer> lotto ) {

        for ( Integer num : lotto ) {
            if ( num.equals( Integer.parseInt( bonus ) ) ) {

                throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 존재할 수 없습니다.");
            }
        }
    }

    private void checkLottoNumberCount( List<String> number ) {

        if ( number.size() != 6 ) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개를 입력해주세요.");
        }
    }
}
