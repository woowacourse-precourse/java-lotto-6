package lotto.service.convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
상수에 모든 의미를 담으니 상수 변수가 길어져
코드가 드러워짐 -> 주석을 혼합해서 사용
ConvertStringToNumbers -> 재사용하기
*/
public class ConvertService {
    public ConvertService() {}
    public int ConvertStringToNumber(String hasNumber) {
        // 파싱 성공 -> 정상 값 출력
        // 파싱 실패 -> 1) 나머지 발생 시 0 리턴, 2) 파싱 실패시 -1 리턴.
        int num;
        try {
            num = Integer.parseInt(hasNumber);
            if (num % MIN_PRICE_TEN_WON != 0) {
                return ERROR_ZERO_RETURN_DIVISION_FALSE_REST;
            }
            return num;
        } catch (NumberFormatException e) {
            return ERROR_MINUS_RETURN_PARSING_FALSE;
        }
    }
    public List<Integer> ConvertStringToNumbers(String hasNumbers) {
        List<String> stringNumberList = Arrays.asList(hasNumbers.split(","));
        if(stringNumberList.size() > 6){
            return ERROR_INPUT_OVER_LIST;
        }
        List<Integer> intnumberList = new ArrayList<>();
        for (String num : stringNumberList) {
            try {
                intnumberList.add(Integer.parseInt(num.trim()));
            } catch (NumberFormatException e) {
                return ERROR_MINUS_LIST_RETURN_PARSING_FALSE;
            }
        }
        return intnumberList;
    }
    public int priceChangeBuyNumber (int num){
        return num/1000;
    }
    // 나중에 이 ERROR 부분은 익셉션 핸들러에 메시지 추가해야함 -> 받아서 처리할 곳에서
    private static final int ERROR_ZERO_RETURN_DIVISION_FALSE_REST = 0;
    private static final int ERROR_MINUS_RETURN_PARSING_FALSE = -1;
    private static final List<Integer> ERROR_MINUS_LIST_RETURN_PARSING_FALSE = Arrays.asList(-1);
    private static final List<Integer> ERROR_INPUT_OVER_LIST = Arrays.asList(-2);
    private static final int MIN_PRICE_TEN_WON = 1000;
}
