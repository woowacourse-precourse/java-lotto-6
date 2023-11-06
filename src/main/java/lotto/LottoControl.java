package lotto;
import camp.nextstep.edu.missionutils.Console;
import static java.lang.Integer.parseInt;

public class LottoControl {
    public static int inputLottoPrice() {
        String boughtLottoPrice = Console.readLine();
        inputErrorCheck(parseInt(boughtLottoPrice));

        return parseInt(boughtLottoPrice);
    }

    public static void inputErrorCheck(int boughtLottoPrice) {
        if (boughtLottoPrice <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입한 값은 0 초과의 정수여야 합니다.");
        } else if (boughtLottoPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입한 값은 1000의 배수인 정수여야 합니다.");
        }
    }
}
