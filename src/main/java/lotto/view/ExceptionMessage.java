package lotto.view;

public class ExceptionMessage {
    public static void numberException(){
        System.out.println("[ERROR] 금액은 숫자여야 합니다.");
    }
    public static void wrongNumberException(){
        System.out.println("[ERROR] 금액은 1000원 단위여야 합니다.");
    }

    public static void wrongLottoException(){
        System.out.println("[ERROR] 로또 번호는 숫자여야 합니다.");
    }

    public static void wrongLottoRangeException(){
        System.out.println("[ERROR] 로또 번호는 1에서 45 사이여야 합니다.");
    }

    public static void wrongLottoDuplicateException(){
        System.out.println("[ERROR] 로또 번호는 중복되면 안됩니다.");
    }

    public static void wrongLottoSizeException(){
        System.out.println("[ERROR] 로또 번호는 6개여야 합니다.");
    }

}
