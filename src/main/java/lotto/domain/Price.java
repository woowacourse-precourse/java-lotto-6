package lotto.domain;

public class Price {
    private final int price;
    private final int amount;

    /**
     * 입력받은 가격이 올바른지 확인하고 price를 생성하는 생성자
     * @param input 입력한 가격
     */
    public Price(String input) {
        validateInput(input);
        int beforeValidatePrice = Integer.parseInt(input);
        validatePriceValue(beforeValidatePrice);
        this.price = beforeValidatePrice;
        this.amount = price/1000;
    }

    /**
     * 구매한 로또 개수를 get
     * @return 구매한 로또 갯수 int
     */
    public int getAmount(){
        return amount;
    }

    /**
     * 금액이 1000원단위인지 확인하는 메서드
     * @param price int형으로 변환된 가격
     */
    private void validatePriceValue(int price) {
        if(!(price % 1000 == 0)){ //1000원 단위가 아니라면
            throw new IllegalArgumentException("1000원 단위로 입력하세요");
        }
    }

    /**
     * 입력받은 input이 숫자형태인지 확인
     * @param input 입력받은 String
     */
    private void validateInput(String input){
        if(!input.matches("\\d+")){
            throw new IllegalArgumentException("올바른 숫자를 입력해주세요");
        }
    }
}
