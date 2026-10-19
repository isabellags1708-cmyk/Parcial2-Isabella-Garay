
package sensores;

/**
 * Clase abstracta que representa un sensor genérico de la red IoT.
 * Mantiene un historial de las últimas N lecturas en un arreglo
 * (buffer circular).
 */
public abstract class Sensor {

    private String id;
    private String unidad;
    private int[] ultimasLecturas;
    private int indiceActual;
    private int cantidadLecturas;

    public Sensor(String id, String unidad, int capacidad) {
        this.id = id;
        this.unidad = unidad;
        this.ultimasLecturas = new int[capacidad];
        this.indiceActual = 0;
        this.cantidadLecturas = 0;
    }

    public abstract int generarLectura();

    public void registrarLectura(int valor) {

        ultimasLecturas[indiceActual] = valor;


        indiceActual = (indiceActual + 1) % ultimasLecturas.length;


        if (cantidadLecturas < ultimasLecturas.length) {
            cantidadLecturas++;
        }
    }

    public double promedioUltimasLecturas() {
        if (cantidadLecturas == 0) {
            return 0;
        }

        double suma = 0;

        for (int i = 0; i < cantidadLecturas; i++) {
            suma += ultimasLecturas[i];
        }

        return suma / cantidadLecturas;
    }

    public abstract boolean fueraDeRango(int valor);


    public String getId() {
        return id;
    }

    public String getUnidad() {
        return unidad;
    }

    public int[] getUltimasLecturas() {
        return ultimasLecturas;
    }

    public int getCantidadLecturas() {
        return cantidadLecturas;
    }

    public int getIndiceActual() {
        return indiceActual;
    }

    protected void setIndiceActual(int indiceActual) {
        this.indiceActual = indiceActual;
    }

    protected void setCantidadLecturas(int cantidadLecturas) {
        this.cantidadLecturas = cantidadLecturas;
    }
}

