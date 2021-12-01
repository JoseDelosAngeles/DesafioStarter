package starter;

public class TemperatureService {

	private char unidad;
	
	public TemperatureService(char unidad) {
		this.unidad=unidad;
	}
	
	
	public String consulta() {
		double tempCelsius = 10;
		double tempFarenheit = convertirCelsiusAFarenheit(tempCelsius);
		if(unidad=='C') {
			return ("La temperatura es: " + tempCelsius + "ºC");
		}
		if (unidad=='F') {
			return ("La temperatura es: " + tempFarenheit + "ºF");
		}
		
		return ("Llamada incorrecta. Termine la llamada en C para Celsius o F para Farenheit.");
	}
	
	public String conversor(int temperature) {
		double result;
		double originalTemp = temperature;
		if(unidad=='C') {
			result = convertirFarenheitACelsius(temperature);
			return(originalTemp + "C son " + result + "F");
		}
		if(unidad=='F') {
			result = convertirCelsiusAFarenheit(temperature);
			return(originalTemp + "F son " + result + "C");
		}
		
		return("Llamada incorrecta. Termine la llamada en C para convertir de Farenheit a Celsius o F para convertir de Celsius a Farenheit.");
	}
	
	
	
	public double convertirCelsiusAFarenheit(double temperatura) {
		temperatura = (temperatura*9/5)+32;
		return temperatura;
	}
	
	public double convertirFarenheitACelsius(double temperatura) {
		temperatura = (temperatura - 32)*5/9;
		return temperatura;
	}

}
