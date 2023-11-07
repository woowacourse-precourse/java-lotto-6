package domain;

public class UserLottos {
    private final Lottos lottos = new Lottos();

    public UserLottos(int amount) {
        int count = amount/1000;
        buyLottos(count);
    }

    private void buyLottos(int count) {
        for (int i = 0; i < count; i++) {
            lottos.generate();
        }
    }
}
