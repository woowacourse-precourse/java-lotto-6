package lotto;

import java.util.List;
import static lotto.PlaceAndPrize.Place;
public class Converter {


    public static int parseToInt(String rawValue) {
        try {
            return Integer.parseInt(rawValue);
        } catch (NumberFormatException wrongType) {
            throw new IllegalArgumentException("정수를 입력해주세요");
        }
    }

    public int carculateWinPrize(List<Integer> wins) {
        int sum = 0;
        for (int i = 0; i <= 4; i++) {
            sum += wins.get(i) * Place.values()[i].getPrizeAmount();
        }
        return sum;
    }
}
