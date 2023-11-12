package Util;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
/*
    List에 대한 여러 체크를 담당
 */
public class CheckList {
    //해당 list의 길이가 예상한 것과 맞는지 체크
    public static void lengthSame(List<?> list, int length, String errorMsg){
        if(list.size() != length) {
            System.out.println(errorMsg + list.size());
            throw new IllegalArgumentException(errorMsg + list.size());
        }
    }

    //해당 객체가 리스트 안에 없는 것이 맞는지 체크
    public static void checkNotInList(List<?> list, Object o, String errorMsg){
        if(list.contains(o)) {
            System.out.println(errorMsg + o);
            throw new IllegalArgumentException(errorMsg + o);
        }
    }

    //해당 리스트 내 중복 검사
    public static void checkDuplicate(List<?> list, String errorMsg){
        Set<Object> set = new HashSet<>(list);
        Object duplicatedObject;
        if(set.size() == list.size())
            return;
        set = new HashSet<>();
        for(Object o: list){
            if(set.contains(o)){
                System.out.println(errorMsg + o);
                throw new IllegalArgumentException(errorMsg + o);
            }
            set.add(o);
        }
        throw new IllegalArgumentException("unExpectedError");
    }
}
