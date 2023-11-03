package verifier;

public class WinnerNumberVerifier implements Verifier{
    @Override
    public void check(String input) {
        checkEachNumeric(input);
    }

    private void checkEachNumeric(String input){
        String[] numbers = input.split(",");
        for(String number : numbers){
            try{
                Integer.parseInt(number);
            }catch(Exception e){
                throw new IllegalArgumentException("입력된 값은 숫자가 아닙니다.");
            }
        }
    }
}
