package lotto.exception;

public class UserException {
    public void validetePurchasePrice(String input){
        validateContainsOnlyNumbers(input);
        validatePriceIsNotZero(input);
        validatePrice(input);
    }

    public void validateContainsOnlyNumbers(String input){
        for(int i = 0; i <input.length(); i++){
            int each = input.charAt(i) - '0';
            if(!(each >= 0 && each <= 9)){
                exception("구매 금액은 숫자로 이뤄져야 합니다.");
            }
        }
    }

    private void validatePriceIsNotZero(String input) {
        int price = Integer.parseInt(input);
        if (price == 0) {
            exception("구입 최소 금액은 1000원입니다.");
        }
    }

    private void validatePrice(String input) {
        int price = Integer.parseInt(input);
        if (price % 1000 != 0) {
            exception("구입 금액은 1000원 단위입니다.");
        }
    }

    private void exception(String message){
        throw new IllegalArgumentException(message);
    }


}
