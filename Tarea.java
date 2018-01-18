import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        fechaLimite = null;
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
    public String getCadenaFormateada(){
        String cadenaFormateada = cadena + ". Prioridad: " + prioridad + ".";
        if(fechaLimite != null){
            cadenaFormateada = cadena + ". Prioridad: " + prioridad + ". Fecha límite: " + fechaEsp(fechaLimite);
        }
        if (completada){
            cadenaFormateada = "[X] " + cadenaFormateada;
        }
        else {
            cadenaFormateada = "[ ] " + cadenaFormateada;
        }
        return cadenaFormateada;
    }

    /**
     * Metodo para dar formato español a las fechas de las tareas.
     * @param fechaAFormatear La fecha a formatear.
     * @return La cadena de la fecha ya formateada.
     */
    public String fechaEsp(LocalDate fechaAFormatear){
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd' of 'MMMM' of 'yyyy");        
        String fechaEspanol = fechaAFormatear.format(formateador);
        return fechaEspanol;
    }

    /**
     * Metodo rudimentario con el que conseguiamos obtener el mes en formato español.
     * 
    public String mesEspañol()
    {
    String mes = "" + fechaLimite.getMonth();
    switch (mes){
    case "JANUARY": mes = "Enero"; break;
    case "FEBRUARY": mes = "Febrero"; break;
    case "MARCH": mes = "Marzo"; break;
    case "APRIL": mes = "Abril"; break;
    case "MAY": mes = "Mayo"; break;
    case "JUNE": mes = "Junio"; break;
    case "JULY": mes = "Julio"; break;
    case "AUGUST": mes = "Agosto"; break;
    case "SEPTEMBER": mes = "Septiembre"; break;
    case "OCTOBER": mes = "Octubre"; break;
    case "NOVEMBER": mes = "Noviembre"; break;
    case "DECEMBER": mes = "Diciembre"; break;
    }
    return mes;
    }
     */

    /**
     * @return Devuelve la tarea. Si la tarea esta completada, entonces muestra
     * un "[X]" delante de la tarea; si no esta completada muestra un "[ ]"
     */
    public String getCadenaFormateadaIterador(int numeroPosicion){
        String cadenaFormateada = cadena + ". Prioridad: " + prioridad + ". Fecha límite: " + fechaLimite;
        if (completada){
            cadenaFormateada = numeroPosicion + ".- " + "[X] " + cadenaFormateada;
        }
        else {
            cadenaFormateada = numeroPosicion + ".- " +  "[ ] " + cadenaFormateada;
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
