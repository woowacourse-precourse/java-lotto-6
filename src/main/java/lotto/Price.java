package lotto;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Price {
    private final int price;
    public Price(int price) {
        validate(price);
        this.price = price;
    }

    private void validate(int price) {
        if(price % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static int readPrice() {
        int price = 0;
        while (true) {
            while (true) {
                try {
                    price = Integer.parseInt(Console.readLine());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("[ERROR] 숫자로 입력해 주세요.");
                }
            }
            if (checkCondition(price))
                return price;
        }
    }

    public static int calculateAmount(int price) {
        return price / 1000;
    }

    public static boolean checkCondition(int price) {
        if (price % 1000 == 0)
            return true;
        System.out.println("[ERROR] 1000단위로 입력해 주세요.");
        return false;
    }
}
