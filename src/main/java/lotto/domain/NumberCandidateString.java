package lotto.domain;

public class NumberCandidateString {

    private final String numericString;

    public NumberCandidateString(String numericString) {
        validateBlink(numericString);
        validateNumeric(numericString);
        this.numericString = numericString.trim();
    }

    public LottoNumber toLottoNumber(){
        return new LottoNumber(Integer.parseInt(numericString));
    }

    private static void validateBlink(String numericString) {
        if (isEmpty(numericString)) {
            throw new IllegalArgumentException("빈 문자를 입력하지 말아주세요");
        }
    }

    private static boolean isEmpty(String numericString) {
        return numericString.isEmpty();
    }

    private static void validateNumeric(String numericString) {
        if (isNotNumeric(numericString.trim())) {
            throw new IllegalArgumentException("숫자만 입력해주세요");
        }
    }

    private static boolean isNotNumeric(String numericString) {
        return !numericString.chars().allMatch(Character::isDigit);
    }
}
