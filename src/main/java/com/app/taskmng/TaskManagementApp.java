package com.app.taskmng;

import java.util.Scanner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TaskManagementApp {

	public static void main(String[] args) {
		// Cargar el archivo de configuración de Spring
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// Obtener el bean del servicio de tareas
		TaskService taskService = context.getBean("taskService", TaskService.class);

		// Crear un scanner para la entrada del usuario
		Scanner scanner = new Scanner(System.in);
		boolean active = true;

		// Menú de opciones
		while (active) {
			System.out.println("__________________________________________");
			System.out.println("\nBienvenido al Sistema de Gestion de Tareas");
			System.out.println("__________________________________________");
			System.out.println("\n1. Mostrar todas las tareas.");
			System.out.println("\n2. Mostrar una tarea por su descripci�n.");
			System.out.println("\n3. Visualizar numero de tareas.");
			System.out.println("\n4. Salir");
			System.out.print("\nIngrese su opcion: ");
			int opcion = scanner.nextInt();
			scanner.nextLine(); // Consumir el salto de línea
			System.out.println("\n__________________________________________\n");

			switch (opcion) {
			case 1:
				System.out.println("\n___________| Todas las tareas |___________\n");
				System.out.println(taskService.getAllTasks());
				break;
			case 2:
				System.out.println("___________| Buscar tarea por descripci�n |___________");
				System.out.print("\nIngrese la descripcion de la tarea: ");
				String data = scanner.nextLine();
				Task task = taskService.getTask(data);
				if (task != null) {
					System.out.println("\nTarea encontrada: " + task);
				} else {
					System.out.println("\nERROR : No se encontro ninguna tarea con ese nombre.");
				}
				break;
			case 3:
				System.out.println("___________| Numero de tareas|___________");
				System.out.println("\nNumero de tareas : "+ taskService.countTasks());
				break;
			case 4 : 
				System.out.println("\nSaliendo del Sistema de Gestion de Tareas. ¡Hasta luego!");
				active = false;
				scanner.close();
				context.close();
				break;
			default:
				System.out.println("\nERROR : Opción inválida. Por favor, ingrese una opción válida.");
				break;
			}
		}
	}
}