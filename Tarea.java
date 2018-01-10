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

    /**
     * Constructor de la clase
     */
    public Tarea(String cadena)
    {
        completada = false;
        this.cadena = cadena;
        prioridad = 1;
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
            cadenaFormateada = numeroPosicion + ". [ ] " + cadena + ". Prioridad: " + prioridad;
        }
        return cadenaFormateada;
    }

    /**
     * Marca la tarea como completada.
     */
    public void setCompletada(){
        completada = true;
    }
    
    /**
     * @return Devuelve la prioridad de la tarea.
     */
    public int getPrioridad(){
        return prioridad;
    }
    
    /**
     * Establece la prioridad deseada a la tarea. Si no es un valor legal la prioridad no cambia.
     * @param La nueva prioridad de la tarea.
     */
    public void setPrioridad(int nuevaPrioridad){
        if (nuevaPrioridad >=1 && nuevaPrioridad <= 5)
        prioridad = nuevaPrioridad;
    }
}
