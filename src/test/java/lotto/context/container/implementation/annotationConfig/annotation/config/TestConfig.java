package lotto.context.container.implementation.annotationConfig.annotation.config;

import lotto.context.beans.MockBean;
import lotto.context.beans.MockDependencyBean;
import lotto.context.container.implementation.annotationConfig.annotation.bean.Bean;
import lotto.context.container.implementation.annotationConfig.annotation.configuration.Configuration;

@Configuration
public class TestConfig {
    @Bean
    public MockDependencyBean mockDependencyBean() {
        return new MockDependencyBean();
    }

    @Bean
    public MockBean mockBean(MockDependencyBean mockDependencyBean) {
        return new MockBean(mockDependencyBean);
    }

    public void test3() {
    }
}
