package org.wayne.utils.db;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @TODO 多数据源远程配置设计
 */
@Component
public class DataSourceConfig implements BeanDefinitionRegistryPostProcessor, ApplicationContextAware {

    private static final Logger log = LoggerFactory.getLogger(DataSourceConfig.class);

    private Map<String, String> maphas = new HashMap<String, String>();//zk数据源信息

    private List<String> params = new ArrayList<String>();//数据源参数

    private ApplicationContext applicationContext;

    public static final String A060000201_JDBCTEMPLATE = "A060000201JdbcTemplate";
    public static final String A060000202_JDBCTEMPLATE = "A060000202JdbcTemplate";
    public static final String A060000203_JDBCTEMPLATE = "A060000203JdbcTemplate";
    public static final String A060000204_JDBCTEMPLATE = "A060000204JdbcTemplate";
    public static final String A060000205_JDBCTEMPLATE = "A060000205JdbcTemplate";
    public static final String A060000206_JDBCTEMPLATE = "A060000206JdbcTemplate";
    public static final String A060000207_JDBCTEMPLATE = "A060000207JdbcTemplate";
    public static final String A060000208_JDBCTEMPLATE = "A060000208JdbcTemplate";
    public static final String A060000209_JDBCTEMPLATE = "A060000209JdbcTemplate";
    public static final String A060000210_JDBCTEMPLATE = "A060000210JdbcTemplate";
    public static final String A060000ODS_JDBCTEMPLATE = "A060000ODSJdbcTemplate";
    public static final String A06000ODS2_JDBCTEMPLATE = "A06000ODS2JdbcTemplate";
    public static final String PUB_NEW_JDBCTEMPLATE = "pubNewJdbcTemplate";

    /**
     * 初始化数据源参数
     */
    public void init() {
        params.add("url");
        params.add("username");
        params.add("password");
        params.add("driverClassName");
        params.add("minIdle");
        params.add("maxIdle");
        params.add("maxWait");
        params.add("maxActive");
    }

    /**
     * 根据zk数据源配置动态添加JdbcTemplate
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

        init();
        try {
           /* maphas = DdpEnv.getConfigManager().getConfig("app/dynamic-datasource/route-rule/level-1");
            for(Map.Entry<String, String> map : maphas.entrySet()){//循环创建交易库的JdbcTemplate
            	String key = map.getKey();//资产方代码
            	if(ObjectUtils.isEmpty(key)){
            		continue;
            	}
            	registerJdbcTemplateBean("app/dynamic-datasource/route-rule/level-1/" + key + "/ccbc", registry, key);
            }
            //创建新pub库的JdbcTemplate
            registerJdbcTemplateBean("app/datasource/pub_new", registry, "pubNew");
            log.info(JSONObject.toJSONString(maphas));*/
        } catch (Exception e) {
            log.error("获取数据源配置错误", e);
        }
    }


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    public void registerJdbcTemplateBean(String path, BeanDefinitionRegistry registry, String key) throws Exception {

//		Map<String, String> dataSourceMap = new HashedMap<>();
//    	for(String param : params){
//    		String paramValue = DdpEnv.getConfigManager().getAppConfig(path, param);
//    		dataSourceMap.put(param, paramValue);//设置数据源参数
//    	}
//
//		DataSource dataSource = DruidDataSourceFactory.createDataSource(dataSourceMap);//创建资产方数据源
//
//		BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(JdbcTemplate.class);//创建类型为JdbcTemplate的Bean
//    	definitionBuilder.addPropertyValue("dataSource", dataSource);//设置JdbcTemplate的dataSource属性
//    	registry.registerBeanDefinition(key + "JdbcTemplate", definitionBuilder.getBeanDefinition());//将JdbcTemplate对象添加到spring容器.spring容器中的beanid为资产方代码 + JdbcTemplate
    }

    @Override
    public void setApplicationContext(ApplicationContext arg0) throws BeansException {
        this.applicationContext = arg0;
    }

    public JdbcTemplate getJdbcTemplate(String beanId) {
        try {
            return this.applicationContext.getBean(beanId, JdbcTemplate.class);
        } catch (BeansException e) {
            log.error("未找到bean", e);
            return null;
        }
    }


}