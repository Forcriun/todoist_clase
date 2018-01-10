import java.util.Iterator;
import java.util.ArrayList;

/**
 * Clase que permite almacenar las tareas pendientes que tenemos por hacer.
 */
class Todoist 
{

    // Almacena nuestras tareas
    private ArrayList<Tarea> tareas;

    /**
     * Constructor de la clase Todoist. Crea un gestor con las 3 tareas vacías.
     */
    public Todoist()
    {
        tareas = new ArrayList<Tarea>();
    }

    /**
     * Inserta una nueva tarea
     */
    public void addTarea(String nombreTarea)
    {
        tareas.add(new Tarea(nombreTarea));
    }

    /** 
     * Metodo que imprime todas las tareas existentes, una por linea.
     * El metodo imprime el numero de posicion de la tarea antes del
     * nombre de la tarea.
     */
    public void mostrarTareasNumeradas()
    {
        int numeroPosicion = 1;
        for (Tarea tarea : tareas){
            System.out.println(tarea.getCadenaFormateada(numeroPosicion));
            numeroPosicion++;
        }
    }

    public void mostrarTareasNumeradasIterador()
    {
        int numeroPosicion = 1;
        Iterator<Tarea> it = tareas.iterator();
        while (it.hasNext()){
            Tarea tarea = it.next();
            System.out.println(tarea.getCadenaFormateada(numeroPosicion));
            numeroPosicion++;
        }
    }

    /**
     * Marca como completada la tarea indicada como parametro. Por ejemplo,
     * si el parámetro es 0 marca como completada la primera tarea, si es 1 la
     * segunda, etc.
     */
    public void marcarComoCompletada(int indiceTarea)
    {
        tareas.get(indiceTarea).setCompletada();
    }

    /**
     * Metodo que permite establecer la prioridad deseada de la tarea
     * indicada por parametro.
     */
    public void fijarNuevaPrioridad(int indiceTarea, int nuevaPrioridad){
        tareas.get(indiceTarea).setPrioridad(nuevaPrioridad);
    }

    /**
     * Metodo que muestra por pantalla la informacion de las tareas en 
     * la lista: numero de tareas completadas y su porcentaje, numero de
     * tareas sin completar y su porcentaje, y total de tareas.
     */
    public void mostrarInfoTareas(){
        int numTareasCompletadas = 0;
        int numTareasSinCompletar = 0;        
        for (Tarea tarea : tareas){
            if(tarea.getCompletada()){
                numTareasCompletadas++;
            }
            else{                
                numTareasSinCompletar++;
            }
        }
        System.out.println("Tareas completadas: " + numTareasCompletadas + "("+ (numTareasCompletadas*100)/tareas.size() +"%)");
        System.out.println("Tareas sin completar: " + numTareasSinCompletar + "("+ (numTareasSinCompletar*100)/tareas.size() +"%)");
        System.out.println("Total de tareas: " + tareas.size());
    }
}

