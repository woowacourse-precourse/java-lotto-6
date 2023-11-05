package lotto.entity.mapper;

import lotto.property.ErrorProperty;

import java.lang.reflect.Field;

public class FiledMapper {
    public static Object getFieldValue(Object object,String fieldName){
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(object);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalStateException(ErrorProperty.FILED_MAPPER_IS_NOT_CORRECT_PARAMETER.toString());
        }
    }
}
