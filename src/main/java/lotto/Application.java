package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> a = Lotto.drawLottoNumbers();
        System.out.println(a);
    }
}
