package Model;

import java.util.List;

public class Domain {
    private final Service service = Service.getInstance();
    public final List<Integer> NUMBERS = service.lottoGenerator();
    public final int BONUS_NUMBER = service.numberGenerator();
    public static final int LOTTO_PRICE = 1000;

    private List<Lotto> myLotto;
    private List<Integer> correctNumberCount;
    public static int price;

    private Domain() {
    }

    private class Singleton {
        private static final Domain INSTANCE = new Domain();
    }

    public static Domain getInstance() {
        return Singleton.INSTANCE;
    }

    public List<Lotto> getMyLotto() {
        return myLotto;
    }
}
