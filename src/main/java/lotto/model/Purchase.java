package lotto.model;

public class Purchase {
    private final Integer money;

    public Purchase(String inputPrice){
        this.money = validate(inputPrice);
    }

    private Integer validate(String inputPrice) {
        try{
            int validatePrice = Integer.parseInt(inputPrice);

            if((validatePrice % 1000 != 0) || (validatePrice <= 0)){
                throw new IllegalArgumentException();
            }
            return validatePrice;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public Integer getlottoTicketNumber(){
        return money/1000;
    }
}
