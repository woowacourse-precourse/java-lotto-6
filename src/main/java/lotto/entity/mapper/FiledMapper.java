package lotto.entity.mapper;

import java.lang.reflect.Field;

public class FiledMapper {
    public static Object getFieldValue(Object object,String fieldName){
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(object);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }
}
