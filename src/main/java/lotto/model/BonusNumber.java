package lotto.model;

public class BonusNumber {

    private final int MIN_INCLUSIVE = 1;
    private final int MAX_INCLUSIVE = 45;
    private final int MAX_SIZE = 2;

    private final int value;

    public BonusNumber(final String number, Lotto lotto){
        validate(number.replace(" ",""),lotto);
        value = Integer.parseInt(number);
    }

    public int getValue(){
        return value;
    }

    private void validate(String number, Lotto lotto){
        if(isEmpty(number)){
            throw new IllegalArgumentException();
        }

        if(isSizeOverTwo(number)){
            throw new IllegalArgumentException();
        }

        if(!isDigit(number)){
            throw new IllegalArgumentException();
        }

        if(!isBetweenOneAndFortyFive(number)){
            throw new IllegalArgumentException();
        }

        if(isDuplicatedWinningLottoNumber(lotto,number)){
            throw new IllegalArgumentException();
        }
    }

    private boolean isEmpty(String number){
        return number.isBlank() || number == null;
    }

    private boolean isSizeOverTwo(String number){
        return number.length() > MAX_SIZE;
    }

    private boolean isDigit(String number){
        return Character.isDigit(number.charAt(0));
    }

    private boolean isBetweenOneAndFortyFive(String number){
        return Integer.parseInt(number) >= MIN_INCLUSIVE && Integer.parseInt(number) <= MAX_INCLUSIVE;
    }

    private boolean isDuplicatedWinningLottoNumber(Lotto winningLotto, String number){
        return winningLotto.getNumbers().contains(Integer.parseInt(number));
    }
}
