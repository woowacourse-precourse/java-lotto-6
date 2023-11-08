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

    public int getResult( List<List<Integer>> userLotto ) {

        int FIRST = 0;
        int SECOND = 0;
        int THIRD = 0;
        int FORTH = 0;
        int FIFTH = 0;

        for ( List<Integer> list : userLotto ) {
            int count = 0;
            boolean isBonus = false;

            for ( Integer commons : list ){

                if ( numbers.contains( commons ) ) {
                    count++;
                }
            }

            if ( list.contains( numbers.get(numbers.size() - 1) ) ) {
                isBonus = true;
            }

            switch ( count ) {
                case 3:
                    FIFTH++;
                    break;
                case 4:
                    FORTH++;
                    break;
                case 5:
                    if ( isBonus )  SECOND++;
                    else THIRD++;
                    break;
                case 6:
                    FIRST++;
                    break;
            }
        }

        System.out.println(
                "3개 일치 (5,000원) - "+ FIFTH +"개\n" +
                "4개 일치 (50,000원) - "+ FORTH +"개 \n" +
                "5개 일치 (1,500,000원) - "+ THIRD +"개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - "+ SECOND +"개\n" +
                "6개 일치 (2,000,000,000원) - "+ FIRST +"개"
        );

        int totalIncome = 5000*FIFTH + 50000*FORTH + 1500000*THIRD + 30000000*SECOND + 2000000000*FIRST;
        return totalIncome;
    }

    public void makeWinLottoNumber ( String winNumber ) {

        this.validateLottoNumber( winNumber );

        List<String> inputLotto = List.of( winNumber.split(",", -1) );

        for ( String lottoNumber : inputLotto ) {

            int number = Integer.parseInt( lottoNumber );

             numbers.add(number);
        }
    }

    public void makeWinLottoBonus( String bonusNumber ) {

        this.validateBonusNumber( bonusNumber, numbers );
        numbers.add( Integer.parseInt( bonusNumber ));
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] ");
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
