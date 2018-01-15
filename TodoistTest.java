

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TodoistTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TodoistTest
{
    /**
     * Default constructor for test class TodoistTest
     */
    public TodoistTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void t1()
    {
        Todoist todoist1 = new Todoist();
        System.out.println("Creamos una lista con 4 tareas y las mostramos numeradas por pantalla:");
        System.out.println();
        todoist1.addTarea("limpiar");
        todoist1.addTarea("ordenar");
        todoist1.addTarea("fregar");
        todoist1.addTarea("comer");
        todoist1.mostrarTareasNumeradas();
        System.out.println();
        System.out.println("Marcamos como completada la segunda tarea y mostramos la lista por pantalla:");
        System.out.println();
        todoist1.marcarComoCompletada(1);
        todoist1.mostrarTareasNumeradas();
        System.out.println("Establecemos la prioridad de la tercera tarea a 3, y mostramos la lista por pantalla:");
        System.out.println();
        todoist1.fijarNuevaPrioridad(2,3);
        todoist1.mostrarTareasNumeradas();
        System.out.println();
        System.out.println("Mostramos por pantalla los parciales y totales de tareas en la lista:");
        System.out.println();
        todoist1.mostrarInfoTareas();
    }

    @Test
    public void test_prioridades()
    {
        Todoist todoist1 = new Todoist();
        System.out.println("Creamos una lista de 5 tareas con prioridades variadas:");
        System.out.println();
        todoist1.addTarea("lavar la ropa");
        todoist1.addTarea("fregar los platos");
        todoist1.addTarea("barrer el suelo");
        todoist1.addTarea("sacar la basura");
        todoist1.addTarea("dar de comer al gato");
        todoist1.fijarNuevaPrioridad(2, 3);
        todoist1.fijarNuevaPrioridad(3, 3);
        todoist1.fijarNuevaPrioridad(4, 2);
        todoist1.mostrarTareasNumeradas();
        System.out.println();
        System.out.println("Mostramos la última tarea de mayor prioridad:");
        System.out.println();
        todoist1.imprimirTareaMasPrioritaria();
        todoist1.imprimirTareaMenosPrioritaria();        
    }
}


