package com.app.taskmng;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.logging.Logger;

@Service
public class TaskService implements TaskManagementService, InitializingBean, DisposableBean {

	Logger logger = Logger.getLogger(getClass().getName());
	private List<Task> tasks;

	@Autowired
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public Task getTask(String data) {
		for (Task task : tasks) {
			if (task.getDescription().equals(data)) {
				return task;
			}
		}
		return null;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// Metodo de inicializacion, se ejecutara¡ despues de que Spring haya creado el
				// bean
				logger.info("\n___________Iniciando gestor de tareas___________\n");
	}

	@Override
	public void destroy() {
		// Metodo de destruccion, se ejecutara¡ antes de que Spring destruya el bean
		logger.info("\n___________Finalizando gestor de tareas___________\n");
	}

	@Override
	public int countTasks() {
		return tasks.size();
	}

	@Override
	public List<Task> getAllTasks() {
		return tasks;
	}

}