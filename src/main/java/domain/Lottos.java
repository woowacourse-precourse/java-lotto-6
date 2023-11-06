package domain;

import java.util.ArrayList;
import java.util.List;
import service.MakeObjectService;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(){
        lottos = new ArrayList<>();
    }

    public void add(Amount amount) {
        for(int i = 0; i < amount.getAmount(); i++){
            lottos.add(MakeObjectService.lotto());
        }
    }
}
