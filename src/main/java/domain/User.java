package domain;

import java.util.ArrayList;

public class User {

    private final ArrayList<Lotto> purchasedLotto = new ArrayList<>();

    public ArrayList<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }
}
