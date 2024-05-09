package com.code.devtask.unit.task.usecase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.code.devtask.task.domain.Task;
import com.code.devtask.task.domain.TaskRepository;
import com.code.devtask.task.usecase.TaskUseCase;

@DisplayName("タスクのユースケーステスト")
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TaskUseCaseTest {

    @Autowired
    @InjectMocks
    private TaskUseCase useCase;

    @Mock
    private TaskRepository taskRepository;

    @Test
    @DisplayName("複数登録されているタスクをすべて取得する")
    public void testGetMultipleTasks() {
        // Arrange
        List<Task> expectedTasks = new ArrayList<Task>();
        Task taskA = new Task("title of taskA", "description of taskA");
        Task taskB = new Task("title of taskB", "description of taskB");
        Task taskC = new Task("title of taskC", "description of taskC");
        Task taskD = new Task("title of taskD", "description of taskD");
        Collections.addAll(expectedTasks, taskA, taskB, taskC, taskD);
        // Define mock behavior
        Mockito.when(taskRepository.fetchTasks()).thenReturn(expectedTasks);

        // Act
        List<Task> actualTasks = useCase.getTasks();

        // Assert
        assertEquals(4, actualTasks.size());
        Mockito.verify(taskRepository, Mockito.times(1)).fetchTasks();

        assertThat(actualTasks, samePropertyValuesAs(expectedTasks));
    }

    @Test
    @DisplayName("1件だけ登録されているタスクを取得する")
    public void testGetOneTask() {

        // Arrange
        List<Task> expectedTasks = new ArrayList<Task>();
        Task taskA = new Task("title of taskA", "description of taskA");
        Collections.addAll(expectedTasks, taskA);
        // Define mock behavior
        Mockito.when(taskRepository.fetchTasks()).thenReturn(expectedTasks);

        // Act
        List<Task> actualTasks = useCase.getTasks();

        // Assert
        assertEquals(1, actualTasks.size());
        Mockito.verify(taskRepository, Mockito.times(1)).fetchTasks();
        // impl 6
        assertThat(actualTasks, samePropertyValuesAs(expectedTasks));
    }

    @Test
    @DisplayName("タスクを取得しようとするが、登録されていないため、空のリストを返却する")
    public void testGetNoTask() {

        // Arrange
        List<Task> expectedTasks = new ArrayList<Task>();
        // Define mock behavior
        Mockito.when(taskRepository.fetchTasks()).thenReturn(expectedTasks);

        // Act
        List<Task> actualTasks = useCase.getTasks();

        // Assert
        assertEquals(0, actualTasks.size());
        Mockito.verify(taskRepository, Mockito.times(1)).fetchTasks();
        // impl 6
        assertThat(actualTasks, equalTo(expectedTasks));
    }
}
