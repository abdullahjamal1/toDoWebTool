package net.codejava;
 
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
public interface TaskRepository extends JpaRepository<Task, Long> {
	
		public static String subQuery = "SELECT"
				+ " s.status, p.priority, t.id , t.task_title, t.task_description, t.status_id, t.priority_id, t.add_date, t.due_date "
				+ " FROM task t "
				+ " JOIN status_table s ON t.status_id = s.id "
				+ " JOIN priority_table p ON t.priority_id = p.id ";
 
		public static String queryResult = subQuery + ";";

		@Query(value = queryResult , nativeQuery = true)
		public List<Task> taskAll();
		
		public static String timeUpdate = "UPDATE task SET task.add_date = GETDATE() WHERE task.id = :taskId ; ";
		@Query(value = queryResult , nativeQuery = true)
		public void updateAddTime(@Param("taskId") Long id);

		
	
		public static String searchQuery = subQuery
			+ " WHERE t.task_title LIKE '%:str%' ; ";
	
		@Query(value = searchQuery , nativeQuery = true)
		public List<Task> searchByString(@Param("str") String str);
		
		
	
		public static String statusFilterQuery = subQuery 
				+  " WHERE t.status_id = :statusId ; ";
	
		@Query(value = statusFilterQuery , nativeQuery = true)
		public List<Task> filterByStatus(@Param("statusId") int status_id);
		
		
		public static String priorityFilterQuery = subQuery 
				+ " WHERE t.priority_id = :priorityId ;";
	
		@Query(value = priorityFilterQuery , nativeQuery = true)
		public List<Task> filterByPriority(@Param("priorityId") int priority_id);
		
		
		
		public static String CreateDateFilterQuery = subQuery 
				+ " WHERE t.add_date >= :fromDate AND t.add_date <= :toDate ; ";
		
		@Query(value = CreateDateFilterQuery , nativeQuery = true)
		public List<Task> filterByCreateDate(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
			
			
			
		public static String dueDateFilterQuery = subQuery 
				+ " WHERE t.due_date >= :fromDate AND t.due_date <= :toDate ; ";
		
		@Query(value = dueDateFilterQuery , nativeQuery = true)
		public List<Task> filterByDueDate(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
			
			
	
	
}