package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InputConverter {
    public static int convertPrice(String inputPrice) {
        int price = Integer.parseInt(inputPrice);
        return price;
    }

}
