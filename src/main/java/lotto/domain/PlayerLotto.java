package lotto.domain;
//1.로또 구입금액 입력(1,000원 단위로 입력 && 나누어 떨어지지 않으면 예외처리)
//ex)8000원을 사면 8개 구매
import lotto.view.ExceptionMessage;
public class PlayerLotto {

    public static final int LOTTO_PRICE = 1000;
    private final int amount;


    public PlayerLotto(String amount) {
        int amountNum = validateNumber(amount);
        validateAmount(amountNum);
        this.amount = amountNum;
    }

    public int LottoCount(){
        return amount / LOTTO_PRICE;
    }

    private void validateAmount(int amount) {
        validateNatural(amount);
        validateDivisible(amount);
    }

    public static int validateNumber(String amount)throws IllegalArgumentException{
        try{
            return Integer.parseInt(amount);
        }catch (NumberFormatException e){
            ExceptionMessage.numberException();
            throw new IllegalArgumentException();
        }
    }

    private void validateDivisible(int amount) {
        if(amount % LOTTO_PRICE != 0){

            ExceptionMessage.divisibleException();
            throw new IllegalArgumentException();
        }
    }

    private void validateNatural(int amount) {
        if(amount <= 0){
            ExceptionMessage.naturalException();
            throw new IllegalArgumentException();
        }
    }

        //예외처리메세지 함수 만들어주기 ->해결
}
