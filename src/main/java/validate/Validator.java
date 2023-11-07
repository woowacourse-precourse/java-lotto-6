package validate;

public class Validator {
    public enum ErrorMessage {

        ERROR1("[ERROR] 숫자를 입력해주세요");

        private String message;

        ErrorMessage(String message) {
            this.message = message;
        }
    }

    public int validatePrice(String price){
        int my_price;
        try {
            my_price = Integer.parseInt(price);
        }catch (Exception e){
            System.out.println(ErrorMessage.ERROR1);
            throw new IllegalArgumentException();
        }
    }
}
