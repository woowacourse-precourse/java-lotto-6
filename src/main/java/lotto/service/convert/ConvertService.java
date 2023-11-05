package lotto.service.convert;

/*
상수에 모든 의미를 담으니 상수 변수가 길어져
코드가 드러워짐 -> 주석을 혼합해서 사용
*/
public class ConvertService {
    public ConvertService(){}

    public int moneyConvertStringToNumbers(String hasNumber){
        // 파싱 성공 -> 정상 값 출력
        // 파싱 실패 -> 1) 나머지 발생 시 0 리턴, 2) 파싱 실패시 -1 리턴.
        int num;
        try {
            num = Integer.parseInt(hasNumber);
            if (num % MIN_PRICE_TEN_WON != 0) {
                return ZERO_RETURN_ERROR_DIVISION_FALSE_REST;
            }
            return num;
        }catch (NumberFormatException e) {
            return MINUS_RETURN_ERROR_PARSING_FALSE;
        }
    }
    private static final int ZERO_RETURN_ERROR_DIVISION_FALSE_REST = 0;
    private static final int MINUS_RETURN_ERROR_PARSING_FALSE = -1;
    private static final int MIN_PRICE_TEN_WON = 1000;
}
