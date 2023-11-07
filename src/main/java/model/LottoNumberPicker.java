/**
 * @Package_name   : model
 * @Class_name     : LottoNumberPicker
 * <p>
 * Create Date : 2023-11-07
 * Create User : 정은채
 */
package model;

import java.util.List;
import utility.Utility;


public class LottoNumberPicker {
    /**
     * Description : 1-45 사이의 6개 숫자리스트 반환
     *
     * @Method : campPickUniqueNumbersInRange()
     * @return : List<Integer>
     */
    public List<Integer> lottoNumberPick(){
        return Utility.campPickUniqueNumbersInRange();
    }
}
