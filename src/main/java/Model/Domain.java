package Model;

import java.util.List;

public class Domain {
    private final Service service = Service.getInstance();
    public final List<Integer> NUMBERS = service.lottoGenerator();
    public final int BONUS_NUMBER = service.numberGenerator();
    public static final int LOTTO_PRICE = 1000;

    private List<Lotto> myLotto;
    private List<Integer> correctNumberCount;
    public int price;
    public int lottoNum;
    public double revenueRate;

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

    public void checkPriceUnit(int price) {
        if(price % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액이 1,000 단위가 아닐 때 예외가 발생해야 합니다.");
        }
    }
}
