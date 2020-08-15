// copyright www.codejava.net
package net.codejava;
 
import java.sql.Date;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional
public class TaskService {
 
    @Autowired
    private TaskRepository repo;
     
    public List<Task> listAll() {
    	
        return repo.taskAll();			
    } 
    
    public List<Task> listfilterByStatus(int id) {
    	
    	
        return repo.filterByStatus(id);			
    } 
    
    public List<Task> listfilterByPriority(int id) {
    	
    	
        return repo.filterByPriority(id);			
    }
    public List<Task> searchFilter(String str) {

    	
        return repo.searchByString(str);			
    }
    
    public List<Task> listfilterByCreateDate(Date from, Date to) {
    	
    	
        return repo.filterByCreateDate(from, to);
    }
    public List<Task> listfilterByDueDate(Date from, Date to) {
    	
    	
        return repo.filterByDueDate(from, to);			
    }

     
    public void save(Task task) {
    	
        repo.save(task);


    }
    
    public void updateDate(Task task) {
    	 repo.updateAddTime(task.getId());
    }
     
    public Task get(long id) {
    	
        return repo.findById(id).get();
    }
     
    
    public void delete(long id) {
    	
        repo.deleteById(id);
    }
}