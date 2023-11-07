package lotto;

public class GameService {
    static final int ERROR = -1;

    public int validCash(String rawInput) throws IllegalArgumentException {
        try {
            int rawCash = Integer.parseInt(rawInput);
            if (rawCash % 1000 == 0 && rawCash > 0) {
                return rawCash / 1000;
            }
            throw new IllegalArgumentException();
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 로또 구입 금액은 정확한 숫자여야 합니다.");
            return ERROR;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1000원 단위, 1000원 이상의 로또 구입 금액을 입력해주세요.");
            return ERROR;
        }
    }
}
