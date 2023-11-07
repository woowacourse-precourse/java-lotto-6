package lotto.service;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    public List<Integer> convertStringToList(String input) {
        List<Integer> list = new ArrayList<>();
        String[] numbers = input.split(",");
        for (String number : numbers) {
            list.add(Integer.parseInt(number.trim()));
        }
        return list;
    }

}
