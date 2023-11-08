package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final int count;
    private final List<Lotto> lottos;

    public Lottos(int count) {
        this.count = count;
        this.lottos = createLottos(count);
    }

    private List<Lotto> createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < count; i++){
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    @Override
    public String toString() {
        StringBuilder multiLineText = new StringBuilder();
        for(Lotto lotto : lottos){
            multiLineText.append(lotto.toString() + "\n");
        }
        return multiLineText.toString();
    }
    
    public int getSize() {
        return getLottos().size(); }
}
