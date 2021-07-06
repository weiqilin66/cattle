package cn.com.yusys.yusp.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @Description: 工具类
 * @author: lwq
 */
@Component
public class AppUtil implements EmbeddedValueResolverAware, ApplicationContextAware {
    private static StringValueResolver resolver;
    private static ApplicationContext context;
    private static BeanDefinitionRegistry registry;

    public String getRemoteValue(String key) {
        final String s = String.format("${%s}", key);
        return resolver.resolveStringValue(s);
    }

    public ApplicationContext getContext() {
        return context;
    }

    public void registerBean(String beanName, Object object,Class clazz,String property ) {
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
        definitionBuilder.addPropertyValue(property, object);
        registry.registerBeanDefinition(beanName, definitionBuilder.getBeanDefinition());
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        resolver = stringValueResolver;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
        registry = (BeanDefinitionRegistry) context.getParentBeanFactory();
    }
}
