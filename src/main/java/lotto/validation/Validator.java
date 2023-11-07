package lotto.validation;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lotto.constant.LottoConstant.RANGE_END;
import static lotto.constant.LottoConstant.RANGE_START;

public class Validator {
    public static boolean checkIsNotNumber(String pay) {
        try {
            Integer.parseInt(pay);
            return false;
        } catch (NumberFormatException error) {
            return true;
        }
    }
    public static boolean checkIsPositive(int pay) {
        if (pay <= 0) {
            return true;
        }
        return false;
    }
    public static boolean checkMultipleOf1000(int pay) {
        if (pay % 1000 != 0) {
            return true;
        }
        return false;
    }

    public static boolean checkIsNotNumberList(List<String> _lotto) {
        Pattern pattern = Pattern.compile("[0-9]{2}");
        final Matcher[] matcher = new Matcher[1];
        for ( String _number: _lotto) {
            matcher[0] = pattern.matcher(_number);
            if (matcher[0].matches()) return true;
        }

        return false;
    }


    public static boolean checkSizeIsSix(String _input) {
        List<String> _lotto = List.of(_input.split(","));
        if (_lotto.size() != 6) return true;
        return false;
    }

    public static boolean checkRangeLotto(List<Integer> _lotto) {
        _lotto = _lotto.stream().filter(_number -> {
            if(checkRangeNumber(_number, RANGE_START.getNumber(), RANGE_END.getNumber())) return true;
            else { return false; }
        }).toList();

        return _lotto.size() != 6;
    }

    public static boolean checkDuplicateNumber(List<Integer> _lotto, int _bonus) {
        if (_lotto.contains(_bonus)) {
            return true;
        }

        return false;
    }

    public static boolean checkRangeNumber(int target, int start, int end) {
        return target >= start && target <= end;
    }
}
