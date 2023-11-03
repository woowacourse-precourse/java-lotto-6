package lotto;

import static lotto.Input.*;
import static lotto.Lotto.*;
import static lotto.Output.*;

public class Application {
    public static void main(String[] args) {
        input_price();
        lotto_random(lotto_count);
        output_price(lotto_count);
        output_lotto(numbers_list);
    }
}
