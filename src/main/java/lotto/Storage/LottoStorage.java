package lotto.Storage;

import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;
import lotto.Lotto;

public class LottoStorage implements Iterable<Lotto> {
    private final List<Lotto> purchaseNumbers;

    public LottoStorage(List<Lotto> purchaseNumbers) {
        this.purchaseNumbers = purchaseNumbers;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("\n");
        for (Lotto lotto : purchaseNumbers) {
            sj.add(lotto.toString());
        }
        return sj.toString();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return purchaseNumbers.iterator();
    }
}
