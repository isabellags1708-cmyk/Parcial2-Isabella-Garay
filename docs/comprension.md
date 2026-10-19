# Comprensión del diseño — Enunciado A
**Nombre:** Isabella Garay Santana
**Fecha:** 19/10/2026

Responde con tus palabras, basándote en `docs/UML-final.md`. Respuestas
concisas (2–4 líneas por pregunta). Este documento evidencia que entendiste el
contrato de diseño **antes** de programar.

---

### 1. Herencia y polimorfismo
¿Por qué `Sensor` es una clase abstracta y no una clase concreta? Menciona
qué método obliga a cada subclase a implementar y qué gana el sistema con eso.

> _Tu respuesta:_Es una clase abstracta porque define características comunes, pero cada tipo de sensor puede obtener sus datos de una manera diferente. El método abstracto leerValor() obliga a cada subclase a implementar su propia forma de lectura. Así, el sistema puede trabajar con distintos sensores usando una misma estructura.

---

### 2. Composición vs. agregación
Explica con tus palabras la diferencia entre `NodoIoT ◆— Sensor` (composición)
y `CentroMonitoreo ◇— NodoIoT` (agregación). Da un ejemplo de qué pasaría con
los sensores si se elimina el nodo, y qué pasaría con los nodos si se elimina
el centro.

> _Tu respuesta:_En la composición, el nodo es responsable de crear y contener sus sensores, por lo que al eliminarlo estos dejan de existir como parte de él. En la agregación, el centro solo agrupa y administra los nodos, que pueden seguir existiendo aunque se elimine el centro.

---

### 3. Asociación
En `TecnicoMantenimiento — NodoIoT`, ¿quién es dueño de quién? ¿Por qué se
modela como N:M y no como composición?

> _Tu respuesta:_Ninguno es dueño del otro, porque el técnico y el nodo pueden existir de manera independiente. Se modela como una relación N:M porque un técnico puede encargarse de varios nodos y un mismo nodo puede recibir mantenimiento de varios técnicos.

---

### 4. Dependencia
¿Por qué `Lectura` **depende** de `ValidadorLectura` en lugar de **tenerlo**
como atributo? ¿Qué diferencia práctica hay entre pasar un `ValidadorLectura`
como parámetro versus guardarlo en un campo?

> _Tu respuesta:_Lectura depende de ValidadorLectura porque lo utiliza para comprobar los datos, pero no necesita guardarlo como atributo. Al pasarlo como parámetro, se usa únicamente cuando hace falta; si se guardara en un campo, quedaría almacenada una referencia al validador durante la vida del objeto.

---

### 5. Listas
En este proyecto se usan dos estructuras de datos distintas:
- `int[] ultimasLecturas` en `Sensor`
- `ArrayList<Sensor>` en `NodoIoT`

Explica por qué en cada caso se eligió esa estructura y no la otra. ¿Qué
ventaja tiene el `int[]` con buffer circular frente a un `ArrayList` para el
historial de lecturas?

> _Tu respuesta:_int[] ultimasLecturas tiene un tamaño fijo y permite almacenar las lecturas recientes mediante un buffer circular, reutilizando las posiciones sin crear nuevas estructuras. En cambio, ArrayList<Sensor> permite agregar o quitar sensores del nodo dinámicamente. El buffer circular es más eficiente para conservar un historial limitado, porque evita redimensionamientos y mantiene controlado el uso de memoria.