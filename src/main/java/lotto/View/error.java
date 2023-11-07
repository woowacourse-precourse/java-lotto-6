package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class error {
    public static void not_valid_purchaseAmount() {
        System.out.println("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }
    public static void not_valid_winningNumber() {
        System.out.println("[ERROR] 로또 번호는 6개여야 합니다.");
    }
    public static void NAN() {
        System.out.println("[ERROR] 유효한 숫자를 입력하세요.");
    }
    public static void duplicate_winningNumber() {
        System.out.println("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
    }
}
