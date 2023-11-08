/**
 * @Package_name : model
 * @Class_name : LottoNumberSetHolder
 * <p>
 * Create Date : 2023-11-07 Create User : 정은채
 */
package model;

import java.util.ArrayList;

public class LottoNumberSetHolder {
    private ArrayList<Lotto> LottoNumberSet;

    public LottoNumberSetHolder() {
        LottoNumberSet = new ArrayList<Lotto>();
    }

    /**
     * Description : LottoNumberSet에 새로운 로또들 추가
     *
     * @Method : lottoNumberSetAdd()
     */
    public void lottoNumberSetAdd(Lotto newLottoNumber) {
        LottoNumberSet.add(newLottoNumber);
    }

    /**
     * Description : LottoNumberSet 반환
     *
     * @Method : getLottoNumberSet()
     * @return : ArrayList<Lotto>
     */
    public ArrayList<Lotto> getLottoNumberSet() {
        return LottoNumberSet;
    }

}
