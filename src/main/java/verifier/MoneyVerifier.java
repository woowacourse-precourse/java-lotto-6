package verifier;

public class MoneyVerifier implements Verifier{
    @Override
    public void check(String input) {
        checkNumeric(input);
    }

    private void checkNumeric(String input){
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("로또 구입 금액이 숫자가 아닙니다.");
        }
    }

}
