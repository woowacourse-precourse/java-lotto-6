package lotto.view;

public class LottoReader {
    public <T> T read(ReadLogic<T> readLogic) {
        while (true) {
            try {
                return readLogic.execute();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
