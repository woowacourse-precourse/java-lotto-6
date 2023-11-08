package Util;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CheckList {
    public static void lengthSame(List<?> list, int length, String errorMsg){
        if(list.size() != length) {
            System.out.println(errorMsg + list.size());
            throw new IllegalArgumentException(errorMsg + list.size());
        }
    }

    public static void checkNotInList(List<?> list, Object o, String errorMsg){
        if(list.contains(o)) {
            System.out.println(errorMsg + o);
            throw new IllegalArgumentException(errorMsg + o);
        }
    }

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
