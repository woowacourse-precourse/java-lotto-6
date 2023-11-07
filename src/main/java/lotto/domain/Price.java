package lotto.domain;

public class Price {
    private final int price;

    public Price(String input) {
        validateInput(input);
        int beforeValidatePrice = Integer.parseInt(input);
        validatePriceValue(beforeValidatePrice);
        this.price = beforeValidatePrice;
    }
    public int getLottoAmount(){
        int amount = price/1000;
        return amount;
    }

    private void validatePriceValue(int price) {
        if(!(price % 1000 == 0)){ //1000원 단위가 아니라면
            throw new IllegalArgumentException("1000원 단위로 입력하세요");
        }
    }

    private void validateInput(String input){
        if(!input.matches("\\d+")){
            throw new IllegalArgumentException("올바른 숫자를 입력해주세요");
        }
    }
}
