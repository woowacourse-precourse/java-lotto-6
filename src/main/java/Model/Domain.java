package Model;

import Controller.ModelHandler;
import java.util.List;

public class Domain {
    private final Service SERVICE = Service.getInstance();
    public final List<Integer> NUMBERS = SERVICE.lottoGenerator();
    public static final int LOTTO_PRICE = 1000;
    public int BONUS_NUMBER = SERVICE.numberGenerator();
    public int price;
    public int lottoNumber;
    public double revenueRate;

    private List<Lotto> myLotto;
    private List<Integer> correctNumberCount;

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

    public List<Integer> getCorrectNumberCount() {
        return correctNumberCount;
    }
}
