package com.app.taskmng;

import java.util.List;

//Interfaz para un servicio de gestion de tareas
public interface TaskManagementService {

    Task getTask(String data);
    int countTasks();
    List<Task> getAllTasks();
}