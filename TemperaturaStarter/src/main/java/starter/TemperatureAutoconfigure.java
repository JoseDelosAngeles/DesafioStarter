package starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(TemperatureService.class)
@EnableConfigurationProperties(TemperatureProperties.class)
public class TemperatureAutoconfigure {
	
	private final TemperatureProperties properties;
	
	public TemperatureAutoconfigure(TemperatureProperties properties) {
		this.properties = properties;
	}
	
	@Bean
	public TemperatureService service() {
		return new TemperatureService(properties.getUnidad());
	}

}
