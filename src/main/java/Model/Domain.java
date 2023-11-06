package Model;

import Controller.ModelHandler;
import java.util.List;

public class Domain {
    private final Service SERVICE = Service.getInstance();

    public static final int LOTTO_PRICE = 1000;
    public List<Integer> lottoWinningNumber;
    public int bonusNumber;
    public int price;
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
