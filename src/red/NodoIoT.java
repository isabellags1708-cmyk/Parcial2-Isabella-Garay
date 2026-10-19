package red;

import sensores.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Nodo IoT que COMPONE sensores.
 * Los sensores se crean dentro del nodo (composición real).
 */
public class NodoIoT {

    private String id;
    private ArrayList<Sensor> sensores;

    public NodoIoT(String id) {
        this.id = id;
        this.sensores = new ArrayList<>();
    }

    /**
     * Crea y agrega un sensor del tipo indicado dentro del nodo.
     * Tipo: "TEMPERATURA", "HUMEDAD", "LUMINOSIDAD".
     * Retorna el sensor creado, o null si el tipo es inválido.
     */
    public Sensor agregarSensor(String tipo, String idSensor, int capacidad) {
        // TODO: implementar (polimorfismo + composición)
        Sensor sensor = null;
        switch (tipo){
            case "TEMPERATURA":
                sensor = new SensorTemperatura(idSensor, capacidad);
                break;
            case "HUMEDAD":
                sensor = new SensorHumedad(idSensor, capacidad);
                break;
            case "LUMINOSIDAD":
                sensor = new SensorLuminosidad(idSensor, capacidad);
                break;
            default:
                return null;

        }
        if (sensor != null) {
            this.sensores.add(sensor);
        }
        return sensor;
    }

    /**
     * Promedio de temperatura del nodo. Retorna 0 si no hay sensores de temperatura.
     * Pista: usar instanceof para filtrar.
     */
    public double promedioTemperatura() {
        // TODO: implementar
        double suma = 0;
        int contador = 0;

        for (Sensor s : this.sensores) {
            if (s instanceof SensorTemperatura) {
                SensorTemperatura temp = (SensorTemperatura) s;

                suma += temp.promedioUltimasLecturas();
                contador++;
            }
        }

        if (contador == 0) {
            return 0;
        }

        return suma / contador;
    }

    /**
     * Lista de sensores cuya última lectura está fuera de rango.
     */
    public List<Sensor> sensoresFueraDeRango() {
        // TODO: implementar
        List<Sensor> sensoresFueraDeRango = new ArrayList<>();

        for (Sensor s : this.sensores) {
            int cantidad = s.getCantidadLecturas();

            if (cantidad > 0) {
                int indiceUltimaLectura =
                        (s.getIndiceActual() - 1 + s.getUltimasLecturas().length)
                                % s.getUltimasLecturas().length;

                int ultimaLectura = s.getUltimasLecturas()[indiceUltimaLectura];

                if (s.fueraDeRango(ultimaLectura)) {
                    sensoresFueraDeRango.add(s);
                }
            }
        }

        return sensoresFueraDeRango;
    }
        public String getId() { return id; }
        public ArrayList<Sensor> getSensores() { return sensores; }
    }