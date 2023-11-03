package verifier;

public class BonusNumberVerifier implements Verifier{
    @Override
    public void check(String input) {
        checkNumeric(input);
    }

    private void checkNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호가 숫자가 아닙니다.");
        }
    }
}
