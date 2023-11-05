package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        int count = purchase();
        List<Lotto> lottos = createLottos(count);
        DrawingLotto drawingLotto = createDrawingLottos(createDrawingNumbers());
    }

    private static int purchase() {
        try {
            System.out.println("구입금액을 입력해 주세요");
            return Lotto.purchaseCount(Integer.parseInt(readLine()));
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력된 값이 숫자가 아닙니다.");
            return purchase();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 지불한 금액이 나누어 떨어지지 않습니다.");
            return purchase();
        }
    }

    private static List<Lotto> createLottos(int count) {
        System.out.println(count + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(Lotto.LOWER_BOUND, Lotto.UPPER_BOUND, 6));
            lottos.add(lotto);
            System.out.println(lotto.getNumbers());
        }

        return lottos;
    }

    private static Lotto createDrawingNumbers() {
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            List<Integer> numbers = Arrays.stream(readLine().split(",")).map(Integer::parseInt).toList();
            return new Lotto(numbers);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자가 아닌 값이 입력되었습니다.");
            return createDrawingNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createDrawingNumbers();
        }
    }

    private static DrawingLotto createDrawingLottos(Lotto lotto) {
        try {
            System.out.println("보너스 번호를 입력해 주세요");
            int bonusNumber = Integer.parseInt(readLine());
            return new DrawingLotto(lotto, bonusNumber);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자가 아닌 값이 입력되었습니다.");
            return createDrawingLottos(lotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createDrawingLottos(lotto);
        }
    }
}
