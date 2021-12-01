package starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("temperatura.medida")
public class TemperatureProperties {
	
	private char unidad = 'C';

	public char getUnidad() {
		return unidad;
	}

	public void setUnidad(char unidad) {
		this.unidad = unidad;
	}
	
	

}
