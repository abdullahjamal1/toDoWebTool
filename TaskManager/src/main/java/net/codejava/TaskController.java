package net.codejava;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class TaskController {
 
    @Autowired
    private TaskService service;

	public TaskService getService() {
		
		return service;
	}

	public void setService(TaskService service) {
		
		this.service = service;
	}
     
	@RequestMapping("/")
	
	public String viewHomePage(Model model) {
		
			
	    List<Task> listTasks = service.listAll();
	    
	    Task task = new Task();
		
		model.addAttribute("task", task);
	    
	    // returns list of all products from database in html
	    
	    model.addAttribute("listTasks", listTasks);
	   
	    return "index";
	}
	
	@RequestMapping("/filter")
	
	public String filterMenu( Model model) {
		
		Task task = new Task();
		
		model.addAttribute("task", task);

		return "filter_task";
	}
	@RequestMapping("/search/ ")
	
	public String search( @ModelAttribute ("task") Task task , Model model ) {
		
	    List<Task> listTasks = service.searchFilter(task.getTask_title());
	    
	    model.addAttribute("listTasks", listTasks);

		return "index";
	}
	
	@RequestMapping("/filter/status/")
	
	public String filterByStatus( @ModelAttribute ("task") Task task , Model model) {
		
	    List<Task> listTasks = service.listfilterByStatus(task.getStatus_id());
	    
	    model.addAttribute("listTasks", listTasks);

		return "index";
	}
	
	@RequestMapping("/filter/priority/")
	
	public String filterByPriority( @ModelAttribute ("task") Task task , Model model ) {
		
	    List<Task> listTasks = service.listfilterByPriority(task.getPriority_id());
	    
	    model.addAttribute("listTasks", listTasks);

		return "index";
	}
	
	@RequestMapping("/filter/createDate/")
	
	public String filterByCreateDate( @ModelAttribute ("task") Task task , Model model ) {
		
	    List<Task> listTasks = service.listfilterByCreateDate(task.getAddDate(), task.getDueDate());
	    
	    model.addAttribute("listTasks", listTasks);

		return "index";
	}
	
	@RequestMapping("/filter/dueDate/")
	
	public String filterByDueDate( @ModelAttribute ("task") Task task , Model model ) {
		
	    List<Task> listTasks = service.listfilterByDueDate(task.getAddDate(), task.getDueDate());
	    
	    model.addAttribute("listTasks", listTasks);

		return "index";
	}
	
	
	@RequestMapping("/new")
	
	public String showNewTaskPage(Model model) {
		
		Task task = new Task();
		
		model.addAttribute("task", task);
		
		return "new_task";
	}
	
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	
	public String saveTask( @ModelAttribute ("task") Task task) {

		service.save(task);
		//service.updateDate(task);
		
		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	
	public ModelAndView showEditTaskPage( @PathVariable (name = "id") int id) {

		ModelAndView mav = new ModelAndView("edit_task");
		
		Task task = service.get(id);
		
		mav.addObject("task", task);

		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	
	public String deleteTask(@PathVariable(name = "id") int id) {
		
	    service.delete(id);
	    
	    return "redirect:/";       
	}
	

}