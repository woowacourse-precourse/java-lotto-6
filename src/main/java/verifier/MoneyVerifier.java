package verifier;

public class MoneyVerifier implements Verifier{
    @Override
    public void check(String input) {
        checkNumeric(input);
        checkRange(input);
    }

    private void checkNumeric(String input){
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("로또 구입 금액이 숫자가 아닙니다.");
        }
    }

    private void checkRange(String input){
        int money = Integer.parseInt(input);
        if(money <0)
            throw new IllegalArgumentException("로또 구입 금액은 0보다 커야 합니다");
    }


}
