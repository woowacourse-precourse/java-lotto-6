package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PrizeRepository {
    private static final  int COUNT = 1;
    private HashMap<Prize, Integer> prizeRepository = new LinkedHashMap<>();

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

    public int calculateTotalReword() {
        int totalReword = 0;
        Iterator<Entry<Prize, Integer>> iterator = prizeRepository.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Prize, Integer> entry = iterator.next();
            totalReword = totalReword + calculateOnePrice(entry.getKey(), entry.getValue());
        }
        return totalReword;
    }

    public int calculateOnePrice(Prize key, int value) {
        return key.getPrice() * value;
    }

}
