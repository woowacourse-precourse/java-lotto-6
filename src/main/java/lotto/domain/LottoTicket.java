package lotto.domain;

public class LottoTicket {
    int lottoCount;

    public LottoTicket(String input) {
        validateIsNumber(input);
        lottoCount = Integer.parseInt(input);
    }

    private void validateIsNumber(String input) {
        if (input.matches("\\d*")) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
    }
}
