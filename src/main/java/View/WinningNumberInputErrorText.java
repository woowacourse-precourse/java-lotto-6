package View;

public class WinningNumberInputErrorText {
    public static String error = "[ERROR]";

    public static String dupilicateNumber(){
        return error + "당첨 번호 중 중복된 숫자가 존재합니다. 해당 숫자: ";
    }

    public static String dupilicateBonusNumber(){
        return error + "보너스 번호가 기존 당첨 번호와 중복됩니다. 해당 숫자: ";
    }

    public static String CantConvertedToInt(){
        return error + ",로 구분되는 문자열 중 숫자로 변환이 불가한 문자열이 섞여 있음: 숫자만 입력해 주십시오. 해당 문자열:";
    }

    public static String notSixWord(){
        return error + ",로 구분되는 문자들의 개수가 6이 아님: 6개의 숫자를 입력해 주십시오. 현재 인식된 길이:";
    }

    public static String nullInputAsNumbers(){
        return error + "당첨 번호로 null 값이 입력 되었습니다.";
    }

    public static String nullInputAsBonus(){
        return error + "보너스 번호로 null 값이 입력 되었습니다.";
    }

    public static String numberOutOfRange(){
        return error + "입력된 숫자 중 1~45의 범위를 벗어나는 숫자가 있습니다. 해당 숫자:";
    }
}
