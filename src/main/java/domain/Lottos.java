package domain;

import java.util.ArrayList;
import java.util.List;
import service.MakeObjectService;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(Amount amount){
        lottos = new ArrayList<>();
        for(int i = 0; i < amount.getAmount(); i++){
            lottos.add(MakeObjectService.lotto());
        }
    }

}
