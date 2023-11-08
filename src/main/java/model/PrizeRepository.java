package model;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class PrizeRepository {
    private final static int COUNT = 1;
    HashMap<Prize, Integer> prizeRepository = new LinkedHashMap<>();

    public HashMap getPrizeRepository() {
        return prizeRepository;
    }

    public void add(Prize prize) {
        createOrSum(prize);
    }

    public boolean hasContain(Prize prize) {
        return prizeRepository.containsKey(prize);
    }

    public void createOrSum(Prize prize) {
        if (hasContain(prize)) {
            prizeRepository.put(prize, prizeRepository.get(prize) + COUNT);
            return;
        }
        prizeRepository.put(prize, COUNT);
    }

}
