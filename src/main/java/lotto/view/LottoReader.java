package lotto.view;

public class LottoReader {
    public <T> T input(ReadLogic<T> readLogic) {
        while (true) {
            try {
                return readLogic.execute();
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다. 다시 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
