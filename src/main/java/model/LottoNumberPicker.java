/**
 * @Package_name : model
 * @Class_name : LottoNumberPicker
 * <p>
 * Create Date : 2023-11-07 Create User : 정은채
 */
package model;

import java.util.List;
import utility.Utility;


public class LottoNumberPicker {
    /**
     * Description : 1-45 사이의 6개 숫자리스트 반환
     *
     * @Method : lottoNumberPick()
     * @return : List<Integer>
     */
    public List<Integer> lottoNumberPick() {
        List<Integer> sortedLottoNumbers = lottoNumberSort(Utility.campPickUniqueNumbersInRange());
        return sortedLottoNumbers;
    }

    /**
     * Description : 숫자리스트 정렬 (버블 정렬)
     *
     * @Method : lottoNumberSort()
     * @return : List<Integer>
     */
    public List<Integer> lottoNumberSort(List<Integer> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            for (int j = 0; j < lottoNumbers.size() - i - 1; j++) {
                if (lottoNumbers.get(j) > lottoNumbers.get(j + 1)) {
                    swap(lottoNumbers, j, j + 1);
                }
            }
        }
        return lottoNumbers;
    }

    /**
     * Description : 버블 정렬용 swap 연산
     *
     * @Method : swap()
     * @return : List<Integer>
     */
    public void swap(List<Integer> lottoNumbers, int source, int target) {
        int temp = lottoNumbers.get(source);
        lottoNumbers.set(source, lottoNumbers.get(target));
        lottoNumbers.set(target, temp);
    }
}
