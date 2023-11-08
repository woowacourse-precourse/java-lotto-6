package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.entity.Lotto;
import lotto.exception.DuplicateLottoNumbersException;
import lotto.exception.LottoNumberRangeException;
import lotto.service.HasDuplicateService;

import java.util.ArrayList;
import java.util.List;

import static lotto.exception.LottoNumberException.LottoNumberException;

public class LottoNumberReader {
    public List<Integer> lottonumbers = new ArrayList<>();
    public List<Integer> lotto_reader() {
        try {
            String input = Console.readLine();
            lottonumbers = LottoNumberException(input);
            if (HasDuplicateService.hasDuplicates(lottonumbers)) {
                throw new DuplicateLottoNumbersException("로또 번호에 중복된 값이 있습니다.");
            }
            Lotto lotto = new Lotto(lottonumbers);
            return lottonumbers;
        }catch (DuplicateLottoNumbersException e){
        }catch (NumberFormatException e) {
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또번호는 6자리입니다. 다시 입력하시오");
        }catch(IllegalStateException e){
        }
        return lotto_reader();
    }
}
