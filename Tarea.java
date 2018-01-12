import java.time.LocalDate;

/**
 * Clase que representa las tareas almacenadas en nuestra lista de
 * tareas Todoist. Las tareas creadas disponen de un estado de compleción
 * y de una cadena que las describe.
 */
public class Tarea
{
    // Estado de la tarea
    private boolean completada;
    // La cadena que describe la tarea
    private String cadena;
    // La prioridad de la tarea
    private int prioridad;
    // La fecha de creacion de la tarea
    private LocalDate fechaCreacion;
    // La fecha limite de la tarea
    private LocalDate fechaLimite;

    /**
     * Constructor de la clase
     */
    public Tarea(String cadena)
    {
        completada = false;
        this.cadena = cadena;
        prioridad = 1;
        fechaCreacion = LocalDate.now();
        //fechaLimite = null;
    }

    /**
     * @return Devuelve el estado de la tarea.
     */
    public boolean getCompletada(){
        return completada;
    }

    /**
     * @return Devuelve el contenido de la tarea.
     */
    public String getCadena(){
        return cadena;
    }

    /**
     * @return Devuelve la tarea. Si la tarea esta completada, entonces muestra
     * un "[X]" delante de la tarea; si no esta completada muestra un "[ ]"
     */
    public String getCadenaFormateada(int numeroPosicion){
        String cadenaFormateada = "";
        if (completada){
            cadenaFormateada = numeroPosicion + ". [X] " + cadena + ". Prioridad: " + prioridad;
        }
        else {
            cadenaFormateada = numeroPosicion + ". [ ] " + cadena + ". Prioridad: " + prioridad + ". Fecha límite: " + fechaLimite;
        }
        return cadenaFormateada;
    }

    /**
     * @return Devuelve la prioridad de la tarea.
     */
    public int getPrioridad(){
        return prioridad;
    }

    /**
     * @return Devuelve la fecha de creacion de la tarea.
     */
    public LocalDate getFechaCreacion(){
        return fechaCreacion;
    }

    /**
     * @return Devuelve la fecha limite de la tarea.
     */
    public LocalDate getFechaLimite(){
        return fechaLimite;
    }

    /**
     * Marca la tarea como completada.
     */
    public void setCompletada(){
        completada = true;
    }

    /**
     * Establece la prioridad deseada a la tarea. Si no es un valor legal la prioridad no cambia.
     * @param La nueva prioridad de la tarea.
     */
    public void setPrioridad(int nuevaPrioridad){
        if (nuevaPrioridad >=1 && nuevaPrioridad <= 5){
            prioridad = nuevaPrioridad;
        }
    }

    
    // Posibles metodos de fijado de fecha limite.
    
    /**
     * Marca la tarea como completada.
     */
    public void setFechaLimite(String nuevaFechaLimite){
        fechaLimite = LocalDate.parse(nuevaFechaLimite);
    }

    /**
     * Marca la tarea como completada.
     */
    public void setFechaLimite(int ano, int mes, int dia){
        fechaLimite = LocalDate.of(ano,mes,dia);
    }

    /**
    public void defaultValuesTests(){
    System.out.println(fechaCreacion);
    System.out.println(fechaLimite);
    }
     */
}
