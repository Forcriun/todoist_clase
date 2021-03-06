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
        System.out.println("Mostramos la �ltima tarea de mayor prioridad:");
        System.out.println();
        todoist1.imprimirTareaMasPrioritaria();
        todoist1.imprimirTareaMenosPrioritaria();
    }

    @Test
    public void testInminentes()
    {
        Todoist todoist2 = new Todoist();
        System.out.println("Creamos una lista de 5 tareas con fechas variadas y las mostramos por pantalla:");
        System.out.println();   
        todoist2.addTarea("despertar");
        todoist2.addTarea("desayunar");
        todoist2.addTarea("marchar");
        todoist2.addTarea("aprender");
        todoist2.addTarea("volver");
        todoist2.addTarea("comer");
        todoist2.addTarea("sestear");
        todoist2.addTarea("pasear");
        todoist2.addTarea("estudiar");
        todoist2.addTarea("cenar");
        todoist2.addTarea("procrastinar");
        todoist2.addTarea("dormir");
        todoist2.fijarFechaLimite(1, 2018, 7, 22);
        todoist2.fijarFechaLimite(2, 2016, 8, 13);
        todoist2.fijarFechaLimite(3, 2019, 5, 5);
        todoist2.fijarFechaLimite(4, 2021, 11, 30);
        todoist2.fijarFechaLimite(6, 2018, 7, 22);
        todoist2.fijarFechaLimite(7, 2019, 5, 5);
        todoist2.fijarFechaLimite(8, 2023, 2, 18);
        todoist2.fijarFechaLimite(11, 2018, 7, 22);
        todoist2.mostrarTareasNumeradas();
        System.out.println();
        System.out.println();
        System.out.println("Mostramos la o las m�s inminentes por pantalla:");
        System.out.println();
        todoist2.muestraTareaMasInminente();
    }
}



