package site.thedeny1106.projectPay.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class BatchAsyncConfig {

    @Value("${api.settlement.async.pool_size:5}")
    private int poolSize;

    @Bean("settlementTaskExecutor")
    public ThreadPoolTaskExecutor settlementTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(poolSize);
        executor.setMaxPoolSize(poolSize);
        executor.setThreadNamePrefix("settlement-");
        executor.initialize();
        return executor;
    }
}
