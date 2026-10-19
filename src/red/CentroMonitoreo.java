package red;

import java.util.ArrayList;
import java.util.List;

/**
 * Centro de monitoreo que AGREGA nodos IoT.
 */
public class CentroMonitoreo {

    private String nombre;
    private ArrayList<NodoIoT> nodos;

    public CentroMonitoreo(String nombre) {
        this.nombre = nombre;
        this.nodos = new ArrayList<>();
    }

    /** Agrega un nodo ya existente (agregación). */
    public void agregarNodo(NodoIoT nodo) {
        // TODO: implementar
        this.nodos.add(nodo);

    }

    /**
     * Reporte: una línea por nodo con su id y su promedio de temperatura.
     */
    public List<String> reporteTemperaturas() {
        // TODO: implementar

        List<String> reporteTemperaturas = new ArrayList<>();
        for (NodoIoT nodo : nodos) {
            double promedio = nodo.promedioTemperatura();

            reporteTemperaturas.add("ID: " + nodo.getId()
                    + ", Promedio de temperatura: " + promedio);
        }

        return reporteTemperaturas;
    }

    public String getNombre() { return nombre; }
    public ArrayList<NodoIoT> getNodos() { return nodos; }
}
