import java.util.Iterator;
import java.util.ArrayList;
import java.time.LocalDate;

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
        int posicionTareaActual = 0;
        while (posicionTareaActual < tareas.size()) {
            System.out.println((posicionTareaActual+1) + ". " + tareas.get(posicionTareaActual).getCadenaFormateada());
            posicionTareaActual++;
        }
    }

    public void mostrarTareasNumeradasIterador()
    {
        int numeroPosicion = 1;
        Iterator<Tarea> it = tareas.iterator();
        while (it.hasNext()){
            Tarea tarea = it.next();
            System.out.println(tarea.getCadenaFormateadaIterador(numeroPosicion));
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

    /**
     * Imprime todos los datos de la tarea con mayor prioridad. Si hay empate,
     * imprime la �ltima encontrada. Si no hay tareas no imprime nada.
     */
    public void imprimirTareaMasPrioritaria(){
        if (tareas.size() > 0){
            Tarea tareaMasPrioritaria = tareas.get(0);
            for(Tarea tarea : tareas){
                if(tarea.getPrioridad() >= tareaMasPrioritaria.getPrioridad()){
                    tareaMasPrioritaria = tarea;
                }
            }
            System.out.println(tareaMasPrioritaria.getCadenaFormateada());
        }
    }
    
    
    /**
     * Imprime todos los datos de la tarea con menor prioridad. Si hay empate,
     * imprime por pantalla los datos de la �ltima encontrada. Si no hay tareas,
     * no imprime nada
     */
    public void imprimirTareaMenosPrioritaria(){
        if (tareas.size() > 0){
            Tarea tareaMenosPrioritaria = tareas.get(0);
            for(Tarea tarea : tareas){
                if(tarea.getPrioridad() >= tareaMenosPrioritaria.getPrioridad()){
                    tareaMenosPrioritaria = tarea;
                }
            }
            System.out.println(tareaMenosPrioritaria.getCadenaFormateada());
        }
    }
    
    /**
     * Muestra la tarea con la fecha tope m�s inminente. Si hay empate,
     * muestra todas las empatadas. Si no hay ninguna con fecha tope no muestra nada
     */
    public void muestraTareaMasInminente(){
        ArrayList<Tarea> inminentes = new ArrayList<>();
        if (tareas.size() > 0){
            Tarea tareaMasInminente = new Tarea("");
            tareaMasInminente.setFechaLimite(9999,12,31);
            for(Tarea tarea : tareas){
                if(tarea.getFechaLimite() != null && tarea.getFechaLimite().isAfter(LocalDate.now())){
                    if(tarea.getFechaLimite().isBefore(tareaMasInminente.getFechaLimite())){
                        inminentes = new ArrayList<>();
                        tareaMasInminente = tarea;
                        inminentes.add(tareaMasInminente);
                    }

                    else if(tarea.getFechaLimite().equals(tareaMasInminente.getFechaLimite())){
                        inminentes.add(tareaMasInminente);
                    }
                }
            }
            for(Tarea tarea : inminentes){
                System.out.println(tarea.getCadenaFormateada());
            }  
        }            
    } 
    
    // Posibles metodos de fijado de fecha limite
    
    /**
     * Metodo que permite una fecha limite a la tarea indicada por parametro. La fecha limite se
     * introduce como cadena de texto con formato "yyyy-mm-dd".
     */
    public void fijarFechaLimite(int indiceTarea, String nuevaFechaLimite){
        tareas.get(indiceTarea).setFechaLimite(nuevaFechaLimite);
    }
    
    /**
     * Metodo que permite una fecha limite a la tarea indicada por parametro. La fecha limite se
     * introduce como cadena de texto con formato "yyyy-mm-dd".
     */
    public void fijarFechaLimite(int indiceTarea, int ano, int mes, int dia){
        tareas.get(indiceTarea).setFechaLimite(ano,mes,dia);
    }
}

