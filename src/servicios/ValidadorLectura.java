package servicios;

/**
 * Servicio que valida lecturas según el tipo de sensor.
 * Rangos: TEMPERATURA [-10,50], HUMEDAD [0,100], LUMINOSIDAD [0,2000].
 */
public class ValidadorLectura {

    public boolean esValida(String tipo, int valor) {
        // TODO: implementar switch por tipo
        switch (tipo){
            case "TEMPERATURA":
                if(valor >= -10){
                    return valor <= 50;
                }
            case "HUMEDAD":
                if(valor >= 0){
                    return valor <= 100;
                }
            case "LUMINOSIDAD":
                if(valor >= 0){
                    return valor <= 2000;
                }

        }
        return false;
    }
}
