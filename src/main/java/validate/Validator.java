package validate;

public class Validator {
    public enum ErrorMessage {

        ERROR1("[ERROR] 숫자를 입력해주세요"),
        ERROR2("[ERROR] 가격을 천 단위로 입력해주세요");
        private String message;

        ErrorMessage(String message) {
            this.message = message;
        }
    }

    public int validatePrice(String price){
        int my_price;
        try {
            checkPriceNull(price);
            my_price = checkPriceInteger(price);
            checkPrice1000(my_price);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(price);
    }
    public void checkPriceNull(String price){
        if (price == null){
            System.out.println(ErrorMessage.ERROR1);
            throw new NullPointerException();
        }
    }

    public int checkPriceInteger(String price){
        try{
            return Integer.parseInt(price);
        }catch (NumberFormatException e){
            System.out.println(ErrorMessage.ERROR1);
            throw new IllegalArgumentException();
        }
    }

    public void checkPrice1000(int price){
        if(price%1000 != 0 ){
            System.out.println(ErrorMessage.ERROR2);
            throw new IllegalArgumentException();
        }
    }

}
