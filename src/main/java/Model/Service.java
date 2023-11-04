package Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Service {
    private final Domain domain = Domain.getInstance();

    private Service() {
    }

    private class Singleton {
        private static final Service INSTANCE = new Service();
    }

    public static Service getInstance() {
        return Singleton.INSTANCE;
    }

    public List<Integer> lottoGenerator() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public int numberGenerator() {
        return Randoms.pickNumberInRange(1, 45);
    }

    public void setPrice() {
        Domain.price = 1;
    }

}
