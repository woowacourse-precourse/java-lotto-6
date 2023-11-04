package study;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *  단순 코드 테스트 및 실험을 위한 패키지입니다.
 *  단순 코드 테스트 및 실험을 위한 패키지입니다.
 */
public class EnumTest {
    enum Item {
        SHIRT(10000, List.of("a", "b")),
        PANTS(10000, List.of("a")),
        COAT(100000, List.of("a", "b", "c")),
        SWEATER(50000, List.of("d"));

        private final int price;
        private final List<String> texture;

        Item(int price, List<String> texture) {
            this.price = price;
            this.texture = texture;
        }
    }
    @Test
    void ENUM_모든요소_조회() {
        Arrays.stream(Item.values())
                .mapToInt(item -> item.price)
                .forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 10000, 20000})
    void ENUM_price_가격같으면_매치(int money) {

        long count = Arrays.stream(Item.values())
                .filter(item -> item.price == money)
                .count();
    }

    @Test
    void split테스트() {
        String str = "a,b,c,d,,";
        String[] split = str.split(",");
        for (String s : split) {
            System.out.println("s = " + s);
        }
    }
}
