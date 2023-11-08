package model;

import lotto.Lotto;

import java.util.List;

public class LottoObjectManagement {
    private final List<Lotto> objectManagement;

    public LottoObjectManagement(List<Lotto> objectManagement) {
        this.objectManagement = objectManagement;
    }

    public List<Lotto> getObjectManagement() {
        return objectManagement;
    }
}