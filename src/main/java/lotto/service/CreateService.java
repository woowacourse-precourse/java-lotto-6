package lotto.service;

import lotto.utils.ErrorMessageUtil;

abstract class CreateService {
    abstract public Object createObject();

    public Object create() {
        Object object = null;
        boolean flag = false;

        while (!flag) {
            try {
                object = createObject();
                flag = true;
            } catch (IllegalArgumentException exception) {
                System.out.print(ErrorMessageUtil.getOutputErrorMessage(exception));
            }
        }

        return object;
    }
}
