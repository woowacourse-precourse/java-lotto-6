package lotto.verifier;

public class BonusNumberVerifier implements Verifier{
    @Override
    public void check(String input) {
        checkNumeric(input);
        checkRange(input);

    }

    private void checkNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]보너스 번호가 숫자가 아닙니다.");
        }
    }

    private void checkRange(String input){
        int BonusNumber = Integer.parseInt(input);
        if(BonusNumber < 1 || BonusNumber >45 ){
            throw new IllegalArgumentException("[ERROR]보너스 번호는 1-45 사이의 숫자이어야 합니다.");
        }
    }
}
